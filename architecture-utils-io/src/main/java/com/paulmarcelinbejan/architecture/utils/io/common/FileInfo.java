package com.paulmarcelinbejan.architecture.utils.io.common;

import static com.paulmarcelinbejan.architecture.constants.Symbols.UNDERSCORE;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class FileInfo {

	@NonNull 
	private final String directoryPath;
	
	@NonNull 
	private String fileNameWithoutExtension;
	
	// The FileType is not a field of FileInfo to prevent passing a wrong value.
	// Each Utility class know what is the FileType that must be used.
	
	public final String getFullPath(@NonNull FileType fileType) {
		return directoryPath + fileNameWithoutExtension + fileType.value;
	}
	
	public final void appendCurrentTimeMillisToFileName() {
		this.fileNameWithoutExtension = fileNameWithoutExtension + UNDERSCORE + System.currentTimeMillis();
	}
	
}
