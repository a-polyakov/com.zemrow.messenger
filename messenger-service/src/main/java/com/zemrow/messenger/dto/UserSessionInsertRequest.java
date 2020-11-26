package com.zemrow.messenger.dto;

import com.zemrow.messenger.сonstrain.NotNullConstraint;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.10.23
 */
public class UserSessionInsertRequest extends AbstractRequest {

    public static final NotNullConstraint USERNAME_NOTNULL = new NotNullConstraint(UserSessionInsertRequest.class, "username");
    public static final NotNullConstraint PASSWORD_NOTNULL = new NotNullConstraint(UserSessionInsertRequest.class, "password");

    /**
     * Наименование пользователя
     */
    private String username;
    /**
     * Пароль
     */
    private String password;

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

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.dto.UserSessionInsertRequest\"");
        if (username != null) {
            result.append(", username = \"").append(username).append('"');
        }
        if (password != null) {
            result.append(", password = \"").append(password).append('"');
        }
        result.append('}');
        return result.toString();
    }
}
