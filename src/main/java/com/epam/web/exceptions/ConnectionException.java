package com.epam.web.exceptions;

import java.sql.SQLException;

public class ConnectionException extends SQLException {
    public ConnectionException() {
    }

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
