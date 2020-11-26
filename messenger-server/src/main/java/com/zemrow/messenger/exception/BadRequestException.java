package com.zemrow.messenger.exception;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.12.13
 */
public class BadRequestException extends MessengerException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
