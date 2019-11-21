package com.softtek.academy.ws.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 795794610065882563L;

	public NotFoundException(String message) {
        super(message);
    }

}
