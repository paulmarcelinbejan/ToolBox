package io.github.paulmarcelinbejan.toolbox.utils.yaml;

import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.resource.OutputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlWriterConfig;

public class YamlFileWriter extends PrefixYamlUtils {
	
	public YamlFileWriter() {
		mapper = YamlWriterConfig.DEFAULT.getYamlMapper();
	}
	
    public YamlFileWriter(YamlWriterConfig writerConfig) {
		mapper = writerConfig.getYamlMapper();
	}
	
	private final YAMLMapper mapper;
    
    public <T> void write(OutputFileResource outputFileResource, Class<T> clazz, T value) throws IOException {
    	try (OutputStream outputStream = outputFileResource.getOutputStream()) {
    		writeValueWithoutPrefix(outputStream, clazz, value);
		}
    }
    
    public <T> void write(OutputFileResource outputFileResource, Class<T> clazz, T value, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
    	try (OutputStream outputStream = outputFileResource.getOutputStream()) {
    		writeValueWithPrefix(outputStream, clazz, value, prefix, yamlPrefixType);
		}
    }
    
    private <T> void writeValueWithoutPrefix(OutputStream outputStream, Class<T> clazz, T value) throws IOException {
        mapper.writerFor(clazz)
  	  		  .writeValue(outputStream, value);
    }
    
    private <T> void writeValueWithPrefix(OutputStream outputStream, Class<T> clazz, T value, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
        mapper.writerFor(clazz)
			  .withRootName(convertPrefix(prefix, yamlPrefixType))
              .writeValue(outputStream, value);
    }
	
}
