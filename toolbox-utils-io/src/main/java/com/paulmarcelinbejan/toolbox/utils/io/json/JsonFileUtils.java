package com.paulmarcelinbejan.toolbox.utils.io.json;

import static com.paulmarcelinbejan.toolbox.utils.io.config.FileType.JSON;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.io.json.config.JsonFileUtilsConfig;
import com.paulmarcelinbejan.toolbox.utils.io.json.config.JsonReaderConfig;
import com.paulmarcelinbejan.toolbox.utils.io.json.config.JsonWriterConfig;

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
		Reader reader = FileUtils.createFileReader(fileInfo, JSON);
		return readerConfig.getJsonMapper().readValue(reader, typeParameterClass);
    }
	
    /**
     * JSON file starts with square brackets
     */
	public List<T> readList(FileInfo fileInfo) throws IOException {
		Reader reader = FileUtils.createFileReader(fileInfo, JSON);
		JsonMapper mapper = readerConfig.getJsonMapper();
		return mapper.readValue(reader, mapper.getTypeFactory().constructCollectionType(ArrayList.class, typeParameterClass));
    }
	
    /**
     * JSON file starts with curly brackets
     */
    public void write(FileInfo fileInfo, T object) throws IOException {
    	File file = FileUtils.createFile(fileInfo, JSON);
    	writerConfig.getJsonMapper().writerWithDefaultPrettyPrinter().writeValue(file, object);
    }
    
    /**
     * JSON file starts with square brackets
     */
    public void writeList(FileInfo fileInfo, List<T> object) throws IOException {
    	File file = FileUtils.createFile(fileInfo, JSON);
    	writerConfig.getJsonMapper().writerWithDefaultPrettyPrinter().writeValue(file, object);
    }
	
}
