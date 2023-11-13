package com.paulmarcelinbejan.toolbox.web.response;

import java.time.Instant;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paulmarcelinbejan.toolbox.exception.utils.ExceptionUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ExceptionResponse {

	@JsonProperty
	private final String uniqueIdentifier;
	
	@JsonProperty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private final Instant timestamp;

	@JsonProperty
	private final String status;

	@JsonProperty
	private final String error;
	
	@JsonProperty
	private final String exception;
	
	@JsonProperty
	private final String message;

	@JsonProperty
	private final String stackTrace;
	
	public ExceptionResponse(Exception exception) {
		this(ExceptionUtils.getUniqueIdentifier(), 
			 Instant.now(), 
			 String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), 
			 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
			 exception.getClass().getSimpleName(), 
			 exception.getMessage(), 
			 ExceptionUtils.getStackTrace(exception));
	}

	public ExceptionResponse(Exception exception, String message) {
		this(ExceptionUtils.getUniqueIdentifier(), 
		     Instant.now(), 
		     String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), 
			 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
			 exception.getClass().getSimpleName(), 
			 message, 
			 ExceptionUtils.getStackTrace(exception));
	}
	
	public ExceptionResponse(Exception exception, Map<ExceptionField, String> fieldValue) {
		this(fieldValue.getOrDefault(ExceptionField.UNIQUEIDENTIFIER, ExceptionUtils.getUniqueIdentifier()), 
		     Instant.now(), 
		     fieldValue.getOrDefault(ExceptionField.STATUS, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())), 
		     fieldValue.getOrDefault(ExceptionField.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()), 
			 exception.getClass().getSimpleName(), 
			 fieldValue.getOrDefault(ExceptionField.MESSAGE, exception.getMessage()), 
			 ExceptionUtils.getStackTrace(exception));
	}
	
	@JsonCreator
	public ExceptionResponse(String uniqueIdentifier, Instant timestamp, String status, String error,
			String exception, String message, String stackTrace) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.exception = exception;
		this.uniqueIdentifier = uniqueIdentifier;
		this.message = message;
		this.stackTrace = stackTrace;
		log.error(stackTrace);
	}
	
	
	public enum ExceptionField {
		
		UNIQUEIDENTIFIER("uniqueIdentifier"),
		STATUS("status"),
		ERROR("error"),
		EXCEPTION("exception"),
		MESSAGE("message");
		
		public final String fieldName;
		
		private ExceptionField(String fieldName) {
	    	this.fieldName = fieldName;
	    }
		
	}

}
