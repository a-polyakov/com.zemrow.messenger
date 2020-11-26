package com.zemrow.messenger.dto;

/**
 * Регистрация пользователя
 *
 * @author Alexandr Polyakov on 2020.10.23
 */
public class UserInsertResponse extends AbstractDto {
    /**
     * ID пользователя
     */
    private Long userId;
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    private String token;

//================================ AUTO GENERATE ==============================


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.dto.UserInsertResponse\"");
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (token != null) {
            result.append(", token = \"").append(token).append('"');
        }
        result.append('}');
        return result.toString();
    }
}
