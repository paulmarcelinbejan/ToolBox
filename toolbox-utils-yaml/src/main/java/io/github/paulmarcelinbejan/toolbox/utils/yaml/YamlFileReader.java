package io.github.paulmarcelinbejan.toolbox.utils.yaml;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.resource.InputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlReaderConfig;

public class YamlFileReader extends PrefixYamlUtils {
	
	public YamlFileReader() {
		mapper = YamlReaderConfig.DEFAULT.getYamlMapper();
	}
	
    public YamlFileReader(YamlReaderConfig readerConfig) {
		mapper = readerConfig.getYamlMapper();
	}
	
	private final YAMLMapper mapper;
	
	/**
	 *  Read YAML file
	 */
    public <T> T read(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
    	try (InputStream inputStream = inputFileResource.getInputStream()) {
    		return readValueWithoutPrefix(inputStream, clazz);
		}
	}
	
	/**
	 *  Read YAML file
	 *  
	 *  <br> The format of prefix can be the same used for {@link org.springframework.boot.context.properties.ConfigurationProperties ConfigurationProperties}
	 *  <br> if your prefix is one word only, you can use any {@link YamlPrefixType}.
	 */
    public <T> T read(InputFileResource inputFileResource, Class<T> clazz, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
    	try (InputStream inputStream = inputFileResource.getInputStream()) {
    		return readValueWithPrefix(inputStream, clazz, prefix, yamlPrefixType);
		}
	}
	
    private <T> T readValueWithoutPrefix(InputStream inputStream, Class<T> clazz) throws IOException {
        return mapper.readValue(inputStream, clazz);
    }
    
    private <T> T readValueWithPrefix(InputStream inputStream, Class<T> clazz, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
        return mapper.readerFor(clazz)
				     .at(convertPrefix(prefix, yamlPrefixType))
                     .readValue(inputStream);
    }
	
}
