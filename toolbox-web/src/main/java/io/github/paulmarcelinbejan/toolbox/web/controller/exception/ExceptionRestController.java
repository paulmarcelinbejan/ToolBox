package io.github.paulmarcelinbejan.toolbox.web.controller.exception;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse;
import io.github.paulmarcelinbejan.toolbox.web.response.ExceptionResponse.ExceptionField;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;

public class ExceptionRestController {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { ValidationException.class })
	public ExceptionResponse handleValidationException(ValidationException exception) {
		return new ExceptionResponse(exception,
				Map.of(ExceptionField.STATUS, String.valueOf(HttpStatus.BAD_REQUEST.value()), 
					   ExceptionField.ERROR, HttpStatus.BAD_REQUEST.getReasonPhrase()));
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ExceptionResponse handleConstraintViolationException(ConstraintViolationException exception) {
		return new ExceptionResponse(exception,
				Map.of(ExceptionField.STATUS, String.valueOf(HttpStatus.BAD_REQUEST.value()), 
					   ExceptionField.ERROR, HttpStatus.BAD_REQUEST.getReasonPhrase(),
				   	   ExceptionField.MESSAGE, exception.toString()));
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ExceptionResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return new ExceptionResponse(exception,
				Map.of(ExceptionField.STATUS, String.valueOf(HttpStatus.BAD_REQUEST.value()), 
					   ExceptionField.ERROR, HttpStatus.BAD_REQUEST.getReasonPhrase(),
			   	   	   ExceptionField.MESSAGE, getValidExceptionMessage(exception)));
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoSuchElementException.class })
	public ExceptionResponse handleNoSuchElementException(NoSuchElementException exception) {
		return new ExceptionResponse(exception, 
				Map.of(ExceptionField.STATUS, String.valueOf(HttpStatus.NOT_FOUND.value()), 
					   ExceptionField.ERROR, HttpStatus.NOT_FOUND.getReasonPhrase()));
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { FunctionalException.class })
	public ExceptionResponse handleFunctionalException(FunctionalException exception) {
		return new ExceptionResponse(exception);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { TechnicalException.class })
	public ExceptionResponse handleTechnicalException(TechnicalException exception) {
		return new ExceptionResponse(exception);
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleAllUncaughtException(Exception exception) {
		return new ExceptionResponse(exception);
	}
	
	private String getValidExceptionMessage(MethodArgumentNotValidException exception) {
		return exception.getAllErrors()
				 .stream()
				 .map(e -> e.getDefaultMessage())
				 .toList()
				 .toString();
	}

}
