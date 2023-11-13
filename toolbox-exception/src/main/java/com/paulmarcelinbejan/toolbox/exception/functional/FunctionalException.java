package com.paulmarcelinbejan.toolbox.exception.functional;

public class FunctionalException extends Exception {

	private static final long serialVersionUID = 7539736532128095750L;
	
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