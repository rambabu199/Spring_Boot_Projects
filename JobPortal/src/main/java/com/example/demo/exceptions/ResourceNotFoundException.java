package com.example.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg,String res,long id)
	{
		super(String.format("%s not found with %s: %s", res, msg, id));
	}

}
