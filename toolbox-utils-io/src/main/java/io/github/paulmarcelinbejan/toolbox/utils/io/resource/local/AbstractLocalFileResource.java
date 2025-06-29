package io.github.paulmarcelinbejan.toolbox.utils.io.resource.local;

import java.nio.file.Path;

import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileExtension;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class AbstractLocalFileResource {

	protected Path path;
	
	protected String fullPath;
	
	protected String directoryPath;
	
	protected String fileName;
	
	protected FileExtension fileExtension;
	
    protected AbstractLocalFileResource(String directoryPath, String fileName, FileExtension fileExtension) {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fullPath = new StringBuilder().append(directoryPath).append(fileName).append(fileExtension.extension).toString();
        this.path = Path.of(fullPath);
    }
	
}
