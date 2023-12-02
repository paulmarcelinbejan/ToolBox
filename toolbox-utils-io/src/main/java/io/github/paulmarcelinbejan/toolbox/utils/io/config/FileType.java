package io.github.paulmarcelinbejan.toolbox.utils.io.config;

public enum FileType {

	CSV(".csv"),
	JSON(".json"),
	PDF(".pdf"),
	YAML(".yaml");
	
	public final String extension;
	
	private FileType(String extension) {
		this.extension = extension;
	}
	
}
