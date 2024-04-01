package io.github.paulmarcelinbejan.toolbox.exception.validation;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -7392271628640948828L;

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}
	
}
