package io.github.paulmarcelinbejan.toolbox.exception.technical;

public class TechnicalRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = -2347970804181429610L;

	public TechnicalRuntimeException(String message) {
		super(message);
	}

	public TechnicalRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TechnicalRuntimeException(Throwable cause) {
		super(cause);
	}

}