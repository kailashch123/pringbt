package com.kailash.exception;

public class MethodNotImplementedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MethodNotImplementedException() {
		super();
	}

	public MethodNotImplementedException(String message) {
		super(message);
	}

}
