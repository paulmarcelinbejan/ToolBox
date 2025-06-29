package io.github.paulmarcelinbejan.toolbox.utils.ndjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.paulmarcelinbejan.toolbox.utils.io.resource.InputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.json.config.JsonReaderConfig;

public class NdJsonFileReader {

    private final JsonMapper mapper;

    public NdJsonFileReader() {
        this(JsonReaderConfig.DEFAULT);
    }

    public NdJsonFileReader(JsonReaderConfig config) {
        this.mapper = config.getJsonMapper();
    }
    
	public <T> T read(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
		try (InputStream inputStream = inputFileResource.getInputStream()) {
			return mapper.readValue(inputStream, clazz);
		}
    }
	
    public <T> List<T> readList(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileResource.getInputStream()))) {
            List<T> result = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    result.add(mapper.readValue(line, clazz));
                }
            }
            return result;
        }
    }
    
    public <T> Iterator<T> streamingIterator(InputFileResource inputFileResource, Class<T> clazz) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileResource.getInputStream()));
        return new Iterator<>() {
            String nextLine = advance();

            private String advance() {
                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!line.isBlank()) return line;
                    }
                    reader.close(); // end of file
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public T next() {
                if (nextLine == null) throw new NoSuchElementException();
                try {
                    T value = mapper.readValue(nextLine, clazz);
                    nextLine = advance();
                    return value;
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
        };
    }
    
}
