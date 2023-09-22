package com.paulmarcelinbejan.toolbox.utils.io.csv.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CsvFileUtilsConfig {

	public static final CsvFileUtilsConfig DEFAULT = new CsvFileUtilsConfig(CsvReaderConfig.DEFAULT, CsvWriterConfig.DEFAULT);
	
	private final CsvReaderConfig csvReaderConfig;
	private final CsvWriterConfig csvWriterConfig;
	
}
