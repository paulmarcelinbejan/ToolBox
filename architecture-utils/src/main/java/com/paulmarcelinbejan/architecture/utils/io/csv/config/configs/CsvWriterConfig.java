package com.paulmarcelinbejan.architecture.utils.io.csv.config.configs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CsvWriterConfig {

	public static final CsvWriterConfig DEFAULT = new CsvWriterConfig(false, new HashMap<>(), new ArrayList<>(), ',');
	
	private final boolean appendCurrentTimeMillisToFileName;
	private final Map<Class<?>, JsonSerializer<?>> serializers;
	private final List<String> columns;
	private final char separator;
	
}
