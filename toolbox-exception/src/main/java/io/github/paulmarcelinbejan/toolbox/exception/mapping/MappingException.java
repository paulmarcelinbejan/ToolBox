package io.github.paulmarcelinbejan.toolbox.exception.mapping;

import java.util.HashMap;
import java.util.Map;

import io.github.paulmarcelinbejan.toolbox.exception.aware.DetailedException;
import lombok.Getter;

@Getter
public class MappingException extends RuntimeException implements DetailedException {

	private static final long serialVersionUID = -3655961291465196761L;

	private final String messageCode;
	
	private final Map<String, String> messageParams;

	public MappingException(Throwable cause) {
		super(cause);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public MappingException(String message) {
		super(message);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public MappingException(String message, Throwable cause) {
		super(message, cause);
		this.messageCode = "";
		this.messageParams = new HashMap<>();
	}
	
	public MappingException(String message, String messageCode) {
		super(message);
		this.messageCode = messageCode;
		this.messageParams = new HashMap<>();
	}
	
	public MappingException(String message, String messageCode, Throwable cause) {
		super(message, cause);
		this.messageCode = messageCode;
		this.messageParams = new HashMap<>();
	}
	
	public MappingException(String message, String messageCode, Map<String, String> messageParams) {
		super(message);
		this.messageCode = messageCode;
		this.messageParams = messageParams;
	}
	
	public MappingException(String message, String messageCode, Map<String, String> messageParams, Throwable cause) {
		super(message, cause);
		this.messageCode = messageCode;
		this.messageParams = messageParams;
	}
	
}
