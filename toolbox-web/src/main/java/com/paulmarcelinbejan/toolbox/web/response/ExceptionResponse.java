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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private final Instant timestamp;

	@JsonProperty
	private final String status;

	@JsonProperty
	private final String error;

	@JsonProperty
	private String uniqueIdentifier = "";
	
	@JsonProperty
	private final String message;

	@JsonProperty
	private final String stackTrace;
	
	public ExceptionResponse(Exception exception) {
		timestamp = Instant.now();
		status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		message = exception.getMessage();
		stackTrace = ExceptionUtils.getStackTrace(exception);
		log.error(stackTrace);
	}

	public ExceptionResponse(Exception exception, String message) {
		timestamp = Instant.now();
		status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		this.message = message;
		stackTrace = ExceptionUtils.getStackTrace(exception);
		log.error(stackTrace);
	}
	
	/**
	 * fieldValue can contain: status, error, uniqueIdentifier, message
	 */
	public ExceptionResponse(Exception exception, Map<String, String> fieldValue) {
		timestamp = Instant.now();
		status = fieldValue.getOrDefault("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		error = fieldValue.getOrDefault("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		uniqueIdentifier = fieldValue.getOrDefault("uniqueIdentifier", "");
		message = fieldValue.getOrDefault("message", exception.getMessage());
		stackTrace = ExceptionUtils.getStackTrace(exception);
		log.error(stackTrace);
	}
	
	@JsonCreator
	public ExceptionResponse(Instant timestamp, String status, String error, String uniqueIdentifier,
			String message, String stackTrace) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.uniqueIdentifier = uniqueIdentifier;
		this.message = message;
		this.stackTrace = stackTrace;
		log.error(stackTrace);
	}

}
