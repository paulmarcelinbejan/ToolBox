package io.github.paulmarcelinbejan.toolbox.utils.yaml.config;

public enum YamlPrefixType {

	/**
	 * Example:
	 * <pre>
	 * abc:
	 *     xyz:
	 * </pre>
	 */
	NESTED,
	
	/**
	 * Example: 
	 * <pre>
	 * abc.xyz:
	 * </pre>
	 */
	CONDENSED;
	    
}
