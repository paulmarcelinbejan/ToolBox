package io.github.paulmarcelinbejan.toolbox.utils.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import io.github.paulmarcelinbejan.toolbox.utils.json.config.JsonFileUtilsConfig;
import io.github.paulmarcelinbejan.toolbox.utils.json.config.JsonReaderConfig;
import io.github.paulmarcelinbejan.toolbox.utils.json.config.JsonWriterConfig;

public class JsonFileUtils {

	/**
	 * This constructor will use default configuration. 
	 */
    public JsonFileUtils() {
		mapperReader = JsonFileUtilsConfig.DEFAULT.getReaderConfig().getJsonMapper();
		mapperWriter = JsonFileUtilsConfig.DEFAULT.getWriterConfig().getJsonMapper();
	}
    
    public JsonFileUtils(JsonFileUtilsConfig jsonFileUtilsConfig) {
		mapperReader = jsonFileUtilsConfig.getReaderConfig().getJsonMapper();
		mapperWriter = jsonFileUtilsConfig.getWriterConfig().getJsonMapper();
	}
    
    public JsonFileUtils(JsonReaderConfig readerConfig, JsonWriterConfig writerConfig) {
		mapperReader = readerConfig.getJsonMapper();
		mapperWriter = writerConfig.getJsonMapper();
	}
    
	private final JsonMapper mapperReader;
	private final JsonMapper mapperWriter;

    /**
     * JSON file starts with curly brackets
     */
	public <T> T read(FileInfo fileInfo, Class<T> clazz) throws IOException {
		try (Reader fileReader = FileUtils.createFileReader(fileInfo);) {
			return mapperReader.readValue(fileReader, clazz);
		}
    }
	
    /**
     * JSON file starts with square brackets
     */
	public <T> List<T> readList(FileInfo fileInfo, Class<T> clazz) throws IOException {
		try (MappingIterator<T> iterator = readerIterator(fileInfo, clazz)) {
    		return iterator.readAll();
		}
	}
	
    /**
     * JSON file starts with square brackets
     * 
     * Remember to close the Reader usign <b>iterator.close()</b> in order to release any resources associated with it.
     */
	public <T> MappingIterator<T> readerIterator(FileInfo fileInfo, Class<T> clazz) throws IOException {
		InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo);
        return mapperReader.readerFor(clazz)
        			 	   .readValues(fileInputStream);
    }
	

	public SequenceWriter writerIterator(FileInfo fileInfo) throws IOException {
		Writer fileWriter = FileUtils.createFileWriter(fileInfo);
		return mapperWriter.writer()
				.with(PRETTY_PRINTER)
				.writeValues(fileWriter);
	}

    /**
     * JSON file starts with curly brackets
     */
    public <T> void write(FileInfo fileInfo, T object) throws IOException {
		try (Writer fileWriter = FileUtils.createFileWriter(fileInfo);) {
			mapperWriter.writer()
				.with(PRETTY_PRINTER)
				.writeValue(fileWriter, object);
		}
    }
    
    /**
     * JSON file starts with square brackets
     */
    public <T> void writeList(FileInfo fileInfo, List<T> objects) throws IOException {
		try (Writer fileWriter = FileUtils.createFileWriter(fileInfo);) {
			mapperWriter.writer()
				.with(PRETTY_PRINTER)
				.writeValue(fileWriter, objects);
		}
    }
    
	private static final DefaultPrettyPrinter PRETTY_PRINTER = prettyPrinter();
    
    private static DefaultPrettyPrinter prettyPrinter() {
    	DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();        
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return prettyPrinter;
    }
	
}
