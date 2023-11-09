package com.paulmarcelinbejan.toolbox.utils.io.enums;

public enum DirectoryPath {

	SRC_MAIN_RESOURCES("./src/main/resources/"),
	SRC_TEST_RESOURCES("./src/test/resources/"),
	CLASSPATH("classpath:");
	
    public final String value;

    private DirectoryPath(String value) {
        this.value = value;
    }
    
}