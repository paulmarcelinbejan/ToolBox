package io.github.paulmarcelinbejan.toolbox.exception.technical;

import java.util.HashMap;
import java.util.Map;

import io.github.paulmarcelinbejan.toolbox.exception.aware.DetailedException;
import lombok.Getter;

@Getter
public class TechnicalRuntimeException extends RuntimeException implements DetailedException {
	
	private static final long serialVersionUID = -2347970804181429610L;

	private final String messageCode;
	
	private final Map<String, String> messageParams;

	public TechnicalRuntimeException(Throwable cause) {
		super(cause);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public TechnicalRuntimeException(String message) {
		super(message);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public TechnicalRuntimeException(String message, String messageCode) {
		super(message);
		this.messageCode = messageCode;
		this.messageParams = new HashMap<>();
	}
	
	public TechnicalRuntimeException(String message, String messageCode, Throwable cause) {
		super(message, cause);
		this.messageCode = messageCode;
		this.messageParams = new HashMap<>();
	}
	
	public TechnicalRuntimeException(String message, String messageCode, Map<String, String> messageParams) {
		super(message);
		this.messageCode = messageCode;
		this.messageParams = messageParams;
	}
	
	public TechnicalRuntimeException(String message, String messageCode, Map<String, String> messageParams, Throwable cause) {
		super(message, cause);
		this.messageCode = messageCode;
		this.messageParams = messageParams;
	}

}