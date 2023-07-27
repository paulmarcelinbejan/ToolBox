package com.paulmarcelinbejan.toolbox.exception.functional;

import com.paulmarcelinbejan.toolbox.exception.base.BaseException;

public class FunctionalException extends BaseException {

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