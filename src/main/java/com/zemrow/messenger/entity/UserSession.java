package com.zemrow.messenger.entity;

import com.zemrow.messenger.constants.UserSessionConst;
import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Сессия пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserSession extends AbstractEntityWithoutId<UserSessionKey> {
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    public String token;
    /**
     * Точка входа пользователя
     */
    @QuerySqlField(notNull = true)
    public Long userEntryPointId;
    /**
     * Дата создания записи
     */
    @QuerySqlField(notNull = true)
    private Long createTime;
    /**
     * Дата удаления записи
     */
    @QuerySqlField()
    private Long deleteTime;
    /**
     * Пользователь удаливший запись
     */
    @QuerySqlField()
    private Long deletedBy;


//================================ AUTO GENERATE ==============================

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserEntryPointId() {
        return userEntryPointId;
    }

    public void setUserEntryPointId(Long userEntryPointId) {
        this.userEntryPointId = userEntryPointId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    protected void toString(StringBuilder sb) {
        sb.append(UserSessionConst.TOKEN + "='").append(token).append('\'');
        sb.append(", userEntryPointId='").append(userEntryPointId).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deletedBy='").append(deletedBy).append('\'');
    }

    @Override
    public UserSessionKey getKey() {
        return new UserSessionKey(token);
    }
}
