package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;

import java.util.UUID;

/**
 * Сессия пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserSession extends AbstractEntityCreateAndDelete {
    /**
     * Точка входа пользователя
     */
    public UUID userEntryPointId;
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    public String token;

//================================ AUTO GENERATE ==============================

    public UUID getUserEntryPointId() {
        return userEntryPointId;
    }

    public void setUserEntryPointId(UUID userEntryPointId) {
        this.userEntryPointId = userEntryPointId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
