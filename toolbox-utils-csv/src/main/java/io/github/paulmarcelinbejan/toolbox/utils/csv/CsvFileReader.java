package io.github.paulmarcelinbejan.toolbox.utils.csv;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import io.github.paulmarcelinbejan.toolbox.utils.csv.config.CsvReaderConfig;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.InputFileResource;
import lombok.Getter;

@Getter
public class CsvFileReader {
	
    private final CsvMapper mapper;
    
	private final char separator;
	
	private final boolean withHeader;

    public CsvFileReader() {
        this(CsvReaderConfig.DEFAULT);
    }

    public CsvFileReader(CsvReaderConfig config) {
        this.mapper = config.getCsvMapper();
        this.separator = config.getSeparator();
        this.withHeader = config.isWithHeader();
    }
    
	/**
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> List<T> read(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
		return read(inputFileResource.getInputStream(), clazz);
	}
	
	/**
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> List<T> read(InputStream inputStream, Class<T> clazz) throws IOException {
		try (MappingIterator<T> iterator = readerIterator(inputStream, clazz)) {
    		return iterator.readAll();
		}
	}
	
	/**
	 * Remember to close the iterator usign <b>iterator.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> MappingIterator<T> readerIterator(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
		return readerIterator(inputFileResource.getInputStream(), clazz);
	}
	
	/**
	 * Remember to close the iterator usign <b>iterator.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> MappingIterator<T> readerIterator(InputStream inputStream, Class<T> clazz) throws IOException {

		CsvSchema csvSchema = buildReaderCsvSchema();
		
		return mapper.readerFor(clazz)
					 .with(csvSchema)
					 .readValues(inputStream);
	}
	
	/**
	 * return a CsvSchema configured with separator and header line
	 */
	private CsvSchema buildReaderCsvSchema() {
	    CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(separator);
	    return withHeader ? schema.withHeader() : schema.withoutHeader();
	}
	
}
