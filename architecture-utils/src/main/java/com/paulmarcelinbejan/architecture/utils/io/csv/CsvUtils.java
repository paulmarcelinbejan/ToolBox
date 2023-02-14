package com.paulmarcelinbejan.architecture.utils.io.csv;

import static com.paulmarcelinbejan.architecture.constants.Symbols.UNDERSCORE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.paulmarcelinbejan.architecture.utils.io.csv.config.CsvUtilsConfig;
import com.paulmarcelinbejan.architecture.utils.io.csv.config.configs.CsvReaderConfig;
import com.paulmarcelinbejan.architecture.utils.io.csv.config.configs.CsvWriterConfig;

import lombok.NonNull;

/**
 * Utility class to Read and Write CSV (comma-separated values) files.
 * <br>
 * It uses the jackson-dataformat-csv
 */
public class CsvUtils<T> {

	private static final String CSV_EXTENSION = ".csv";
	
	private final Class<T> typeParameterClass;
	
	private final CsvReaderConfig csvReaderConfig;
	private final CsvWriterConfig csvWriterConfig;
	
	/**
	 * This constructor will use default configuration. 
	 */
	public CsvUtils(@NonNull final Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		this.csvReaderConfig = CsvReaderConfig.DEFAULT;
		this.csvWriterConfig = CsvWriterConfig.DEFAULT;
	}
	
	public CsvUtils(@NonNull final Class<T> typeParameterClass, @NonNull final CsvUtilsConfig csvUtilsConfig) {
		this.typeParameterClass = typeParameterClass;
		this.csvReaderConfig = csvUtilsConfig.getCsvReaderConfig();
		this.csvWriterConfig = csvUtilsConfig.getCsvWriterConfig();
	}
	
	/**
	 * 
	 * How to use:
	 * <pre> {@code
	 * 
	 * CsvUtils<MyClass> myClassCSV = new CsvUtils<>(MyClass.class);
	 * List<MyClass> listOfMyClass = myClassCSV.read("directoryPathOfTheFile", "fileNameWithoutExtension");
	 * 
	 * } </pre>
	 *  
	 */
	public List<T> read(@NonNull final String directoryPath, @NonNull final String fileNameWithoutExtension) throws IOException {
		InputStream inputStream = new FileInputStream(new File(directoryPath + fileNameWithoutExtension + CSV_EXTENSION));

		CsvMapper mapper = buildReaderCsvMapper();
		
		CsvSchema schema = CsvSchema.emptySchema()
									.withColumnSeparator(csvReaderConfig.getSeparator())
									.withHeader();

		MappingIterator<T> iterator = mapper.readerFor(typeParameterClass)
											.with(schema)
											.readValues(inputStream);
		
		return iterator.readAll();
	}
	
	/**
	 * 
	 * How to use:
	 * <pre> {@code
	 * 
	 * CsvUtils<MyClass> myClassCSV = new CsvUtils<>(MyClass.class);
	 * myClassCSV.write("directoryPathOfTheFile", "fileNameWithoutExtension", records);
	 * 
	 * } </pre>
	 *  
	 */
	public void write(@NonNull final String directoryPath, 
					  @NonNull final String fileNameWithoutExtension,
					  @NonNull final List<T> records) throws IOException {
		
		String fileName = buildFileName(fileNameWithoutExtension);
		File file = new File(directoryPath + fileName);

		CsvMapper mapper = buildWriterCsvMapper();
		CsvSchema schema = buildWriterCsvSchema(mapper);

		ObjectWriter writer = mapper.writerFor(typeParameterClass)
									.with(schema);
		
		writer.writeValues(file)
			  .writeAll(records);
		
	}
	
	/**
	 * return a String that contains the fileName, currentTimeMillis (if required) and csv extension.
	 */
	private String buildFileName(String fileName) {
		if(csvWriterConfig.isAppendCurrentTimeMillisToFileName()) {
			fileName = fileName + UNDERSCORE + System.currentTimeMillis();
		}
		return fileName + CSV_EXTENSION;
	}
	
	/**
	 * return a CsvMapper configured with deserializers (if any)
	 */
	private CsvMapper buildReaderCsvMapper() {
		CsvMapper csvMapper = new CsvMapper();
		
		Map<Class<?>, JsonDeserializer<?>> deserializers = csvReaderConfig.getDeserializers();
		
		if(deserializers != null && !deserializers.isEmpty()) {
			SimpleModule module = new SimpleModule();
			addDeserializers(module, deserializers);
			csvMapper.registerModule(module);
		}
		
		return csvMapper;
	}
	
	/**
	 * return a CsvMapper configured with serializers (if any)
	 */
	private CsvMapper buildWriterCsvMapper() {
		CsvMapper csvMapper = new CsvMapper();
		csvMapper.configure(Feature.IGNORE_UNKNOWN, true);
		
		Map<Class<?>, JsonSerializer<?>> serializers = csvWriterConfig.getSerializers();
		
		if(serializers != null && !serializers.isEmpty()) {
			SimpleModule module = new SimpleModule();
			addSerializers(module, serializers);
			csvMapper.registerModule(module);
		}
		
		return csvMapper;
	}
	
	/**
	 * return a CsvSchema with columns order if provided, otherwise a default one.
	 */
	private CsvSchema buildWriterCsvSchema(final CsvMapper mapper) {
		List<String> columns = csvWriterConfig.getColumns();
		
		if(columns != null && !columns.isEmpty()) {
			return csvSchemaWithColumnsOrder(columns.toArray(String[]::new));
		}
		
		return defaultWriterCsvSchema(mapper);
	}
	
	private CsvSchema csvSchemaWithColumnsOrder(final String[] columns) {
		Builder builder = CsvSchema.builder();
		
		for(String column : columns) {
			builder = builder.addColumn(column);
		}
		
		return builder.build()
					  .sortedBy(columns)
					  .withColumnSeparator(csvWriterConfig.getSeparator())
					  .withHeader()
					  .withoutQuoteChar();
	}
	
	private CsvSchema defaultWriterCsvSchema(final CsvMapper mapper) {
		return mapper.schemaFor(typeParameterClass)
				 	 .withColumnSeparator(csvWriterConfig.getSeparator())
				 	 .withHeader()
				 	 .withoutQuoteChar();
	}
	
	
	@SuppressWarnings("unchecked")
	private <X> void addSerializers(final SimpleModule module, final Map<Class<?>, JsonSerializer<?>> serializers) {
		serializers.forEach((type, serializer) ->
				module.addSerializer((Class<? extends X>) type, (JsonSerializer<X>) serializer));
	}

	@SuppressWarnings("unchecked")
	private <X> void addDeserializers(final SimpleModule module, final Map<Class<?>, JsonDeserializer<?>> deserializers) {
		deserializers.forEach((type, deserializer) ->
				module.addDeserializer((Class<X>) type, (JsonDeserializer<? extends X>) deserializer));
	}

}
