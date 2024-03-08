package io.github.paulmarcelinbejan.toolbox.utils.io.config;

public enum FileType {

    // Image Files
    PNG(".png"),
    JPG(".jpg"),
    GIF(".gif"),
    
    // Data Files
    CSV(".csv"),
    JSON(".json"),
    
    // Text Files
    TXT(".txt"),

    // Document Files
    PDF(".pdf"),
    DOC(".doc"),
    DOCX(".docx"),

    // Configuration Files
    YAML(".yaml"),
    XML(".xml"),

    // Spreadsheet Files
    XLS(".xls"),
    XLSX(".xlsx"),

    // Archive Files
    ZIP(".zip"),
    TAR(".tar"),
    GZ(".gz"),

    // Database Files
    SQL(".sql"),

    // Web Files
    HTML(".html"),
    CSS(".css"),
    
    // Log Files
    LOG(".log");
	
	public final String extension;
	
	FileType(final String extension) {
		this.extension = extension;
	}
	
}
