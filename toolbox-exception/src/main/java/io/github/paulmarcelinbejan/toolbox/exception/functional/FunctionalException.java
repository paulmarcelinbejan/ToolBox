package io.github.paulmarcelinbejan.toolbox.exception.functional;

import java.util.HashMap;
import java.util.Map;

import io.github.paulmarcelinbejan.toolbox.exception.aware.DetailedException;
import lombok.Getter;

@Getter
public class FunctionalException extends Exception implements DetailedException {

	private static final long serialVersionUID = 4172013162798023865L;

	private final String messageCode;
	
	private final Map<String, String> messageParams;

	public FunctionalException(Throwable cause) {
		super(cause);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public FunctionalException(String message) {
		super(message);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public FunctionalException(String message, String messageCode) {
		super(message);
		this.messageCode = messageCode;
		this.messageParams = new HashMap<>();
	}
	
	public FunctionalException(String message, String messageCode, Throwable cause) {
		super(message, cause);
		this.messageCode = messageCode;
		this.messageParams = new HashMap<>();
	}
	
	public FunctionalException(String message, String messageCode, Map<String, String> messageParams) {
		super(message);
		this.messageCode = messageCode;
		this.messageParams = messageParams;
	}
	
	public FunctionalException(String message, String messageCode, Map<String, String> messageParams, Throwable cause) {
		super(message, cause);
		this.messageCode = messageCode;
		this.messageParams = messageParams;
	}

}