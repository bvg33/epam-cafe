package com.epam.web.exceptions;

import javax.servlet.ServletException;

public class NoRootsException extends ServletException {
    public NoRootsException() {
    }

    public NoRootsException(String message) {
        super(message);
    }

    public NoRootsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRootsException(Throwable cause) {
        super(cause);
    }
}
