package com.paulmarcelinbejan.toolbox.exception.technical;

import com.paulmarcelinbejan.toolbox.exception.base.BaseException;

public class TechnicalException extends BaseException {
	
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