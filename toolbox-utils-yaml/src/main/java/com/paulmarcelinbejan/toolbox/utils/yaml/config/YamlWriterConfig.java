package com.paulmarcelinbejan.toolbox.utils.yaml.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Getter;

@Getter
public class YamlWriterConfig {

	public YamlWriterConfig(
			Map<Class<?>, JsonSerializer<?>> serializers,
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures) {
		this.serializers = serializers;
		this.enableSerializationFeatures = enableSerializationFeatures;
		this.disableSerializationFeatures = disableSerializationFeatures;
	}
	
	public static final YamlWriterConfig DEFAULT = new YamlWriterConfig(Collections.emptyMap(), Collections.emptyList(), Collections.emptyList());
	
	private final Map<Class<?>, JsonSerializer<?>> serializers;
	
	private final List<SerializationFeature> enableSerializationFeatures;
	
	private final List<SerializationFeature> disableSerializationFeatures;
	
}
