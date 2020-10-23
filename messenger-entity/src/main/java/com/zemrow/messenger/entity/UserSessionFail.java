package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы UserSessionFail(Неудачные попытки войти в систему) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserSessionFail extends AbstractEntityWithId {

    /**
     * Точка входа пользователя
     */
    private Long userEntryPointId;

    /**
     * IP адрес клиента
     */
    private String ipAddress;

    /**
     * Сообщение об ошибке
     */
    private String comment;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Создать Неудачные попытки войти в систему
     */
    public UserSessionFail() {
    }

    /**
     * Создать Неудачные попытки войти в систему
     * @param id ID записи
     * @param userEntryPointId Точка входа пользователя
     * @param ipAddress IP адрес клиента
     * @param comment Сообщение об ошибке
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     */
    public UserSessionFail(Long id, Long userEntryPointId, String ipAddress, String comment, Long createTime, Long createdBy) {
        this.id = id;
        this.userEntryPointId = userEntryPointId;
        this.ipAddress = ipAddress;
        this.comment = comment;
        this.createTime = createTime;
        this.createdBy = createdBy;
    }

    @Override
    public void preInsert(SessionStorage session) {
        if (createTime == null) {
            createTime = System.currentTimeMillis();
        }
        if (createdBy == null) {
            createdBy = session.getUserId();
        }
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
     * Получение ip адрес клиента
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Установить ip адрес клиента
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Получение сообщение об ошибке
     */
    public String getComment() {
        return comment;
    }

    /**
     * Установить сообщение об ошибке
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * Получение пользователь создавший запись
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Установить пользователь создавший запись
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserSessionFail\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (userEntryPointId != null) {
            result.append(", userEntryPointId = \"").append(userEntryPointId).append('"');
        }
        if (ipAddress != null) {
            result.append(", ipAddress = \"").append(ipAddress).append('"');
        }
        if (comment != null) {
            result.append(", comment = \"").append(comment).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

