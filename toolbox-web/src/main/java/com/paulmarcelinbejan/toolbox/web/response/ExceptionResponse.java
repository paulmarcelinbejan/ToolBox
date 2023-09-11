package com.paulmarcelinbejan.toolbox.web.response;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.exception.utils.ExceptionUtils;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ExceptionResponse {

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private final LocalDateTime timestamp;

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
		timestamp = LocalDateTime.now();
		status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		message = exception.getMessage();
		stackTrace = ExceptionUtils.getStackTrace(exception);
		log.error(stackTrace);
	}

	public ExceptionResponse(Exception exception, String message) {
		timestamp = LocalDateTime.now();
		status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		this.message = message;
		stackTrace = ExceptionUtils.getStackTrace(exception);
		log.error(stackTrace);
	}
	
	public ExceptionResponse(Exception exception, Map<String, String> fieldValue) {
		timestamp = LocalDateTime.now();
		status = fieldValue.getOrDefault("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		error = fieldValue.getOrDefault("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		uniqueIdentifier = fieldValue.getOrDefault("uniqueIdentifier", "");
		message = fieldValue.getOrDefault("message", exception.getMessage());
		stackTrace = ExceptionUtils.getStackTrace(exception);
		log.error(stackTrace);
	}
	
	@JsonCreator
	public ExceptionResponse(LocalDateTime timestamp, String status, String error, String uniqueIdentifier,
			String message, String stackTrace) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.uniqueIdentifier = uniqueIdentifier;
		this.message = message;
		this.stackTrace = stackTrace;
	}

}
