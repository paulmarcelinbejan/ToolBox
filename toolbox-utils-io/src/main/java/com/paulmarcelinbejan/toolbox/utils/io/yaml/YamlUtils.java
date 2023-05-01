package com.paulmarcelinbejan.toolbox.utils.io.yaml;

import static com.paulmarcelinbejan.toolbox.constants.Symbols.DOT;
import static com.paulmarcelinbejan.toolbox.constants.Symbols.SLASH;
import static com.paulmarcelinbejan.toolbox.utils.io.common.FileType.YAML;
import static com.paulmarcelinbejan.toolbox.utils.io.yaml.config.YamlPrefixType.CONDENSED;
import static com.paulmarcelinbejan.toolbox.utils.io.yaml.config.YamlPrefixType.NESTED;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.tuple.Pair;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.paulmarcelinbejan.toolbox.utils.io.common.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.io.yaml.config.YamlPrefixType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// TODO implement write method
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YamlUtils {
	
	/**
	 *  Read YAML file <br>
	 *  
	 *  <p>
	 *  How to use: 
	 *  <pre> {@code
	 *  	
	 *  YamlUtils.read(ConfigProperties.class, fileInfo);
	 *  
	 *  } </pre>
	 *  
	 */
    public static <ConfigProperties> ConfigProperties read(@NonNull Class<ConfigProperties> configClass, @NonNull FileInfo fileInfo) throws IOException {
        return readValueWithoutPrefix(configClass, createYamlMapper(), createFileInputStream(fileInfo));
	}
	
	/**
	 *  Read YAML file <br>
	 *  The format of prefix must be the same used for {@link org.springframework.boot.context.properties.ConfigurationProperties ConfigurationProperties}
	 *  
	 *  <p>
	 *  How to use:
	 *  <br>
	 *  if your prefix is one word only, you can use any {@link YamlPrefixType}.
	 *  
	 *  <pre> {@code
	 *  	
	 *  YamlUtils.read(
	 *		ConfigProperties.class, 
	 *		fileInfo, 
	 *		Pair.of(YamlPrefixType.NESTED, "my.prefix"));
	 *  
	 *  } </pre>
	 *  
	 */
    public static <ConfigProperties> ConfigProperties read(@NonNull Class<ConfigProperties> configClass, 
    													   @NonNull FileInfo fileInfo, 
    													   @NonNull Pair<@NonNull YamlPrefixType, @NonNull String> prefix) throws IOException {
        return readValueWithPrefix(configClass, createYamlMapper(), createFileInputStream(fileInfo), prefix);
	}

	private static FileInputStream createFileInputStream(FileInfo fileInfo) throws FileNotFoundException {
		return new FileInputStream(new File(fileInfo.getFullPath(YAML)));
	}
	
	private static YAMLMapper createYamlMapper() {
		YAMLMapper mapper = new YAMLMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		return mapper;
	}
	
    private static <ConfigProperties> ConfigProperties readValueWithoutPrefix(Class<ConfigProperties> configClass, 
    																		  YAMLMapper mapper, 
    																		  InputStream inputStream) throws IOException {
        return mapper.readValue(inputStream, configClass);
    }
    
    private static <ConfigProperties> ConfigProperties readValueWithPrefix(Class<ConfigProperties> configClass, 
    																	   YAMLMapper mapper, InputStream inputStream, 
    																	   Pair<YamlPrefixType, String> prefix) throws IOException {
        return mapper.readerFor(configClass)
                     .at(fixPrefix(prefix))
                     .readValue(inputStream);
    }
    
    /**
     * convert prefix used for @ConfigurationProperties
     * into prefix used by @YAMLMapper
     */
    private static String fixPrefix(Pair<YamlPrefixType, String> prefixPair) {
    	return PREFIX_MAP.get(prefixPair.getLeft()).apply(prefixPair.getRight());
    }
    
	private static final Map<YamlPrefixType, Function<String, String>> PREFIX_MAP = Map.of(
			CONDENSED, YamlUtils::convertCondensedPrefix,
			NESTED, YamlUtils::convertNestedPrefix
	);
	
	private static String convertCondensedPrefix(String prefix) {
		return SLASH + prefix;
	}
	
	private static String convertNestedPrefix(String prefix) {
		return SLASH + prefix.replace(DOT, SLASH);
	}
	
}
