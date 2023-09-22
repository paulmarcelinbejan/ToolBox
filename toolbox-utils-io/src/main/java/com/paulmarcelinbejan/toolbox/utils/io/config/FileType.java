package com.paulmarcelinbejan.toolbox.utils.io.config;

public enum FileType {

	CSV(".csv"),
	JSON(".json"),
	YAML(".yaml");
	
	public final String extension;
	
	private FileType(String extension) {
		this.extension = extension;
	}
	
}
