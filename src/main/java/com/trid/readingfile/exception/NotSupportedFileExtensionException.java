package com.trid.readingfile.exception;

import java.io.IOException;

public class NotSupportedFileExtensionException extends Exception {
    public NotSupportedFileExtensionException() {
        super("Unsupported file extension.");
    }

    public NotSupportedFileExtensionException(String message) {
        super(message);
    }

    public NotSupportedFileExtensionException(String message, Throwable cause) {
        super(message, cause);
    }
}