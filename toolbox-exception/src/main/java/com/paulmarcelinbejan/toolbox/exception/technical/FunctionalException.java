package com.paulmarcelinbejan.toolbox.exception.technical;

import java.util.UUID;

public class FunctionalException extends Exception {

	private static final long serialVersionUID = -8408094491908268042L;

	public FunctionalException(String message) {
		super(UUID.randomUUID().toString() + " - " + message);
	}

	public FunctionalException(String message, Throwable cause) {
		super(UUID.randomUUID().toString() + " - " + message, cause);
	}

	public FunctionalException(Throwable cause) {
		super(cause);
	}

}