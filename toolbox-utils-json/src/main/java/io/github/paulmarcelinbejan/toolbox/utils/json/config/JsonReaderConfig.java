package io.github.paulmarcelinbejan.toolbox.utils.json.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;
import lombok.Getter;

public class JsonReaderConfig {
	
	public JsonReaderConfig(
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		
		this.jsonMapper = buildJsonMapper(
				enableDeserializationFeatures, 
				disableDeserializationFeatures, 
				modules, 
				deserializers);
	
	}
	
	public static final JsonReaderConfig DEFAULT = new JsonReaderConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(),
			Collections.emptyMap());
	
	@Getter
	private final JsonMapper jsonMapper;
	
	private static JsonMapper buildJsonMapper(
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules,
			Map<Class<?>, JsonDeserializer<?>> deserializers) {

		JsonMapper mapper = new JsonMapper();
		configureJsonMapper(mapper, enableDeserializationFeatures, disableDeserializationFeatures, modules, deserializers);
		return mapper;
		
	}
	
	private static void configureJsonMapper(JsonMapper mapper,
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
	
}
