package com.paulmarcelinbejan.architecture.utils.io.common;

public enum FileType {

	CSV(".csv"),
	YAML(".yaml");
	
	public final String value;
	
	private FileType(String value) {
		this.value = value;
	}
	
}
