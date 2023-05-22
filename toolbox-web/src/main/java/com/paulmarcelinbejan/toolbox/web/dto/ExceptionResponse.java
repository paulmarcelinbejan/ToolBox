package com.paulmarcelinbejan.toolbox.web.dto;

import java.time.LocalDateTime;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private LocalDateTime timestamp;

	private String status;

	private String error;

	private String message;

	private String stackTrace;

	private String path;

	public ExceptionResponse(Exception exception, String path) {
		timestamp = LocalDateTime.now();
		status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		message = exception.getMessage();
		stackTrace = ExceptionUtils.getStackTrace(exception);
		this.path = path;
	}

}
