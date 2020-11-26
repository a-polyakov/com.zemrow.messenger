package com.zemrow.messenger.dto;

/**
 * Получить информацию о текущем пользователе.
 *
 * @author Alexandr Polyakov on 2020.12.10
 */
public class UserCurrentResponse extends AbstractScopeDto {
    /**
     * идентификатор пользователя.
     */
    private Long userId;
    /**
     * Наименование пользователя.
     */
    private String userName;

//================================ AUTO GENERATE ==============================

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
