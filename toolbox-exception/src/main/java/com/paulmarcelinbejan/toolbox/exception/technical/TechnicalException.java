package com.paulmarcelinbejan.toolbox.exception.technical;

public class TechnicalException extends Exception {
	
	private static final long serialVersionUID = 6430014637371694012L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}

}