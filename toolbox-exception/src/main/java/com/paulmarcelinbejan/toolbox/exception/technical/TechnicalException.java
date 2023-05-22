package com.paulmarcelinbejan.toolbox.exception.technical;

import java.util.UUID;

public class TechnicalException extends Exception {

	private static final long serialVersionUID = -8408094491908268042L;

	public TechnicalException(String message) {
		super(UUID.randomUUID().toString() + " - " + message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(UUID.randomUUID().toString() + " - " + message, cause);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}

}