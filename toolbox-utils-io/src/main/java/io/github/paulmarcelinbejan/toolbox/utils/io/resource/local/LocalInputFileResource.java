package io.github.paulmarcelinbejan.toolbox.utils.io.resource.local;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileExtension;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.InputFileResource;

public class LocalInputFileResource extends AbstractLocalFileResource implements InputFileResource {
	 
    public LocalInputFileResource(String directoryPath, String fileName, FileExtension fileExtension) {
        super(directoryPath, fileName, fileExtension);
    }
	
    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(path);
    }

}
