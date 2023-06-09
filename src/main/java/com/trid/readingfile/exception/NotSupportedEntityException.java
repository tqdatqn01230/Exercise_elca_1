package com.trid.readingfile.exception;

public class NotSupportedEntityException extends Exception{
    public NotSupportedEntityException() {
        super("Unsupported Entity.");
    }

    public NotSupportedEntityException(String message) {
        super(message);
    }

    public NotSupportedEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}