package com.zemrow.messenger.dto;

import com.zemrow.messenger.сonstrain.NotNullConstraint;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.10.23
 */
public class UserInsertRequest extends AbstractRequest {

    public static final NotNullConstraint USERNAME_NOTNULL = new NotNullConstraint(UserInsertRequest.class, "username");
    public static final NotNullConstraint PASSWORD_NOTNULL = new NotNullConstraint(UserInsertRequest.class, "password");
    public static final NotNullConstraint LOCALE_NOTNULL = new NotNullConstraint(UserInsertRequest.class, "locale");
    public static final NotNullConstraint TIME_ZONE_NOTNULL = new NotNullConstraint(UserInsertRequest.class, "timeZone");

    /**
     * Наименование пользователя
     */
    private String username;
    /**
     * Пароль
     */
    private String password;
    /**
     * Язык
     */
    private String locale;
    /**
     * Часовой пояс
     */
    private String timeZone;

//================================ AUTO GENERATE ==============================

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.dto.UserInsertRequest\"");
        if (username != null) {
            result.append(", username = \"").append(username).append('"');
        }
        if (password != null) {
            result.append(", password = \"").append(password).append('"');
        }
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
