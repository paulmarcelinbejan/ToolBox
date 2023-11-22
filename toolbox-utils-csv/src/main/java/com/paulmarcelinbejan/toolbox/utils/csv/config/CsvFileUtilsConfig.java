package com.paulmarcelinbejan.toolbox.utils.csv.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CsvFileUtilsConfig {
	
	public static final CsvFileUtilsConfig DEFAULT = new CsvFileUtilsConfig(CsvReaderConfig.DEFAULT, CsvWriterConfig.DEFAULT);
	
	private final CsvReaderConfig readerConfig;
	private final CsvWriterConfig writerConfig;
	
}
