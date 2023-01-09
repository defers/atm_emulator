package com.defers.exceptions;

public class BillsException extends RuntimeException {

    public BillsException() {
        super();
    }
    public BillsException(String message) {
        super(message);
    }
}
