package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Способы авторизации пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserEntryPoint extends AbstractEntity {
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true, index = true)
    public Long userId;
    /**
     * Прошел ли подтверждение
     */
    @QuerySqlField(notNull = true)
    public Boolean validate;
    /**
     * Способ(система) авторизации: логин_пароль, vk.com, google, ...
     */
    @QuerySqlField(notNull = true)
    public EntryPointTypeEnum entryPointType;
    /**
     * Идентификатор в системе авторизации (логин)
     */
    @QuerySqlField(notNull = true)
    public String clientId;
    /**
     * Удостоверение личности в системе авторизации (пароль)
     */
    @QuerySqlField
    public String credential;

//================================ AUTO GENERATE ==============================

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public EntryPointTypeEnum getEntryPointType() {
        return entryPointType;
    }

    public void setEntryPointType(EntryPointTypeEnum entryPointType) {
        this.entryPointType = entryPointType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", validate=").append(validate);
        sb.append(", entryPointType='").append(entryPointType).append('\'');
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", credential='").append(credential).append('\'');
    }
}
