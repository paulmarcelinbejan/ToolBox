package com.paulmarcelinbejan.toolbox.utils.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.json.config.JsonFileUtilsConfig;
import com.paulmarcelinbejan.toolbox.utils.json.config.JsonReaderConfig;
import com.paulmarcelinbejan.toolbox.utils.json.config.JsonWriterConfig;

public class JsonFileUtils<T> {

	private final Class<T> typeParameterClass;
	
	private final JsonReaderConfig readerConfig;
	private final JsonWriterConfig writerConfig;

	/**
	 * This constructor will use default configuration. 
	 */
    public JsonFileUtils(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		this.readerConfig = JsonReaderConfig.DEFAULT;
		this.writerConfig = JsonWriterConfig.DEFAULT;
	}
    
    public JsonFileUtils(Class<T> typeParameterClass, JsonFileUtilsConfig jsonFileUtilsConfig) {
		this.typeParameterClass = typeParameterClass;
		this.readerConfig = jsonFileUtilsConfig.getReaderConfig();
		this.writerConfig = jsonFileUtilsConfig.getWriterConfig();
	}

    /**
     * JSON file starts with curly brackets
     */
	public T read(FileInfo fileInfo) throws IOException {
		InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo);
		T json = readerConfig.getJsonMapper().readValue(fileInputStream, typeParameterClass);
		return json;
    }
	
    /**
     * JSON file starts with square brackets
     */
	public List<T> readList(FileInfo fileInfo) throws IOException {
		MappingIterator<T> iterator = iterator(fileInfo);
		List<T> list = iterator.readAll();
		iterator.close();
		return list;
	}
	
    /**
     * JSON file starts with square brackets
     * 
     * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
     */
	public MappingIterator<T> iterator(FileInfo fileInfo) throws IOException {
		InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo);
		JsonMapper mapper = readerConfig.getJsonMapper();
        return mapper.readerFor(typeParameterClass)
        			 .readValues(fileInputStream);
    }
	
    /**
     * JSON file starts with curly brackets
     */
    public void write(FileInfo fileInfo, T object) throws IOException {
    	OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo);
    	writerConfig.getJsonMapper()
    				.writer()
    				.with(prettyPrinter())
    				.writeValue(fileOutputStream, object);
    }
    
    /**
     * JSON file starts with square brackets
     */
    public void writeList(FileInfo fileInfo, List<T> objects) throws IOException {
    	OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo);
    	writerConfig.getJsonMapper()
    				.writer()
    				.with(prettyPrinter())
    				.writeValue(fileOutputStream, objects);
    }
    
    private DefaultPrettyPrinter prettyPrinter() {
    	DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();        
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return prettyPrinter;
    }
	
}
