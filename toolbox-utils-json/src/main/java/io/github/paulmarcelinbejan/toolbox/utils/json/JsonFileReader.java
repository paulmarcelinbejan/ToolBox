package io.github.paulmarcelinbejan.toolbox.utils.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.resource.InputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.json.config.JsonReaderConfig;

public class JsonFileReader {

	private final JsonMapper mapper;
	
    public JsonFileReader() {
		mapper = JsonReaderConfig.DEFAULT.getJsonMapper();
	}
    
    public JsonFileReader(JsonReaderConfig readerConfig) {
		mapper = readerConfig.getJsonMapper();
	}

    /**
     * JSON file starts with curly brackets
     */
	public <T> T read(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
		try (InputStream inputStream = inputFileResource.getInputStream()) {
			return mapper.readValue(inputStream, clazz);
		}
    }
	
    /**
     * JSON file starts with square brackets
     */
	public <T> List<T> readList(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
		try (MappingIterator<T> iterator = readerIterator(inputFileResource, clazz)) {
    		return iterator.readAll();
		}
	}
	
    /**
     * JSON file starts with square brackets
     * 
     * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
     */
	public <T> MappingIterator<T> readerIterator(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
		
		InputStream inputStream = inputFileResource.getInputStream();
		
        return mapper.readerFor(clazz)
        			 .readValues(inputStream);
        
    }
	
}
