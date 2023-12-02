package io.github.paulmarcelinbejan.toolbox.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {

	public static File createFile(final FileInfo fileInfo) {
		return new File(fileInfo.getFullPath());
	}
	
	public static FileReader createFileReader(final FileInfo fileInfo) throws FileNotFoundException {
		return new FileReader(fileInfo.getFullPath());
	}
	
	public static FileWriter createFileWriter(final FileInfo fileInfo) throws IOException {
		return new FileWriter(fileInfo.getFullPath());
	}
	
	public static FileInputStream createFileInputStream(final FileInfo fileInfo) throws FileNotFoundException {
		return new FileInputStream(createFile(fileInfo));
	}
	
	public static FileOutputStream createFileOutputStream(final FileInfo fileInfo) throws FileNotFoundException {
		return new FileOutputStream(createFile(fileInfo));
	}
	
}
