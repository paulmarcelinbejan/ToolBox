package com.paulmarcelinbejan.toolbox.utils.csv;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.paulmarcelinbejan.toolbox.utils.csv.config.CsvFileUtilsConfig;
import com.paulmarcelinbejan.toolbox.utils.csv.config.CsvReaderConfig;
import com.paulmarcelinbejan.toolbox.utils.csv.config.CsvWriterConfig;
import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;

import lombok.NonNull;

/**
 * Utility class to Read and Write CSV (comma-separated values) files.
 * <br>
 * Based on jackson-dataformat-csv
 */
public class CsvFileUtils {
	
	/**
	 * This constructor will use default configuration. 
	 */
	public CsvFileUtils() {
		this.mapperReader = CsvFileUtilsConfig.DEFAULT.getReaderConfig().getCsvMapper();
		this.mapperWriter = CsvFileUtilsConfig.DEFAULT.getWriterConfig().getCsvMapper();
	}
	
	public CsvFileUtils(@NonNull final CsvFileUtilsConfig csvFileUtilsConfig) {
		this.mapperReader = csvFileUtilsConfig.getReaderConfig().getCsvMapper();
		this.mapperWriter = csvFileUtilsConfig.getWriterConfig().getCsvMapper();
	}
	
    public CsvFileUtils(CsvReaderConfig readerConfig, CsvWriterConfig writerConfig) {
		this.mapperReader = readerConfig.getCsvMapper();
		this.mapperWriter = writerConfig.getCsvMapper();
	}
	
	private final CsvMapper mapperReader;
	private final CsvMapper mapperWriter;
	
	/**
	 * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> MappingIterator<T> iterator(@NonNull final FileInfo fileInfo, char separator, Class<T> clazz) throws IOException {
		Reader fileReader = FileUtils.createFileReader(fileInfo);

		CsvSchema csvSchema = buildReaderCsvSchema(separator);
		
		return mapperReader.readerFor(clazz)
							.with(csvSchema)
							.readValues(fileReader);
	}
	
	/**
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> List<T> read(@NonNull final FileInfo fileInfo, char separator, Class<T> clazz) throws IOException {
    	try (MappingIterator<T> iterator = iterator(fileInfo, separator, clazz)) {
    		return iterator.readAll();
		}
	}
	
	/**
	 *  @throws IOException
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, char separator, Class<T> clazz, @NonNull final List<T> records) throws IOException {
		
		CsvSchema schema = buildWriterCsvSchema(mapperReader, separator, clazz);

		writeFile(clazz, schema, fileInfo, records);
		
	}
	
	/**
	 * columns represent the columns header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, char separator, List<String> columns, Class<T> clazz, @NonNull final List<T> records) throws IOException {
		
		CsvSchema schema = buildWriterCsvSchema(separator, columns);

		writeFile(clazz, schema, fileInfo, records);
		
	}
	
	/**
	 *  @throws IOException
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, char separator, Class<T> clazz, @NonNull final List<T> records, boolean appendCurrentTimeMillisToFileName) throws IOException {
		
		if(appendCurrentTimeMillisToFileName) {
			fileInfo.appendCurrentTimeMillisToFileName();
		}
		
		write(fileInfo, separator, clazz, records);
		
	}
	
	/**
	 * columns represent the columns header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, char separator, List<String> columns, Class<T> clazz, @NonNull final List<T> records, boolean appendCurrentTimeMillisToFileName) throws IOException {
		
		if(appendCurrentTimeMillisToFileName) {
			fileInfo.appendCurrentTimeMillisToFileName();
		}
		
		write(fileInfo, separator, columns, clazz, records);
		
	}
	
	private <T> void writeFile(Class<T> clazz, CsvSchema schema, FileInfo fileInfo, final List<T> records) throws IOException {
		try (OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo)) {
			mapperWriter.writerFor(clazz)
				  .with(schema)
				  .writeValues(fileOutputStream)
				  .writeAll(records);
		}
	}
	
	/**
	 * return a CsvSchema configured with separator and header line
	 */
	private static CsvSchema buildReaderCsvSchema(char separator) {
		return CsvSchema.emptySchema()
						.withColumnSeparator(separator)
						.withHeader();
	}
	
	private static <T> CsvSchema buildWriterCsvSchema(CsvMapper mapper, char separator, Class<T> clazz) {
		return mapper.schemaFor(clazz)
			 	 	 .withColumnSeparator(separator)
			 	 	 .withHeader()
			 	 	 .withoutQuoteChar();
	}
	
	private static CsvSchema buildWriterCsvSchema(char separator, List<String> columns) {
		Builder builder = CsvSchema.builder();
		
		for(String column : columns) {
			builder = builder.addColumn(column);
		}
		
		return builder.build()
					  .sortedBy(columns.toArray(String[]::new))
					  .withColumnSeparator(separator)
					  .withHeader()
					  .withoutQuoteChar();
	}

}
