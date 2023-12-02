package com.paulmarcelinbejan.toolbox.utils.json.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Getter;

public class JsonWriterConfig {

	public JsonWriterConfig(
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		this.jsonMapper = buildJsonMapper(
				enableSerializationFeatures, 
				disableSerializationFeatures, 
				modules, 
				serializers);
		
	}
	
	public static final JsonWriterConfig DEFAULT = new JsonWriterConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(),
			Collections.emptyMap());
	
	@Getter
	private final JsonMapper jsonMapper;
	
	/**
	 * return a JsonMapper configured with serializers (if any)
	 */
	private static JsonMapper buildJsonMapper(
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		JsonMapper mapper = new JsonMapper();
		configureJsonMapper(mapper, enableSerializationFeatures, disableSerializationFeatures, modules, serializers);
		return mapper;
		
	}
	
	private static void configureJsonMapper(JsonMapper mapper, 
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
	
}
