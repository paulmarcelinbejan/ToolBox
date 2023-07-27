package com.paulmarcelinbejan.toolbox.exception.remoteservice;

import com.paulmarcelinbejan.toolbox.exception.base.BaseException;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
public class RemoteServiceException extends BaseException {
	
	private static final long serialVersionUID = 5932035092343810410L;
	
	@Getter
	private final String remoteService;

	public RemoteServiceException(String message, String remoteService) {
		super(message);
		this.remoteService = remoteService;
	}

	public RemoteServiceException(String message, String remoteService, String uniqueIdentifier) {
		super(message, uniqueIdentifier);
		this.remoteService = remoteService;
	}
	

}