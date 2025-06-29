package io.github.paulmarcelinbejan.toolbox.utils.io.resource;

import java.io.IOException;
import java.io.InputStream;

public interface InputFileResource extends FileResource {

    InputStream getInputStream() throws IOException;
    
}
