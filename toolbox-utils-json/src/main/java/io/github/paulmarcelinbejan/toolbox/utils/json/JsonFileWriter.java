package io.github.paulmarcelinbejan.toolbox.utils.json;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.resource.OutputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.json.config.JsonWriterConfig;

public class JsonFileWriter {

	/**
	 * This constructor will use default configuration. 
	 */
    public JsonFileWriter() {
		mapper = JsonWriterConfig.DEFAULT.getJsonMapper();
	}
    
    public JsonFileWriter(JsonWriterConfig writerConfig) {
		mapper = writerConfig.getJsonMapper();
	}
    
	private final JsonMapper mapper;

    /**
     * JSON file starts with curly brackets
     */
    public <T> void write(OutputFileResource outputFileResource, T object) throws IOException {
		try (OutputStream outputStream = outputFileResource.getOutputStream()) {
			mapper.writer()
				.with(PRETTY_PRINTER)
				.writeValue(outputStream, object);
		}
    }
    
    /**
     * JSON file starts with square brackets
     */
    public <T> void writeList(OutputFileResource outputFileResource, List<T> objects) throws IOException {
		try (OutputStream outputStream = outputFileResource.getOutputStream()) {
			mapper.writer()
				.with(PRETTY_PRINTER)
				.writeValue(outputStream, objects);
		}
    }
    
	/**
	 * Remember to close the sequenceWriter usign <b>sequenceWriter.close()</b> in order to release any resources associated with it.
	 * 
	 * @throws IOException if the file can not be found, or if the data can not be parsed correctly.
	 */
	public SequenceWriter writerIterator(OutputFileResource outputFileResource) throws IOException {
		OutputStream outputStream = outputFileResource.getOutputStream();
		return mapper.writer()
				.with(PRETTY_PRINTER)
				.writeValues(outputStream);
	}
    
	private static final DefaultPrettyPrinter PRETTY_PRINTER = prettyPrinter();
    
    private static DefaultPrettyPrinter prettyPrinter() {
    	DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();        
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return prettyPrinter;
    }
	
}
