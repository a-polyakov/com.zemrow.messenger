package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы UserSession(Сессия пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class UserSession extends AbstractEntity {

    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    private String token;

    /**
     * Точка входа пользователя
     */
    private Long userEntryPointId;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Сессия пользователя
     */
    public UserSession() {
    }

    /**
     * Создать Сессия пользователя
     * @param token Уникальный идентификатор сессии, сложный для подбора
     * @param userEntryPointId Точка входа пользователя
     * @param createTime Дата создания записи
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public UserSession(String token, Long userEntryPointId, Long createTime, Long deleteTime, Long deletedBy) {
        this.token = token;
        this.userEntryPointId = userEntryPointId;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
        this.deletedBy = deletedBy;
    }

    @Override
    public void preInsert(SessionStorage session) {
        if (createTime == null) {
            createTime = System.currentTimeMillis();
        }
    }

    @Override
    public void preDelete(SessionStorage session) {
        if (deleteTime == null) {
            deleteTime = System.currentTimeMillis();
        }
        if (deletedBy == null) {
            deletedBy = session.getUserId();
        }
    }

    /**
     * Получение уникальный идентификатор сессии, сложный для подбора
     */
    public String getToken() {
        return token;
    }

    /**
     * Установить уникальный идентификатор сессии, сложный для подбора
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Получение точка входа пользователя
     */
    public Long getUserEntryPointId() {
        return userEntryPointId;
    }

    /**
     * Установить точка входа пользователя
     */
    public void setUserEntryPointId(Long userEntryPointId) {
        this.userEntryPointId = userEntryPointId;
    }

    /**
     * Получение дата создания записи
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * Установить дата создания записи
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * Получение дата удаления записи
     */
    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * Установить дата удаления записи
     */
    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * Получение пользователь удаливший запись
     */
    public Long getDeletedBy() {
        return deletedBy;
    }

    /**
     * Установить пользователь удаливший запись
     */
    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserSession\"");
        if (token != null) {
            result.append(", token = \"").append(token).append('"');
        }
        if (userEntryPointId != null) {
            result.append(", userEntryPointId = \"").append(userEntryPointId).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (deleteTime != null) {
            result.append(", deleteTime = \"").append(deleteTime).append('"');
        }
        if (deletedBy != null) {
            result.append(", deletedBy = \"").append(deletedBy).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

