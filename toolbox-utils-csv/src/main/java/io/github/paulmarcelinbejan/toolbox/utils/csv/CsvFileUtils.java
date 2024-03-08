package io.github.paulmarcelinbejan.toolbox.utils.csv;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;

import io.github.paulmarcelinbejan.toolbox.utils.csv.config.CsvFileUtilsConfig;
import io.github.paulmarcelinbejan.toolbox.utils.csv.config.CsvReaderConfig;
import io.github.paulmarcelinbejan.toolbox.utils.csv.config.CsvWriterConfig;
import io.github.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;

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
		mapperReader = CsvFileUtilsConfig.DEFAULT.getReaderConfig().getCsvMapper();
		mapperWriter = CsvFileUtilsConfig.DEFAULT.getWriterConfig().getCsvMapper();
	}
	
	public CsvFileUtils(final CsvFileUtilsConfig csvFileUtilsConfig) {
		mapperReader = csvFileUtilsConfig.getReaderConfig().getCsvMapper();
		mapperWriter = csvFileUtilsConfig.getWriterConfig().getCsvMapper();
	}
	
    public CsvFileUtils(CsvReaderConfig readerConfig, CsvWriterConfig writerConfig) {
		mapperReader = readerConfig.getCsvMapper();
		mapperWriter = writerConfig.getCsvMapper();
	}
	
	private final CsvMapper mapperReader;
	private final CsvMapper mapperWriter;
	
	/**
	 * Remember to close the iterator usign <b>iterator.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> MappingIterator<T> readerIterator(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator) throws IOException {
		Reader fileReader = FileUtils.createFileReader(fileInfo);

		CsvSchema csvSchema = buildReaderCsvSchema(separator);
		
		return mapperReader.readerFor(clazz)
							.with(csvSchema)
							.readValues(fileReader);
	}
	
	/**
	 * Remember to close the sequenceWriter usign <b>sequenceWriter.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> SequenceWriter writerIterator(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator) throws IOException {
		Writer fileWriter = FileUtils.createFileWriter(fileInfo);
		
		CsvSchema csvSchema = buildWriterCsvSchema(mapperWriter, separator, clazz);
		
		return mapperWriter.writerFor(clazz)
				.with(csvSchema)
                .writeValues(fileWriter);
	}
	
	/**
	 * Remember to close the sequenceWriter usign <b>sequenceWriter.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> SequenceWriter writerIterator(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator, List<String> columns) throws IOException {
		Writer fileWriter = FileUtils.createFileWriter(fileInfo);
		
		CsvSchema csvSchema = buildWriterCsvSchema(separator, columns);
		
		return mapperWriter.writerFor(clazz)
				.with(csvSchema)
                .writeValues(fileWriter);
	}
	
	/**
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> List<T> read(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator) throws IOException {
		try (MappingIterator<T> iterator = readerIterator(fileInfo, clazz, separator)) {
    		return iterator.readAll();
		}
	}
	
	/**
	 *  @throws IOException
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator, @NonNull final List<T> records) throws IOException {
		try (Writer fileWriter = FileUtils.createFileWriter(fileInfo)) {
			CsvSchema csvSchema = buildWriterCsvSchema(mapperWriter, separator, clazz);
			mapperWriter.writerFor(clazz)
						.with(csvSchema)
						.writeValue(fileWriter, records);
		}
	}
	
	/**
	 * columns represent the columns header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator, List<String> columns, @NonNull final List<T> records) throws IOException {
		try (Writer fileWriter = FileUtils.createFileWriter(fileInfo)) {
			CsvSchema csvSchema = buildWriterCsvSchema(separator, columns);
			mapperWriter.writerFor(clazz)
						.with(csvSchema)
						.writeValue(fileWriter, records);
		}
	}
	
	/**
	 *  @throws IOException
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator, @NonNull final List<T> records, boolean appendCurrentTimeMillisToFileName) throws IOException {
		
		if(appendCurrentTimeMillisToFileName) {
			fileInfo.appendCurrentTimeMillisToFileName();
		}
		
		write(fileInfo, clazz, separator, records);
		
	}
	
	/**
	 * columns represent the columns header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	public <T> void write(@NonNull final FileInfo fileInfo, Class<T> clazz, char separator, List<String> columns, @NonNull final List<T> records, boolean appendCurrentTimeMillisToFileName) throws IOException {
		
		if(appendCurrentTimeMillisToFileName) {
			fileInfo.appendCurrentTimeMillisToFileName();
		}
		
		write(fileInfo, clazz, separator, columns, records);
		
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
