package com.paulmarcelinbejan.toolbox.utils.json.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Getter;

public class JsonReaderConfig {

	public JsonReaderConfig(Map<Class<?>, JsonDeserializer<?>> deserializers) {
		this.deserializers = deserializers != null ? deserializers : new HashMap<>();
		this.jsonMapper = buildJsonMapper();
	}
	
	public static final JsonReaderConfig DEFAULT = new JsonReaderConfig(new HashMap<>());
	
	@Getter
	private final Map<Class<?>, JsonDeserializer<?>> deserializers;
	
	@Getter
	private final JsonMapper jsonMapper;
	
	/**
	 * return a JsonMapper configured with deserializers (if any)
	 */
	private JsonMapper buildJsonMapper() {
		JsonMapper mapper = new JsonMapper();
		
		if(!deserializers.isEmpty()) {
			ObjectMapperUtils.registerDeserializers(mapper, deserializers);
		}
		
		return mapper;
	}
	
}
