package com.zemrow.messenger.exception;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class NotAuthorizedException extends MessengerException {
    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
