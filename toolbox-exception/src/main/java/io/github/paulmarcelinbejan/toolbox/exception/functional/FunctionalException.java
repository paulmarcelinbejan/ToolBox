package io.github.paulmarcelinbejan.toolbox.exception.functional;

public class FunctionalException extends Exception {

	private static final long serialVersionUID = 4172013162798023865L;

	public FunctionalException(String message) {
		super(message);
	}

	public FunctionalException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionalException(Throwable cause) {
		super(cause);
	}

}