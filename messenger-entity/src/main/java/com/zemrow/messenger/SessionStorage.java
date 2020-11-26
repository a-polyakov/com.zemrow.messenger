package com.zemrow.messenger;

import java.time.ZoneId;
import java.util.Locale;

/**
 * Объект хранящий сессию пользователя в рамках обработки запроса инициализируется после проверки token, и передается
 * между слоями как параметр
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class SessionStorage implements Cloneable {
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    private final String token;
    /**
     * ID пользователя
     */
    private final long userId;
    /**
     * Язык
     */
    private final Locale locale;
    /**
     * Часовой пояс
     */
    private final ZoneId timeZone;

//================================ AUTO GENERATE ==============================

    public SessionStorage(String token, long userId, Locale locale, ZoneId timeZone) {
        this.token = token;
        this.userId = userId;
        this.locale = locale;
        this.timeZone = timeZone;
    }

    public String getToken() {
        return token;
    }

    public long getUserId() {
        return userId;
    }

    public Locale getLocale() {
        return locale;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.SessionStorage\"");
        if (token != null) {
            result.append(", token = \"").append(token).append('"');
        }
        result.append(", userId = \"").append(userId).append('"');
        if (locale != null) {
            result.append(", locale = \"").append(locale).append('"');
        }
        if (timeZone != null) {
            result.append(", timeZone = \"").append(timeZone).append('"');
        }
        result.append('}');
        return result.toString();
    }
}
