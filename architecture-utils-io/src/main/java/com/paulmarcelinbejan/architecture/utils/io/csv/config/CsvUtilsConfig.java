package com.paulmarcelinbejan.architecture.utils.io.csv.config;

import com.paulmarcelinbejan.architecture.utils.io.csv.config.configs.CsvReaderConfig;
import com.paulmarcelinbejan.architecture.utils.io.csv.config.configs.CsvWriterConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CsvUtilsConfig {

	public static final CsvUtilsConfig DEFAULT = new CsvUtilsConfig(CsvReaderConfig.DEFAULT, CsvWriterConfig.DEFAULT);
	
	private final CsvReaderConfig csvReaderConfig;
	private final CsvWriterConfig csvWriterConfig;
	
}
