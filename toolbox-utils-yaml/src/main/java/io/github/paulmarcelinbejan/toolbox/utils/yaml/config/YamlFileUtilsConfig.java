package io.github.paulmarcelinbejan.toolbox.utils.yaml.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class YamlFileUtilsConfig {
	
	public static final YamlFileUtilsConfig DEFAULT = new YamlFileUtilsConfig(
			YamlReaderConfig.DEFAULT, 
			YamlWriterConfig.DEFAULT);
	
	private final YamlReaderConfig readerConfig;
	private final YamlWriterConfig writerConfig;
	
}
