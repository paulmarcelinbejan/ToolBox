package io.github.paulmarcelinbejan.toolbox.utils.validation.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 5567362271120511022L;

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
