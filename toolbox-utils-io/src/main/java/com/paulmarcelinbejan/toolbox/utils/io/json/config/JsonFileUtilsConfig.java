package com.paulmarcelinbejan.toolbox.utils.io.json.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JsonFileUtilsConfig {

	public static final JsonFileUtilsConfig DEFAULT = new JsonFileUtilsConfig(JsonReaderConfig.DEFAULT, JsonWriterConfig.DEFAULT);
	
	private final JsonReaderConfig readerConfig;
	private final JsonWriterConfig writerConfig;
	
}
