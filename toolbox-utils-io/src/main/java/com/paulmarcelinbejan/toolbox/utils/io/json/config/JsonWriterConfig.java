package com.paulmarcelinbejan.toolbox.utils.io.json.config;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.paulmarcelinbejan.toolbox.utils.io.common.ObjectMapperUtils;

import lombok.Getter;

public class JsonWriterConfig {

	public JsonWriterConfig(Map<Class<?>, JsonSerializer<?>> serializers) {
		this.serializers = serializers != null ? serializers : Collections.emptyMap();
		
		this.jsonMapper = buildJsonMapper();
	}
	
	public static final JsonWriterConfig DEFAULT = new JsonWriterConfig(Collections.emptyMap());
	
	@Getter
	private final Map<Class<?>, JsonSerializer<?>> serializers;
	
	@Getter
	private final JsonMapper jsonMapper;
	
	/**
	 * return a JsonMapper configured with serializers (if any) and prettyPrinter
	 */
	private JsonMapper buildJsonMapper() {
		JsonMapper mapper = new JsonMapper();
		
		if(!serializers.isEmpty()) {
			ObjectMapperUtils.registerSerializers(mapper, serializers);
		}
		
		return mapper;
	}
	
}
