package com.paulmarcelinbejan.architecture.constants.enums;

public enum DirectoryPath {

	SRC_TEST_RESOURCES("./src/test/resources/");
	
    public final String value;

    private DirectoryPath(String value) {
        this.value = value;
    }
    
}