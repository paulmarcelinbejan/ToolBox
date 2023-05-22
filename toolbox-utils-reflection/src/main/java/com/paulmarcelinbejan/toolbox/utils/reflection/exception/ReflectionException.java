package com.paulmarcelinbejan.toolbox.utils.reflection.exception;

import java.util.UUID;

public class ReflectionException extends Exception {

	private static final long serialVersionUID = 300539795850465717L;

	public ReflectionException(String message) {
		super(UUID.randomUUID().toString() + " - " + message);
	}

	public ReflectionException(String message, Throwable cause) {
		super(UUID.randomUUID().toString() + " - " + message, cause);
	}

}
