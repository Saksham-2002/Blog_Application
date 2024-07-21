package com.practice.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.practice.blog.dto.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		ApiError apiError= new ApiError(message, false);
		return new ResponseEntity<>(apiError, HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
	{
		Map<String, String>response= new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			   String fieldName= ((FieldError) error).getField();
			   String message= error.getDefaultMessage();
			   response.put(fieldName, message);
		});
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
