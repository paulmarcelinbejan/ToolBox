package io.github.paulmarcelinbejan.toolbox.exception.mapping;

public class MappingException extends RuntimeException {

	private static final long serialVersionUID = -362407787401934174L;

	public MappingException(String message) {
		super(message);
	}

	public MappingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MappingException(Throwable cause) {
		super(cause);
	}
	
}
