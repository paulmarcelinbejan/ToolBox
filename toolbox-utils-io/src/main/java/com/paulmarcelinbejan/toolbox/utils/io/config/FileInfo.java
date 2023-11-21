package com.paulmarcelinbejan.toolbox.utils.io.config;

import static com.paulmarcelinbejan.toolbox.constants.Symbols.UNDERSCORE;

import lombok.NonNull;

public class FileInfo {

	@NonNull 
	private final String directoryPath;
	
	@NonNull 
	private String fileNameWithoutExtension;
	
	@NonNull 
	private FileType fileType;
	
	public FileInfo(@NonNull String fileNameWithoutExtension, @NonNull FileType fileType) {
		this.directoryPath = "";
		this.fileNameWithoutExtension = fileNameWithoutExtension;
		this.fileType = fileType;
	}
	
	public FileInfo(@NonNull String directoryPath, @NonNull String fileNameWithoutExtension, @NonNull FileType fileType) {
		this.directoryPath = directoryPath;
		this.fileNameWithoutExtension = fileNameWithoutExtension;
		this.fileType = fileType;
	}
	
	public final String getFullPath() {
		return new StringBuilder()
				.append(directoryPath)
				.append(fileNameWithoutExtension)
				.append(fileType.extension)
				.toString();
	}
	
	/**
	 * This method append a currentTimeMillis to the name of the file.
	 * Useful when you don't want to override files.
	 */
	public final void appendCurrentTimeMillisToFileName() {
		this.fileNameWithoutExtension = new StringBuilder()
				.append(fileNameWithoutExtension)
				.append(UNDERSCORE)
				.append(System.currentTimeMillis())
				.toString();
	}
	
}
