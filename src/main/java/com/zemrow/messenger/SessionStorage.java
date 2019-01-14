package com.zemrow.messenger;

import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.entity.enums.UserTypeEnum;

import java.util.Locale;
import java.util.TimeZone;

/**
 * Объект хранящий сессию пользователя в рамках обработки запроса
 * инициализируется после проверки token, и передается между слояви как параметр
 *
 * @author Alexandr Polyakov on 2018.04.14
 */
public class SessionStorage {
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    private String token;
    /**
     * ID пользователя
     */
    private final long userId;
    /**
     * Тип пользователя: физическое лицо, отдел, компания
     */
    private UserTypeEnum userType;
    /**
     * Локаль с которой работает пользователя
     */
    private Locale locale;
    /**
     * Временная зона пользователя
     */
    private TimeZone timeZone;

//================================ AUTO GENERATE ==============================


    public SessionStorage(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SessionStorage{");
        sb.append(UserSessionConst.TOKEN + "='").append(token).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", userType=").append(userType);
        sb.append(", locale=").append(locale);
        sb.append(", timeZone=").append(timeZone);
        sb.append('}');
        return sb.toString();
    }
}
