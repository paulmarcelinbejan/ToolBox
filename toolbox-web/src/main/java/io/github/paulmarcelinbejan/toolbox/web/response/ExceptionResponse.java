package io.github.paulmarcelinbejan.toolbox.web.response;

import java.time.Instant;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.paulmarcelinbejan.toolbox.exception.utils.ExceptionUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ExceptionResponse {

	@JsonProperty
	private final String uniqueIdentifier;
	
	@JsonProperty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private final Instant timestampUTC;

	@JsonProperty
	private final String status;

	@JsonProperty
	private final String error;
	
	@JsonProperty
	private final String exceptionType;
	
	@JsonProperty
	private final String message;
	
	public ExceptionResponse(Exception exception) {
		this(exception,
			 ExceptionUtils.getUniqueIdentifier(), 
			 Instant.now(), 
			 String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), 
			 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
			 exception.getClass().getSimpleName(), 
			 exception.getMessage());
	}

	public ExceptionResponse(Exception exception, String message) {
		this(exception,
			 ExceptionUtils.getUniqueIdentifier(), 
		     Instant.now(), 
		     String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), 
			 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
			 exception.getClass().getSimpleName(), 
			 message);
	}
	
	public ExceptionResponse(Exception exception, Map<ExceptionField, String> fieldValue) {
		this(exception,
			 fieldValue.getOrDefault(ExceptionField.UNIQUEIDENTIFIER, ExceptionUtils.getUniqueIdentifier()), 
		     Instant.now(), 
		     fieldValue.getOrDefault(ExceptionField.STATUS, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())), 
		     fieldValue.getOrDefault(ExceptionField.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()), 
			 exception.getClass().getSimpleName(), 
			 fieldValue.getOrDefault(ExceptionField.MESSAGE, exception.getMessage()));
	}
	
	public ExceptionResponse(Exception exception, String uniqueIdentifier, Instant timestamp, String status, String error,
			String exceptionType, String message) {
		this(uniqueIdentifier, timestamp, status, error, exceptionType, message);
		log.error("Exception Stack Trace of " + uniqueIdentifier, exception);
	}
	
	@JsonCreator
	public ExceptionResponse(
			String uniqueIdentifier, 
			Instant timestampUTC,
			String status, 
			String error,
			String exceptionType, 
			String message) {
		
		this.uniqueIdentifier = uniqueIdentifier;
		this.timestampUTC = timestampUTC;
		this.status = status;
		this.error = error;
		this.exceptionType = exceptionType;
		this.message = message;

	}
	
	public enum ExceptionField {
		
		UNIQUEIDENTIFIER("uniqueIdentifier"),
		STATUS("status"),
		ERROR("error"),
		EXCEPTIONTYPE("exceptionType"),
		MESSAGE("message");
		
		public final String fieldName;
		
		private ExceptionField(String fieldName) {
	    	this.fieldName = fieldName;
	    }
		
	}

}
