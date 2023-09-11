package com.paulmarcelinbejan.toolbox.utils.reflection.exception;

public class ReflectionException extends RuntimeException {

	private static final long serialVersionUID = 300539795850465717L;

	public ReflectionException(String message) {
		super(message);
	}

	public ReflectionException(String message, Throwable cause) {
		super(message, cause);
	}

}
