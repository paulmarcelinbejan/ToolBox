package com.paulmarcelinbejan.architecture.utils.io.yaml.config;

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
