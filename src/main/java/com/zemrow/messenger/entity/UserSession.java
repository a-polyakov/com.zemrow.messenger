package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Сессия пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserSession extends AbstractEntityCreateAndDelete {
    /**
     * Точка входа пользователя
     */
    public IgniteUuid userEntryPointId;
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    public String token;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getUserEntryPointId() {
        return userEntryPointId;
    }

    public void setUserEntryPointId(IgniteUuid userEntryPointId) {
        this.userEntryPointId = userEntryPointId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSession{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("userEntryPointId='").append(userEntryPointId).append('\'');
        sb.append(", token='").append(token).append('\'');
    }
}
