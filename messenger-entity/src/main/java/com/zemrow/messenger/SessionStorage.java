package com.zemrow.messenger;

/**
 * Объект хранящий сессию пользователя в рамках обработки запроса инициализируется после проверки token, и передается
 * между слоями как параметр
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class SessionStorage implements Cloneable {
    /**
     * ID пользователя
     */
    private final long userId;

    public SessionStorage(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
