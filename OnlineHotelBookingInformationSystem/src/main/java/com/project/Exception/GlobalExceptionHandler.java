package com.project.Exception;


import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(OHISBusinessException.class)
	// Annotation for handling exceptions in specific handler classes and/or handler
	// methods.
	public ResponseEntity<ExceptionResponse> resourceNotFound(OHISBusinessException ex) {
	ExceptionResponse response = new ExceptionResponse();
	response.setErrorCode("641");
	response.setErrorMessage(ex.getMessage());
	response.setTimestamp(LocalDateTime.now());
	return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	
	}
}
