package com.paulmarcelinbejan.toolbox.utils.yaml;

import static com.paulmarcelinbejan.toolbox.constants.Symbols.DOT;
import static com.paulmarcelinbejan.toolbox.constants.Symbols.SLASH;
import static com.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType.CONDENSED;
import static com.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType.NESTED;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.function.Function;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.yaml.config.YamlFileUtilsConfig;
import com.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType;

import lombok.NonNull;

public class YamlFileUtils<T> {
	
	private final Class<T> typeParameterClass;
	
	private final YAMLMapper mapper;
	
	/**
	 * This constructor will use default configuration. 
	 */
	public YamlFileUtils(@NonNull final Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		this.mapper = YamlFileUtilsConfig.DEFAULT.getYamlMapper();
	}
	
	public YamlFileUtils(@NonNull final Class<T> typeParameterClass, @NonNull final YamlFileUtilsConfig yamlFileUtilsConfig) {
		this.typeParameterClass = typeParameterClass;
		this.mapper = yamlFileUtilsConfig.getYamlMapper();
	}
	
	/**
	 *  Read YAML file
	 */
    public T read(@NonNull FileInfo fileInfo) throws IOException {
        T yaml = readValueWithoutPrefix(mapper, FileUtils.createFileInputStream(fileInfo));
		return yaml;
	}
	
	/**
	 *  Read YAML file
	 *  
	 *  <br> The format of prefix must be the same used for {@link org.springframework.boot.context.properties.ConfigurationProperties ConfigurationProperties}
	 *  
	 *  <br> if your prefix is one word only, you can use any {@link YamlPrefixType}.
	 */
    public T read(FileInfo fileInfo, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
        T yaml = readValueWithPrefix(mapper, FileUtils.createFileInputStream(fileInfo), prefix, yamlPrefixType);
		return yaml;
	}
    
    public void write(FileInfo fileInfo, T value) throws IOException {
    	writeValueWithoutPrefix(mapper, FileUtils.createFileOutputStream(fileInfo), value);
    }
    
    public void write(FileInfo fileInfo, String prefix, YamlPrefixType yamlPrefixType, T value) throws IOException {
    	writeValueWithPrefix(mapper, FileUtils.createFileOutputStream(fileInfo), prefix, yamlPrefixType, value);
    }
	
    private T readValueWithoutPrefix(YAMLMapper mapper, InputStream inputStream) throws IOException {
        return mapper.readValue(inputStream, typeParameterClass);
    }
    
    private T readValueWithPrefix(YAMLMapper mapper, InputStream inputStream, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
        return mapper.readerFor(typeParameterClass)
                     .at(fixPrefix(prefix, yamlPrefixType))
                     .readValue(inputStream);
    }
    
    private void writeValueWithoutPrefix(YAMLMapper mapper, OutputStream outputStream, T value) throws IOException {
        mapper.writerFor(typeParameterClass)
  	  		  .writeValue(outputStream, value);
    }
    
    private void writeValueWithPrefix(YAMLMapper mapper, OutputStream outputStream, String prefix, YamlPrefixType yamlPrefixType, T value) throws IOException {
        mapper.writerFor(typeParameterClass)
        	  .withRootName(fixPrefix(prefix, yamlPrefixType))
              .writeValue(outputStream, value);
    }
    
    /**
     * convert prefix used for @ConfigurationProperties
     * into prefix used by @YAMLMapper
     */
    private static String fixPrefix(String prefix, YamlPrefixType yamlPrefixType) {
    	return PREFIX_MAP.get(yamlPrefixType).apply(prefix);
    }
    
	private static final Map<YamlPrefixType, Function<String, String>> PREFIX_MAP = Map.of(
			CONDENSED, YamlFileUtils::convertCondensedPrefix,
			NESTED, YamlFileUtils::convertNestedPrefix
	);
	
	private static String convertCondensedPrefix(String prefix) {
		return SLASH + prefix;
	}
	
	private static String convertNestedPrefix(String prefix) {
		return SLASH + prefix.replace(DOT, SLASH);
	}
	
}
