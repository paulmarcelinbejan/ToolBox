package com.paulmarcelinbejan.toolbox.web.controller.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;

import jakarta.validation.ConstraintViolationException;

public abstract class ExceptionRestController {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { ConstraintViolationException.class })
	public String handleConstraintViolationException(ConstraintViolationException exception) {
		return exception.getMessage();
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return exception.getMessage();
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { FunctionalException.class })
	public ExceptionResponse handleFunctionalException(FunctionalException exception) {
		return new ExceptionResponse(exception, 
				Map.of("status", String.valueOf(HttpStatus.BAD_REQUEST.value()), 
					   "error", HttpStatus.BAD_REQUEST.getReasonPhrase(), 
					   "uniqueIdentifier", exception.getUniqueIdentifier()));
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { TechnicalException.class })
	public ExceptionResponse handleTechnicalException(TechnicalException exception) {
		return new ExceptionResponse(exception, Map.of("uniqueIdentifier", exception.getUniqueIdentifier()));
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleAllUncaughtException(Exception exception) {
		return new ExceptionResponse(exception);
	}

}
