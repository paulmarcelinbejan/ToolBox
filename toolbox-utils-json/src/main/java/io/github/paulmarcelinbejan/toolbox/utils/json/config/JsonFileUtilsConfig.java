package io.github.paulmarcelinbejan.toolbox.utils.json.config;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JsonFileUtilsConfig {

	@Builder
	public JsonFileUtilsConfig(JsonReaderConfig readerConfig, JsonWriterConfig writerConfig) {
		this.readerConfig = readerConfig != null ? readerConfig : JsonReaderConfig.DEFAULT;
		this.writerConfig = writerConfig != null ? writerConfig : JsonWriterConfig.DEFAULT;
	}
	
	public static final JsonFileUtilsConfig DEFAULT = new JsonFileUtilsConfig(JsonReaderConfig.DEFAULT, JsonWriterConfig.DEFAULT);
	
	private final JsonReaderConfig readerConfig;
	private final JsonWriterConfig writerConfig;
	
}
