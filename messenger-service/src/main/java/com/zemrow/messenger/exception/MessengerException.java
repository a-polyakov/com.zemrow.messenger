package com.zemrow.messenger.exception;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class MessengerException extends RuntimeException {
    public MessengerException(String message) {
        super(message);
    }

    public MessengerException(String message, Throwable cause) {
        super(message, cause);
    }
}
