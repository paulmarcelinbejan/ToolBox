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

public class JsonFileUtils {

	/**
	 * This constructor will use default configuration. 
	 */
    public JsonFileUtils() {
		this.mapperReader = JsonFileUtilsConfig.DEFAULT.getReaderConfig().getJsonMapper();
		this.mapperWriter = JsonFileUtilsConfig.DEFAULT.getWriterConfig().getJsonMapper();
	}
    
    public JsonFileUtils(JsonFileUtilsConfig jsonFileUtilsConfig) {
		this.mapperReader = jsonFileUtilsConfig.getReaderConfig().getJsonMapper();
		this.mapperWriter = jsonFileUtilsConfig.getWriterConfig().getJsonMapper();
	}
    
    public JsonFileUtils(JsonReaderConfig readerConfig, JsonWriterConfig writerConfig) {
		this.mapperReader = readerConfig.getJsonMapper();
		this.mapperWriter = writerConfig.getJsonMapper();
	}
    
	private final JsonMapper mapperReader;
	private final JsonMapper mapperWriter;

    /**
     * JSON file starts with curly brackets
     */
	public <T> T read(FileInfo fileInfo, Class<T> clazz) throws IOException {
		InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo);
		T json = mapperReader.readValue(fileInputStream, clazz);
		return json;
    }
	
    /**
     * JSON file starts with square brackets
     */
	public <T> List<T> readList(FileInfo fileInfo, Class<T> clazz) throws IOException {
		MappingIterator<T> iterator = iterator(fileInfo, clazz);
		List<T> list = iterator.readAll();
		iterator.close();
		return list;
	}
	
    /**
     * JSON file starts with square brackets
     * 
     * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
     */
	public <T> MappingIterator<T> iterator(FileInfo fileInfo, Class<T> clazz) throws IOException {
		InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo);
        return mapperReader.readerFor(clazz)
        			 	   .readValues(fileInputStream);
    }
	
    /**
     * JSON file starts with curly brackets
     */
    public <T> void write(FileInfo fileInfo, T object) throws IOException {
    	OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo);
    	mapperWriter.writer()
    				.with(prettyPrinter())
    				.writeValue(fileOutputStream, object);
    }
    
    /**
     * JSON file starts with square brackets
     */
    public <T> void writeList(FileInfo fileInfo, List<T> objects) throws IOException {
    	OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo);
    	mapperWriter.writer()
    				.with(prettyPrinter())
    				.writeValue(fileOutputStream, objects);
    }
    
    private DefaultPrettyPrinter prettyPrinter() {
    	DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();        
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return prettyPrinter;
    }
	
}
