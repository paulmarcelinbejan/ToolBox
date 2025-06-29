package io.github.paulmarcelinbejan.toolbox.utils.csv;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;

import io.github.paulmarcelinbejan.toolbox.utils.csv.config.CsvWriterConfig;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.OutputFileResource;

public class CsvFileWriter {
	
    private final CsvMapper mapper;

	private final char separator;
	
	private final boolean withHeader;
	
    public CsvFileWriter() {
        this(CsvWriterConfig.DEFAULT);
    }

    public CsvFileWriter(CsvWriterConfig config) {
        this.mapper = config.getCsvMapper();
        this.separator = config.getSeparator();
        this.withHeader = config.isWithHeader();
    }
    
	/**
	 *  @throws IOException
	 */
	public <T> void write(OutputFileResource outputFileResource, Class<T> clazz, List<T> records) throws IOException {
		try (OutputStream outputStream = outputFileResource.getOutputStream()) {
			CsvSchema csvSchema = buildWriterCsvSchema(clazz);
			mapper.writerFor(clazz)
						.with(csvSchema)
						.writeValue(outputStream, records);
		}
	}
	
	/**
	 * columns represent the columns header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	public <T> void write(OutputFileResource outputFileResource, Class<T> clazz, List<String> columns, List<T> records) throws IOException {
		try (OutputStream outputStream = outputFileResource.getOutputStream()) {
			CsvSchema csvSchema = buildWriterCsvSchema(columns);
			mapper.writerFor(clazz)
						.with(csvSchema)
						.writeValue(outputStream, records);
		}
	}
	
	/**
	 *  @throws IOException
	 */
	public <T> void write(OutputFileResource outputFileResource, Class<T> clazz, List<T> records, boolean appendUniqueSuffix) throws IOException {
		
		if(appendUniqueSuffix) {
			String fileNameWithSuffix = appendUniqueSuffix(outputFileResource.getFileName());
			outputFileResource.setFileName(fileNameWithSuffix);
		}
		
		write(outputFileResource, clazz, records);
		
	}
	
	/**
	 * columns represent the columns header, it will be used to write only the columns present in this list. 
	 * It will also be used to order them, otherwise the alphabetical order will be applied.
	 */
	public <T> void write(OutputFileResource outputFileResource, Class<T> clazz, List<String> columns, List<T> records, boolean appendUniqueSuffix) throws IOException {
		
		if(appendUniqueSuffix) {
			String fileNameWithSuffix = appendUniqueSuffix(outputFileResource.getFileName());
			outputFileResource.setFileName(fileNameWithSuffix);
		}
		
		write(outputFileResource, clazz, columns, records);
		
	}
	
	/**
	 * Remember to close the sequenceWriter usign <b>sequenceWriter.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> SequenceWriter writerIterator(OutputFileResource outputFileResource, Class<T> clazz) throws IOException {
		OutputStream outputStream = outputFileResource.getOutputStream();
		
		CsvSchema csvSchema = buildWriterCsvSchema(clazz);
		
		return mapper.writerFor(clazz)
				.with(csvSchema)
                .writeValues(outputStream);
	}
	
	/**
	 * Remember to close the sequenceWriter usign <b>sequenceWriter.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public <T> SequenceWriter writerIterator(OutputFileResource outputFileResource, Class<T> clazz, List<String> columns) throws IOException {
		OutputStream outputStream = outputFileResource.getOutputStream();
		
		CsvSchema csvSchema = buildWriterCsvSchema(columns);
		
		return mapper.writerFor(clazz)
				.with(csvSchema)
                .writeValues(outputStream);
	}
	
	private <T> CsvSchema buildWriterCsvSchema(Class<T> clazz) {
		CsvSchema schema = mapper.schemaFor(clazz)
				.withColumnSeparator(separator)
				.withoutQuoteChar();

		return withHeader ? schema.withHeader() : schema.withoutHeader();
	}
	
	private CsvSchema buildWriterCsvSchema(List<String> columns) {
		Builder builder = CsvSchema.builder();
		
		for(String column : columns) {
			builder = builder.addColumn(column);
		}
		
		CsvSchema schema = builder.build()
					  .sortedBy(columns.toArray(String[]::new))
					  .withColumnSeparator(separator)
					  .withoutQuoteChar();
		
		return withHeader ? schema.withHeader() : schema.withoutHeader();
		
	}
	
	/**
	 * Useful when you want to avoid to override already present file.
	 * 
	 * @param fileName
	 * @return fileName_UUID
	 */
	private static String appendUniqueSuffix(String fileName) {
		return new StringBuilder()
				.append(fileName)
				.append("_")
				.append(UUID.randomUUID().toString())
				.toString();
	}
	
}
