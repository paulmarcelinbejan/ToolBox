package com.paulmarcelinbejan.toolbox.utils.yaml.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactoryBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Getter;

@Getter
public class YamlWriterConfig {

	public YamlWriterConfig(
			List<YAMLGenerator.Feature> enableYamlGeneratorFeatures,
			List<YAMLGenerator.Feature> disableYamlGeneratorFeatures,
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		this.yamlMapper = buildYamlMapper(
				enableYamlGeneratorFeatures, 
				disableYamlGeneratorFeatures, 
				enableSerializationFeatures, 
				disableSerializationFeatures, 
				modules, 
				serializers);
		
	}
	
	public static final YamlWriterConfig DEFAULT = new YamlWriterConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyMap());
	
	@Getter
	private final YAMLMapper yamlMapper;
	
	/**
	 * return a YAMLMapper with:
	 * <br> - YAMLGenerator features enabled
	 * <br> - YAMLGenerator features disabled
	 * <br> - Serialization features enabled
	 * <br> - Serialization features disabled
	 * <br> - Modules registered
	 * <br> - Serializers registered
	 */
	private YAMLMapper buildYamlMapper(
			List<YAMLGenerator.Feature> enableYamlGeneratorFeatures,
			List<YAMLGenerator.Feature> disableYamlGeneratorFeatures,
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		YAMLFactory yamlFactory = buildYamlFactory(enableYamlGeneratorFeatures, disableYamlGeneratorFeatures);
		YAMLMapper mapper = new YAMLMapper(yamlFactory);
		configureYamlMapper(mapper, enableSerializationFeatures, disableSerializationFeatures, modules, serializers);
		return mapper;
		
	}

	private void configureYamlMapper(YAMLMapper mapper, 
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		if(enableSerializationFeatures != null && !enableSerializationFeatures.isEmpty()) {
			ObjectMapperUtils.enableSerializationFeatures(mapper, enableSerializationFeatures);
		}
		
		if(disableSerializationFeatures != null && !disableSerializationFeatures.isEmpty()) {
			ObjectMapperUtils.disableSerializationFeatures(mapper, disableSerializationFeatures);
		}
		
		if(modules != null && !modules.isEmpty()) {
			ObjectMapperUtils.registerModules(mapper, modules);
		}
		
		if(serializers != null && !serializers.isEmpty()) {
			ObjectMapperUtils.registerSerializers(mapper, serializers);
		}
		
	}
	
	private YAMLFactory buildYamlFactory(
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
