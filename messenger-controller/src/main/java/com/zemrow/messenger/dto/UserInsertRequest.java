package com.zemrow.messenger.dto;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.10.23
 */
public class UserInsertRequest extends AbstractDto{
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
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.dto.UserInsertRequest\"");
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
