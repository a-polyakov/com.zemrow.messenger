package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы UserStatus(Справочник статусов пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserStatus extends AbstractEntityWithId {

    /**
     * Статус который указал пользователь
     */
    private String label;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Создать Справочник статусов пользователя
     */
    public UserStatus() {
    }

    /**
     * Создать Справочник статусов пользователя
     * @param id ID записи
     * @param label Статус который указал пользователь
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     */
    public UserStatus(Long id, String label, Long createTime, Long createdBy) {
        this.id = id;
        this.label = label;
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
     * Получение статус который указал пользователь
     */
    public String getLabel() {
        return label;
    }

    /**
     * Установить статус который указал пользователь
     */
    public void setLabel(String label) {
        this.label = label;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserStatus\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (label != null) {
            result.append(", label = \"").append(label).append('"');
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

