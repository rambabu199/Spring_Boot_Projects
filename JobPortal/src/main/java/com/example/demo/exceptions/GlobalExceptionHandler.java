package com.example.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails>handleResourceNotFoundException(ResourceNotFoundException res)
	{
		ErrorDetails errordetails=new ErrorDetails("resource not found", new Date(), res.getMessage());
		return new ResponseEntity<ErrorDetails>(errordetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleException(Exception res)
	{
		ErrorDetails errordetails=new ErrorDetails("internal server error", new Date(), res.getMessage());
		return new ResponseEntity<ErrorDetails>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
