package com.paulmarcelinbejan.architecture.utils.io.csv.config.configs;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CsvReaderConfig {

	public static final CsvReaderConfig DEFAULT = new CsvReaderConfig(new HashMap<>(), ',');
	
	final Map<Class<?>, JsonDeserializer<?>> deserializers;
	private final char separator;
	
}
