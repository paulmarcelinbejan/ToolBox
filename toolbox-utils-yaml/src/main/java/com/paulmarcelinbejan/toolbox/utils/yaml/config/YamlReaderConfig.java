package com.paulmarcelinbejan.toolbox.utils.yaml.config;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.Getter;

@Getter
public class YamlReaderConfig {

	public YamlReaderConfig(Map<Class<?>, JsonDeserializer<?>> deserializers,
							List<DeserializationFeature> enableDeserializationFeatures,
							List<DeserializationFeature> disableDeserializationFeatures) {
		this.deserializers = deserializers;
		this.enableDeserializationFeatures = enableDeserializationFeatures;
		this.disableDeserializationFeatures = disableDeserializationFeatures;
	}
	
	public static final YamlReaderConfig DEFAULT = new YamlReaderConfig(
			Collections.emptyMap(), 
			List.of(ACCEPT_SINGLE_VALUE_AS_ARRAY), 
			List.of(FAIL_ON_UNKNOWN_PROPERTIES));
	
	private final Map<Class<?>, JsonDeserializer<?>> deserializers;
	
	private final List<DeserializationFeature> enableDeserializationFeatures;
	
	private final List<DeserializationFeature> disableDeserializationFeatures;
	
}
