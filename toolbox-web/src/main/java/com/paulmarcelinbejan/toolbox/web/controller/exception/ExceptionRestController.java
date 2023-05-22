package com.paulmarcelinbejan.toolbox.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.paulmarcelinbejan.toolbox.exception.technical.BadRequestException;
import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.dto.ExceptionResponse;

public abstract class ExceptionRestController {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { BadRequestException.class })
	public String handleBadRequestException(BadRequestException exception) {
		return exception.getMessage();
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { FunctionalException.class })
	public String handleFunctionalException(FunctionalException exception) {
		return exception.getMessage();
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { TechnicalException.class })
	public ExceptionResponse handleTechnicalException(TechnicalException exception, WebRequest request) {
		return new ExceptionResponse(exception, request.getContextPath());
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleAllUncaughtException(Exception exception, WebRequest request) {
		return new ExceptionResponse(exception, request.getContextPath());
	}

}
