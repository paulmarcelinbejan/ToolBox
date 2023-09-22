package com.paulmarcelinbejan.toolbox.utils.io.csv;

import static com.paulmarcelinbejan.toolbox.utils.io.config.FileType.CSV;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.io.csv.config.CsvReaderConfig;
import com.paulmarcelinbejan.toolbox.utils.io.csv.config.CsvFileUtilsConfig;
import com.paulmarcelinbejan.toolbox.utils.io.csv.config.CsvWriterConfig;

import lombok.NonNull;

/**
 * Utility class to Read and Write CSV (comma-separated values) files.
 * <br>
 * It uses the jackson-dataformat-csv
 */
public class CsvFileUtils<T> {
	
	private final Class<T> typeParameterClass;
	
	private final CsvReaderConfig csvReaderConfig;
	private final CsvWriterConfig csvWriterConfig;
	
	/**
	 * This constructor will use default configuration. 
	 */
	public CsvFileUtils(@NonNull final Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		this.csvReaderConfig = CsvReaderConfig.DEFAULT;
		this.csvWriterConfig = CsvWriterConfig.DEFAULT;
	}
	
	public CsvFileUtils(@NonNull final Class<T> typeParameterClass, @NonNull final CsvFileUtilsConfig csvFileUtilsConfig) {
		this.typeParameterClass = typeParameterClass;
		this.csvReaderConfig = csvFileUtilsConfig.getCsvReaderConfig();
		this.csvWriterConfig = csvFileUtilsConfig.getCsvWriterConfig();
	}
	
	/**
	 * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public MappingIterator<T> iterator(@NonNull final FileInfo fileInfo) throws IOException {
		Reader reader = FileUtils.createFileReader(fileInfo, CSV);

		CsvMapper csvMapper = csvReaderConfig.getCsvMapper();
		CsvSchema csvSchema = csvReaderConfig.getCsvSchema();
		
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
		
		if(csvWriterConfig.isAppendCurrentTimeMillisToFileName()) {
			fileInfo.appendCurrentTimeMillisToFileName();
		}
		
		CsvMapper mapper = csvWriterConfig.getCsvMapper();
		CsvSchema schema = csvWriterConfig.getCsvSchema()
										  .orElse(defaultWriterCsvSchema(mapper));

		ObjectWriter writer = mapper.writerFor(typeParameterClass)
									.with(schema);
		
		File file = FileUtils.createFile(fileInfo, CSV);

		writer.writeValues(file)
			  .writeAll(records);
		
	}
	
	private CsvSchema defaultWriterCsvSchema(final CsvMapper mapper) {
		return mapper.schemaFor(typeParameterClass)
				 	 .withColumnSeparator(csvWriterConfig.getSeparator())
				 	 .withHeader()
				 	 .withoutQuoteChar();
	}

}
