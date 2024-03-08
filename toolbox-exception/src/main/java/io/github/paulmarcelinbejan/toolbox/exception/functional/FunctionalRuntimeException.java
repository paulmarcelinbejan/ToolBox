package io.github.paulmarcelinbejan.toolbox.exception.functional;

public class FunctionalRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -1243460268245173580L;

	public FunctionalRuntimeException(String message) {
		super(message);
	}

	public FunctionalRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionalRuntimeException(Throwable cause) {
		super(cause);
	}

}