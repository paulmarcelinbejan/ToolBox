package com.paulmarcelinbejan.toolbox.utils.csv.config;

import lombok.Getter;

public class CsvFileUtilsConfig {

	public CsvFileUtilsConfig(
			CsvReaderConfig readerConfig, 
			CsvWriterConfig writerConfig) {
		this.readerConfig = readerConfig;
		this.writerConfig = writerConfig;
	}
	
	public static final CsvFileUtilsConfig DEFAULT = new CsvFileUtilsConfig(CsvReaderConfig.DEFAULT, CsvWriterConfig.DEFAULT);
	
	@Getter
	private final CsvReaderConfig readerConfig;
	
	@Getter
	private final CsvWriterConfig writerConfig;
	
}
