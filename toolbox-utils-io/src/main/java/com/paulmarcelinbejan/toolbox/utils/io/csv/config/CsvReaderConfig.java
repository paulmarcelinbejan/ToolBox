package com.paulmarcelinbejan.toolbox.utils.io.csv.config;

import static com.paulmarcelinbejan.toolbox.constants.SymbolsAsChar.COMMA;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.paulmarcelinbejan.toolbox.utils.io.common.ObjectMapperUtils;

import lombok.Getter;

public class CsvReaderConfig {

	public CsvReaderConfig(char separator, Map<Class<?>, JsonDeserializer<?>> deserializers) {
		this.separator = separator;
		this.deserializers = deserializers;
		
		this.csvMapper = buildCsvMapper();
		this.csvSchema = buildCsvSchema();
	}
	
	public static final CsvReaderConfig DEFAULT = new CsvReaderConfig(COMMA, Collections.emptyMap());
	
	private final char separator;
	
	private final Map<Class<?>, JsonDeserializer<?>> deserializers;
	
	@Getter
	private final CsvMapper csvMapper;
	
	@Getter
	private final CsvSchema csvSchema;
	
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
	 * return a CsvSchema configured with separator and header line
	 */
	private CsvSchema buildCsvSchema() {
		return CsvSchema.emptySchema()
						.withColumnSeparator(separator)
						.withHeader();
	}
	
}