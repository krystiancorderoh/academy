package com.softtek.academy.sboot.exception;

public class IncompleteOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IncompleteOperationException(String message) {
        super(message);
    }

}
