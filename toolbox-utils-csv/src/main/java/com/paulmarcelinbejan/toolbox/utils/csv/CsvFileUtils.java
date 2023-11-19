package com.paulmarcelinbejan.toolbox.utils.csv;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.paulmarcelinbejan.toolbox.utils.csv.config.CsvFileUtilsConfig;
import com.paulmarcelinbejan.toolbox.utils.csv.config.CsvReaderConfig;
import com.paulmarcelinbejan.toolbox.utils.csv.config.CsvWriterConfig;
import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;

import lombok.NonNull;

/**
 * Utility class to Read and Write CSV (comma-separated values) files.
 * <br>
 * It uses the jackson-dataformat-csv
 */
public class CsvFileUtils<T> {
	
	private final Class<T> typeParameterClass;
	
	private final CsvReaderConfig readerConfig;
	private final CsvWriterConfig writerConfig;
	
	/**
	 * This constructor will use default configuration. 
	 */
	public CsvFileUtils(@NonNull final Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		this.readerConfig = CsvReaderConfig.DEFAULT;
		this.writerConfig = CsvWriterConfig.DEFAULT;
	}
	
	public CsvFileUtils(@NonNull final Class<T> typeParameterClass, @NonNull final CsvFileUtilsConfig csvFileUtilsConfig) {
		this.typeParameterClass = typeParameterClass;
		this.readerConfig = csvFileUtilsConfig.getReaderConfig();
		this.writerConfig = csvFileUtilsConfig.getWriterConfig();
	}
	
	/**
	 * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public MappingIterator<T> iterator(@NonNull final FileInfo fileInfo) throws IOException {
		Reader reader = FileUtils.createFileReader(fileInfo);

		CsvMapper csvMapper = readerConfig.getCsvMapper();
		CsvSchema csvSchema = readerConfig.getCsvSchema();
		
		return csvMapper.readerFor(typeParameterClass)
						.with(csvSchema)
						.readValues(reader);
	}
	
	/**
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public List<T> read(@NonNull final FileInfo fileInfo) throws IOException {
		MappingIterator<T> iterator = iterator(fileInfo);
		List<T> list = iterator.readAll();
		iterator.close();
		return list;
	}
	
	/**
	 *  @throws IOException
	 */
	public void write(@NonNull final FileInfo fileInfo, @NonNull final List<T> records) throws IOException {
		
		if(writerConfig.isAppendCurrentTimeMillisToFileName()) {
			fileInfo.appendCurrentTimeMillisToFileName();
		}
		
		CsvMapper mapper = writerConfig.getCsvMapper();
		CsvSchema schema = writerConfig.getCsvSchema()
									   .orElse(defaultWriterCsvSchema(mapper));

		ObjectWriter writer = mapper.writerFor(typeParameterClass)
									.with(schema);
		
		File file = FileUtils.createFile(fileInfo);

		writer.writeValues(file)
			  .writeAll(records);
		
	}
	
	private CsvSchema defaultWriterCsvSchema(final CsvMapper mapper) {
		return mapper.schemaFor(typeParameterClass)
				 	 .withColumnSeparator(writerConfig.getSeparator())
				 	 .withHeader()
				 	 .withoutQuoteChar();
	}

}
