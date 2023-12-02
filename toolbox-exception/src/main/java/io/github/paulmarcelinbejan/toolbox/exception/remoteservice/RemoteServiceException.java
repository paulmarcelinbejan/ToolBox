package io.github.paulmarcelinbejan.toolbox.exception.remoteservice;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
public class RemoteServiceException extends Exception {
	
	private static final long serialVersionUID = 5932035092343810410L;
	
	@Getter
	private final String remoteService;
	
	public RemoteServiceException(String message, String remoteService) {
		super(message);
		this.remoteService = remoteService;
	}

	public RemoteServiceException(String message, Throwable cause, String remoteService) {
		super(message, cause);
		this.remoteService = remoteService;
	}

	public RemoteServiceException(Throwable cause, String remoteService) {
		super(cause);
		this.remoteService = remoteService;
	}

}