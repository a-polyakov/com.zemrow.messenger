package com.zemrow.messenger.exception;

/**
 * Отказано в доступе, у пользователя нет прав на выполнение запроса или доступа к ресурсу
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class AccessDeniedException extends MessengerException {
    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
