package io.github.paulmarcelinbejan.toolbox.utils.yaml.config;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactoryBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.github.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;
import lombok.Getter;

public class YamlReaderConfig {

	public YamlReaderConfig(
			List<YAMLGenerator.Feature> enableYamlGeneratorFeatures,
			List<YAMLGenerator.Feature> disableYamlGeneratorFeatures,
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		
		this.yamlMapper = buildYamlMapper(
				enableYamlGeneratorFeatures, 
				disableYamlGeneratorFeatures, 
				enableDeserializationFeatures, 
				disableDeserializationFeatures, 
				modules, 
				deserializers);
	}
	
	public static final YamlReaderConfig DEFAULT = new YamlReaderConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			List.of(ACCEPT_SINGLE_VALUE_AS_ARRAY), 
			List.of(FAIL_ON_UNKNOWN_PROPERTIES),
			Collections.emptyList(),
			Collections.emptyMap());
	
	@Getter
	private final YAMLMapper yamlMapper;
	
	/**
	 * return a YAMLMapper with:
	 * <br> - YAMLGenerator features enabled
	 * <br> - YAMLGenerator features disabled
	 * <br> - Deserialization features enabled
	 * <br> - Deserialization features disabled
	 * <br> - Modules registered
	 * <br> - Deserializers registered
	 */
	private static YAMLMapper buildYamlMapper(
			List<YAMLGenerator.Feature> enableYamlGeneratorFeatures,
			List<YAMLGenerator.Feature> disableYamlGeneratorFeatures,
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		
		YAMLFactory yamlFactory = buildYamlFactory(enableYamlGeneratorFeatures, disableYamlGeneratorFeatures);
		YAMLMapper mapper = new YAMLMapper(yamlFactory);
		configureYamlMapper(mapper, enableDeserializationFeatures, disableDeserializationFeatures, modules, deserializers);
		return mapper;
		
	}

	private static void configureYamlMapper(YAMLMapper mapper,
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		
		if(enableDeserializationFeatures != null && !enableDeserializationFeatures.isEmpty()) {
			ObjectMapperUtils.enableDeserializationFeatures(mapper, enableDeserializationFeatures);
		}
		
		if(disableDeserializationFeatures != null && !disableDeserializationFeatures.isEmpty()) {
			ObjectMapperUtils.disableDeserializationFeatures(mapper, disableDeserializationFeatures);
		}
		
		if(modules != null && !modules.isEmpty()) {
			ObjectMapperUtils.registerModules(mapper, modules);
		}
		
		if(deserializers != null && !deserializers.isEmpty()) {
			ObjectMapperUtils.registerDeserializers(mapper, deserializers);
		}
		
	}
	
	private static YAMLFactory buildYamlFactory(
			List<YAMLGenerator.Feature> enableYamlGeneratorFeatures,
			List<YAMLGenerator.Feature> disableYamlGeneratorFeatures) {
		
		YAMLFactoryBuilder yamlFactoryBuilder = YAMLFactory.builder();
		
		if(enableYamlGeneratorFeatures != null && !enableYamlGeneratorFeatures.isEmpty()) {
			enableYamlGeneratorFeatures.forEach(yamlFactoryBuilder::enable);
		}
		
		if(disableYamlGeneratorFeatures != null && !disableYamlGeneratorFeatures.isEmpty()) {
			disableYamlGeneratorFeatures.forEach(yamlFactoryBuilder::disable);
		}
		
		return yamlFactoryBuilder.build();
		
	}
	
}
