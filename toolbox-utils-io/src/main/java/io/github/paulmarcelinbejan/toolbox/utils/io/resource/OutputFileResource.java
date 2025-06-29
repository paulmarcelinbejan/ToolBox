package io.github.paulmarcelinbejan.toolbox.utils.io.resource;

import java.io.IOException;
import java.io.OutputStream;

public interface OutputFileResource extends FileResource {

    OutputStream getOutputStream() throws IOException;
    
    void setFileName(String fileName);
    
}
