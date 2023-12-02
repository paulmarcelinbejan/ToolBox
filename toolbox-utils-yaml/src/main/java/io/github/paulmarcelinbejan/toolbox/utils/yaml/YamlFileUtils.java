package io.github.paulmarcelinbejan.toolbox.utils.yaml;

import static io.github.paulmarcelinbejan.toolbox.constants.Symbols.DOT;
import static io.github.paulmarcelinbejan.toolbox.constants.Symbols.SLASH;
import static io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType.CONDENSED;
import static io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType.NESTED;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.function.Function;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlFileUtilsConfig;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlReaderConfig;
import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlWriterConfig;
import lombok.NonNull;

public class YamlFileUtils {
	
	/**
	 * This constructor will use default configuration. 
	 */
	public YamlFileUtils() {
		this.mapperReader = YamlFileUtilsConfig.DEFAULT.getReaderConfig().getYamlMapper();
		this.mapperWriter = YamlFileUtilsConfig.DEFAULT.getWriterConfig().getYamlMapper();
	}
	
	public YamlFileUtils(@NonNull final YamlFileUtilsConfig yamlFileUtilsConfig) {
		this.mapperReader = yamlFileUtilsConfig.getReaderConfig().getYamlMapper();
		this.mapperWriter = yamlFileUtilsConfig.getWriterConfig().getYamlMapper();
	}
	
    public YamlFileUtils(YamlReaderConfig readerConfig, YamlWriterConfig writerConfig) {
		this.mapperReader = readerConfig.getYamlMapper();
		this.mapperWriter = writerConfig.getYamlMapper();
	}
	
	private final YAMLMapper mapperReader;
	private final YAMLMapper mapperWriter;
	
	/**
	 *  Read YAML file
	 */
    public <T> T read(@NonNull FileInfo fileInfo, Class<T> clazz) throws IOException {
    	try (InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo)) {
    		return readValueWithoutPrefix(mapperReader, fileInputStream, clazz);
		}
	}
	
	/**
	 *  Read YAML file
	 *  
	 *  <br> The format of prefix can be the same used for {@link org.springframework.boot.context.properties.ConfigurationProperties ConfigurationProperties}
	 *  <br> if your prefix is one word only, you can use any {@link YamlPrefixType}.
	 */
    public <T> T read(FileInfo fileInfo, Class<T> clazz, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
    	try (InputStream fileInputStream = FileUtils.createFileInputStream(fileInfo)) {
    		return readValueWithPrefix(mapperReader, FileUtils.createFileInputStream(fileInfo), clazz, prefix, yamlPrefixType);
		}
	}
    
    public <T> void write(FileInfo fileInfo, Class<T> clazz, T value) throws IOException {
    	try (OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo)) {
    		writeValueWithoutPrefix(mapperWriter, fileOutputStream, clazz, value);
		}
    }
    
    public <T> void write(FileInfo fileInfo, Class<T> clazz, T value, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
    	try (OutputStream fileOutputStream = FileUtils.createFileOutputStream(fileInfo)) {
    		writeValueWithPrefix(mapperWriter, fileOutputStream, clazz, value, prefix, yamlPrefixType);
		}
    }
	
    private static <T> T readValueWithoutPrefix(YAMLMapper mapper, InputStream inputStream, Class<T> clazz) throws IOException {
        return mapper.readValue(inputStream, clazz);
    }
    
    private static <T> T readValueWithPrefix(YAMLMapper mapper, InputStream inputStream, Class<T> clazz, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
        return mapper.readerFor(clazz)
                     .at(fixPrefix(prefix, yamlPrefixType))
                     .readValue(inputStream);
    }
    
    private static <T> void writeValueWithoutPrefix(YAMLMapper mapper, OutputStream outputStream, Class<T> clazz, T value) throws IOException {
        mapper.writerFor(clazz)
  	  		  .writeValue(outputStream, value);
    }
    
    private static <T> void writeValueWithPrefix(YAMLMapper mapper, OutputStream outputStream, Class<T> clazz, T value, String prefix, YamlPrefixType yamlPrefixType) throws IOException {
        mapper.writerFor(clazz)
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
