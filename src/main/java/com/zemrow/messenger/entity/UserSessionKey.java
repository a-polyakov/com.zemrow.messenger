package com.zemrow.messenger.entity;

import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.entity.abstracts.AbstractKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Сессия пользователя, ключ
 *
 * @author Alexandr Polyakov on 2018.12.30
 */
public class UserSessionKey extends AbstractKey {
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    @QuerySqlField(notNull = true)
    public String token;

//================================ AUTO GENERATE ==============================


    public UserSessionKey() {
    }

    public UserSessionKey(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    protected void toString(StringBuilder sb) {
        sb.append(UserSessionConst.TOKEN + "='").append(token).append('\'');
    }
}
