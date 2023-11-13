package com.paulmarcelinbejan.toolbox.web.controller.exception;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.exception.utils.ExceptionUtils;
import com.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;

public abstract class ExceptionRestController {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { ValidationException.class })
	public String handleValidationException(ValidationException exception) {
		return exception.getMessage();
	}
	
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
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoSuchElementException.class })
	public ExceptionResponse handleNoSuchElementException(NoSuchElementException exception) {
		return new ExceptionResponse(exception, 
				Map.of("status", String.valueOf(HttpStatus.NOT_FOUND.value()), 
					   "error", HttpStatus.NOT_FOUND.getReasonPhrase(), 
					   "uniqueIdentifier", ExceptionUtils.getUniqueIdentifier()));
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { FunctionalException.class })
	public ExceptionResponse handleFunctionalException(FunctionalException exception) {
		return new ExceptionResponse(exception, Map.of("uniqueIdentifier", exception.getUniqueIdentifier()));
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
