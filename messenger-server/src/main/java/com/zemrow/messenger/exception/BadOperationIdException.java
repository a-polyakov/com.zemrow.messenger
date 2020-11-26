package com.zemrow.messenger.exception;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.12.13
 */
public class BadOperationIdException extends BadRequestException {
    public BadOperationIdException(String message) {
        super(message);
    }

    public BadOperationIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
