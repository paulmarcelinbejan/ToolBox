package com.paulmarcelinbejan.toolbox.constants.enums;

public enum DirectoryPath {

	SRC_MAIN_RESOURCES("./src/main/resources/"),
	SRC_TEST_RESOURCES("./src/test/resources/");
	
    public final String value;

    private DirectoryPath(String value) {
        this.value = value;
    }
    
}