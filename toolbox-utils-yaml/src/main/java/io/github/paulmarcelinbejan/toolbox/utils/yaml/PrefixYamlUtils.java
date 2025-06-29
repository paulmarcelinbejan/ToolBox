package io.github.paulmarcelinbejan.toolbox.utils.yaml;

import static io.github.paulmarcelinbejan.toolbox.base.constants.Symbols.AsString.DOT;
import static io.github.paulmarcelinbejan.toolbox.base.constants.Symbols.AsString.SLASH;
import static io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType.CONDENSED;
import static io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType.NESTED;

import java.util.Map;
import java.util.function.Function;

import io.github.paulmarcelinbejan.toolbox.utils.yaml.config.YamlPrefixType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class PrefixYamlUtils {

	private static final Map<YamlPrefixType, Function<String, String>> PREFIX_MAP = Map.of(
			CONDENSED, PrefixYamlUtils::convertCondensedPrefix,
			NESTED, PrefixYamlUtils::convertNestedPrefix
	);
	
    /**
     * convert prefix used for @ConfigurationProperties
     * into prefix used by @YAMLMapper
     */
	protected static String convertPrefix(String prefix, YamlPrefixType yamlPrefixType) {
    	return PREFIX_MAP.get(yamlPrefixType).apply(prefix);
    }
	
	private static String convertCondensedPrefix(String prefix) {
		return SLASH + prefix;
	}
	
	private static String convertNestedPrefix(String prefix) {
		return SLASH + prefix.replace(DOT, SLASH);
	}
	
}
