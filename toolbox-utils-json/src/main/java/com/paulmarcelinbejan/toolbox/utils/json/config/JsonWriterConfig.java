package com.paulmarcelinbejan.toolbox.utils.json.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Getter;

public class JsonWriterConfig {

	public JsonWriterConfig(Map<Class<?>, JsonSerializer<?>> serializers) {
		this.serializers = serializers != null ? serializers : new HashMap<>();
		this.jsonMapper = buildJsonMapper();
	}
	
	public static final JsonWriterConfig DEFAULT = new JsonWriterConfig(new HashMap<>());
	
	@Getter
	private final Map<Class<?>, JsonSerializer<?>> serializers;
	
	@Getter
	private final JsonMapper jsonMapper;
	
	/**
	 * return a JsonMapper configured with serializers (if any)
	 */
	private JsonMapper buildJsonMapper() {
		JsonMapper mapper = new JsonMapper();
		
		if(!serializers.isEmpty()) {
			ObjectMapperUtils.registerSerializers(mapper, serializers);
		}
		
		return mapper;
	}
	
}
