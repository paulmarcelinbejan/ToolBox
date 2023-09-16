package com.paulmarcelinbejan.toolbox.utils.io.common;

import static com.paulmarcelinbejan.toolbox.constants.Symbols.UNDERSCORE;

import lombok.NonNull;

public class FileInfo {

	@NonNull 
	private final String directoryPath;
	
	@NonNull 
	private String fileNameWithoutExtension;
	
	public FileInfo(@NonNull String fileNameWithoutExtension) {
		this.directoryPath = "";
		this.fileNameWithoutExtension = fileNameWithoutExtension;
	}
	
	public FileInfo(@NonNull String directoryPath, @NonNull String fileNameWithoutExtension) {
		this.directoryPath = directoryPath;
		this.fileNameWithoutExtension = fileNameWithoutExtension;
	}

	// The FileType is not a field of FileInfo to prevent passing a wrong value.
	// Each Utility class know what is the FileType that must be used.
	
	public final String getFullPath(@NonNull FileType fileType) {
		return new StringBuilder()
				.append(directoryPath)
				.append(fileNameWithoutExtension)
				.append(fileType.value)
				.toString();
	}
	
	public final void appendCurrentTimeMillisToFileName() {
		this.fileNameWithoutExtension = new StringBuilder()
				.append(fileNameWithoutExtension)
				.append(UNDERSCORE)
				.append(System.currentTimeMillis())
				.toString();
	}
	
}
