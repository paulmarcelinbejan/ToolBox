package com.paulmarcelinbejan.toolbox.exception.base;

import com.paulmarcelinbejan.toolbox.exception.utils.ExceptionUtils;

import lombok.Getter;

public class BaseException extends Exception {

	private static final long serialVersionUID = 3841664769072540143L;
	
	@Getter
	private final String uniqueIdentifier;
	
	public BaseException(String message) {
		super(message);
		uniqueIdentifier = ExceptionUtils.getUniqueIdentifier();
	}
	
	public BaseException(String message, String uniqueIdentifier) {
		super(message);
		this.uniqueIdentifier = uniqueIdentifier;
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		uniqueIdentifier = ExceptionUtils.getUniqueIdentifier();
	}

	public BaseException(Throwable cause) {
		super(cause);
		uniqueIdentifier = ExceptionUtils.getUniqueIdentifier();
	}
	
}
