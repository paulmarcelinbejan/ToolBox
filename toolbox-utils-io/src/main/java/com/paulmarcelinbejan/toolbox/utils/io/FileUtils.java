package com.paulmarcelinbejan.toolbox.utils.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {

	public static File createFile(final FileInfo fileInfo, FileType fileType) {
		return new File(fileInfo.getFullPath(fileType));
	}
	
	public static FileReader createFileReader(final FileInfo fileInfo, FileType fileType) throws FileNotFoundException {
		return new FileReader(fileInfo.getFullPath(fileType));
	}
	
}
