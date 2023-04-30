package com.paulmarcelinbejan.architecture.utils.io.csv.config.configs;

import static com.paulmarcelinbejan.architecture.constants.SymbolsAsChar.COMMA;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.paulmarcelinbejan.architecture.utils.io.common.utils.ObjectMapperUtils;

import lombok.Getter;

public class CsvWriterConfig {

	public static final CsvWriterConfig DEFAULT = new CsvWriterConfig(COMMA, Map.of(), List.of(), false);
	
	@Getter
	private final char separator;
	
	private final Map<Class<?>, JsonSerializer<?>> serializers;
	
	/**
	 * Columns Header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	private final List<String> columns;

	@Getter
	private final boolean appendCurrentTimeMillisToFileName;
	
	@Getter
	private final CsvMapper csvMapper;
	
	private final CsvSchema csvSchema;
	
	public Optional<CsvSchema> getCsvSchema() {
		return Optional.ofNullable(csvSchema);
	}
	
	public CsvWriterConfig(char separator, Map<Class<?>, JsonSerializer<?>> serializers, List<String> columns, boolean appendCurrentTimeMillisToFileName) {
		this.separator = separator;
		this.serializers = serializers;
		this.columns = columns;
		this.appendCurrentTimeMillisToFileName = appendCurrentTimeMillisToFileName;
		
		this.csvMapper = buildCsvMapper();
		this.csvSchema = buildCsvSchema();
	}
	
	/**
	 * return a CsvMapper configured with serializers (if any)
	 */
	private CsvMapper buildCsvMapper() {
		CsvMapper mapper = new CsvMapper();
		mapper.configure(Feature.IGNORE_UNKNOWN, true);
		
		if(serializers != null && !serializers.isEmpty()) {
			ObjectMapperUtils.registerSerializers(mapper, serializers);
		}
		
		return mapper;
	}
	
	/**
	 * return a ready to use CsvSchema configured with columns.
	 */
	private CsvSchema buildCsvSchema() {
		if(columns != null && !columns.isEmpty()) {
			return csvSchemaWithColumnsOrder(columns.toArray(String[]::new));
		}
		return null;
	}
	
	private CsvSchema csvSchemaWithColumnsOrder(final String[] columns) {
		Builder builder = CsvSchema.builder();
		
		for(String column : columns) {
			builder = builder.addColumn(column);
		}
		
		return builder.build()
					  .sortedBy(columns)
					  .withColumnSeparator(separator)
					  .withHeader()
					  .withoutQuoteChar();
	}
	
}
