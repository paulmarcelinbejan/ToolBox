package io.github.paulmarcelinbejan.toolbox.utils.io.resource.local;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileExtension;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.OutputFileResource;
import lombok.Getter;

@Getter
public class LocalOutputFileResource extends AbstractLocalFileResource implements OutputFileResource {
	 
    public LocalOutputFileResource(String directoryPath, String fileName, FileExtension fileExtension) {
    	super(directoryPath, fileName, fileExtension);
    }
	
    @Override
    public OutputStream getOutputStream() throws IOException {
        return Files.newOutputStream(path);
    }
    
    @Override
    public void setFileName(String fileName) {
    	this.fileName = fileName;
        this.fullPath = new StringBuilder().append(directoryPath).append(this.fileName).append(fileExtension.extension).toString();
        this.path = Path.of(this.fullPath);
    }

}
