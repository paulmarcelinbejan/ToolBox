package io.github.paulmarcelinbejan.toolbox.exception.aware;

import java.util.Map;

public interface DetailedException {

    String getMessageCode();
    
    Map<String, String> getMessageParams();
    
}
