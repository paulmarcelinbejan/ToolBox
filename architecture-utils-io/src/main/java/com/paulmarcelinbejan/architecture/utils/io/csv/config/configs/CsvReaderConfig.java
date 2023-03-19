package com.paulmarcelinbejan.architecture.utils.io.csv.config.configs;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.paulmarcelinbejan.architecture.utils.io.common.utils.ObjectMapperUtils;

import lombok.Getter;

public class CsvReaderConfig {

	public static final CsvReaderConfig DEFAULT = new CsvReaderConfig(',', null);
	
	private final char separator;
	
	private final Map<Class<?>, JsonDeserializer<?>> deserializers;
	
	@Getter
	private final CsvMapper csvMapper;
	
	@Getter
	private final CsvSchema csvSchema;
	
	public CsvReaderConfig(char separator, Map<Class<?>, JsonDeserializer<?>> deserializers) {
		this.separator = separator;
		this.deserializers = deserializers;
		
		this.csvMapper = buildCsvMapper();
		this.csvSchema = buildCsvSchema();
	}
	
	/**
	 * return a CsvMapper configured with deserializers (if any)
	 */
	private CsvMapper buildCsvMapper() {
		CsvMapper mapper = new CsvMapper();
		
		if(deserializers != null && !deserializers.isEmpty()) {
			ObjectMapperUtils.registerDeserializers(mapper, deserializers);
		}
		
		return mapper;
	}
	
	/**
	 * return a CsvSchema configured with separator
	 */
	private CsvSchema buildCsvSchema() {
		return CsvSchema.emptySchema()
						.withColumnSeparator(separator)
						.withHeader();
	}
	
}
