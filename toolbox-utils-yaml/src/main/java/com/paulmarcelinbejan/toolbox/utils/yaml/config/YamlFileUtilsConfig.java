package com.paulmarcelinbejan.toolbox.utils.yaml.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactoryBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Getter;

public class YamlFileUtilsConfig {

	public YamlFileUtilsConfig(
			List<Module> modules,
			List<Feature> enableYamlGeneratorFeatures, 
			List<Feature> disableYamlGeneratorFeatures,
			YamlReaderConfig readerConfig, 
			YamlWriterConfig writerConfig) {
		this.modules = modules;
		this.enableYamlGeneratorFeatures = enableYamlGeneratorFeatures;
		this.disableYamlGeneratorFeatures = disableYamlGeneratorFeatures;
		this.readerConfig = readerConfig;
		this.writerConfig = writerConfig;
		yamlMapper = buildYamlMapper();
	}
	
	public static final YamlFileUtilsConfig DEFAULT = new YamlFileUtilsConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			YamlReaderConfig.DEFAULT, 
			YamlWriterConfig.DEFAULT);
	
	private final List<Module> modules;
	
	private final List<YAMLGenerator.Feature> enableYamlGeneratorFeatures;
	private final List<YAMLGenerator.Feature> disableYamlGeneratorFeatures;
	
	private final YamlReaderConfig readerConfig;
	private final YamlWriterConfig writerConfig;
	
	@Getter
	private final YAMLMapper yamlMapper;
	
	/**
	 * return a YAMLMapper configured with:
	 * <br> - modules
	 * <br> - serializers
	 * <br> - enabling serialization features
	 * <br> - disabling serialization feature
	 */
	private YAMLMapper buildYamlMapper() {
		YAMLMapper mapper = new YAMLMapper(buildYamlFactory());
		configureYamlMapper(mapper);
		return mapper;
	}

	private void configureYamlMapper(YAMLMapper mapper) {
		if(modules != null && !modules.isEmpty()) {
			ObjectMapperUtils.registerModules(mapper, modules);
		}
		
		configureReader(mapper);
		configureWriter(mapper);
	}
	
	private YAMLFactory buildYamlFactory() {
		YAMLFactoryBuilder yamlFactoryBuilder = YAMLFactory.builder();
		
		if(enableYamlGeneratorFeatures != null && !enableYamlGeneratorFeatures.isEmpty()) {
			enableYamlGeneratorFeatures.forEach(yamlFactoryBuilder::enable);
		}
		
		if(disableYamlGeneratorFeatures != null && !disableYamlGeneratorFeatures.isEmpty()) {
			disableYamlGeneratorFeatures.forEach(yamlFactoryBuilder::disable);
		}
		
		return yamlFactoryBuilder.build();
	}
	
	private void configureReader(YAMLMapper mapper) {
		Map<Class<?>, JsonDeserializer<?>> deserializers = readerConfig.getDeserializers();
		if(deserializers != null && !deserializers.isEmpty()) {
			ObjectMapperUtils.registerDeserializers(mapper, deserializers);
		}
		
		List<DeserializationFeature> enableDeserializationFeatures = readerConfig.getEnableDeserializationFeatures();
		if(enableDeserializationFeatures != null && !enableDeserializationFeatures.isEmpty()) {
			ObjectMapperUtils.enableDeserializationFeatures(mapper, enableDeserializationFeatures);
		}
		
		List<DeserializationFeature> disableDeserializationFeatures = readerConfig.getDisableDeserializationFeatures();
		if(disableDeserializationFeatures != null && !disableDeserializationFeatures.isEmpty()) {
			ObjectMapperUtils.disableDeserializationFeatures(mapper, disableDeserializationFeatures);
		}
	}
	
	private void configureWriter(YAMLMapper mapper) {
		Map<Class<?>, JsonSerializer<?>> serializers = writerConfig.getSerializers();
		if(serializers != null && !serializers.isEmpty()) {
			ObjectMapperUtils.registerSerializers(mapper, serializers);
		}
		
		List<SerializationFeature> enableSerializationFeatures = writerConfig.getEnableSerializationFeatures();
		if(enableSerializationFeatures != null && !enableSerializationFeatures.isEmpty()) {
			ObjectMapperUtils.enableSerializationFeatures(mapper, enableSerializationFeatures);
		}
		
		List<SerializationFeature> disableSerializationFeatures = writerConfig.getDisableSerializationFeatures();
		if(disableSerializationFeatures != null && !disableSerializationFeatures.isEmpty()) {
			ObjectMapperUtils.disableSerializationFeatures(mapper, disableSerializationFeatures);
		}
	}
	
}
