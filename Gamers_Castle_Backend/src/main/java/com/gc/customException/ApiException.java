package com.gc.customException;

public class ApiException extends RuntimeException{
	
	public ApiException(String msg) {
		super(msg);
	}
}
