package io.github.paulmarcelinbejan.toolbox.utils.csv.config;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CsvFileUtilsConfig {
	
	@Builder
	public CsvFileUtilsConfig(CsvReaderConfig readerConfig, CsvWriterConfig writerConfig) {
		this.readerConfig = readerConfig != null ? readerConfig : CsvReaderConfig.DEFAULT;
		this.writerConfig = writerConfig != null ? writerConfig : CsvWriterConfig.DEFAULT;
	}

	public static final CsvFileUtilsConfig DEFAULT = new CsvFileUtilsConfig(CsvReaderConfig.DEFAULT, CsvWriterConfig.DEFAULT);
	
	private final CsvReaderConfig readerConfig;
	private final CsvWriterConfig writerConfig;
	
}
