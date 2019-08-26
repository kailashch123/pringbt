package com.kailash.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler
		extends
			ResponseEntityExceptionHandler {

	@SuppressWarnings({"rawtypes", "unchecked"})
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();
		errors.forEach(s -> sb.append(s));
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
				sb.toString(), "Validation failed.");

		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

	}

}
