package com.example.demo;

public class FacadeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public FacadeException() {
		super();
	}
	
	public FacadeException(Throwable e) {
		super(e);
	}
	
	public FacadeException(String message) {
		super(message);
	}
	
	public FacadeException(String message, Throwable e) {
		super(message, e);
	}
}
