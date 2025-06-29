package io.github.paulmarcelinbejan.toolbox.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalFileUtils {

	public static File createFile(String fullPath) {
		return new File(fullPath);
	}
	
	public static FileReader createFileReader(String fullPath) throws FileNotFoundException {
		return new FileReader(fullPath);
	}
	
	public static FileWriter createFileWriter(String fullPath) throws IOException {
		return new FileWriter(fullPath);
	}
	
	public static FileInputStream createFileInputStream(String fullPath) throws FileNotFoundException {
		return new FileInputStream(createFile(fullPath));
	}
	
	public static FileOutputStream createFileOutputStream(String fullPath) throws FileNotFoundException {
		return new FileOutputStream(createFile(fullPath));
	}
	
}
