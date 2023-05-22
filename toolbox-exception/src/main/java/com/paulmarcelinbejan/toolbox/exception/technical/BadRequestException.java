package com.paulmarcelinbejan.toolbox.exception.technical;

import java.util.UUID;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = -1667040961922274367L;

	public BadRequestException(String message) {
		super(UUID.randomUUID().toString() + " - " + message);
	}

	public BadRequestException(String message, Throwable cause) {
		super(UUID.randomUUID().toString() + " - " + message, cause);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}

}
