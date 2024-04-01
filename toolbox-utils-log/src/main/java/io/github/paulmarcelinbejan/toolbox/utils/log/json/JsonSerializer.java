package io.github.paulmarcelinbejan.toolbox.utils.log.json;

public interface JsonSerializer<T> {

	String toJSON(T t);

}
