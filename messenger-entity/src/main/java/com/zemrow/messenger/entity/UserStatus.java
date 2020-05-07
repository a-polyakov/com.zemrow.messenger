package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.enums.UserStatusTypeEnum;
import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы UserStatus(Справочник статусов пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class UserStatus extends AbstractEntityWithId {

    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    private String label;

    /**
     * Тип статуса для связки наименование статуса с логикой
     */
    private UserStatusTypeEnum userStatusType;

    /**
     * Вес статуса
     */
    private Integer weight;

    /**
     * Цвет статуса
     */
    private Integer color;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Дата обновления записи
     */
    private Long updateTime;

    /**
     * Пользователь обновивший запись
     */
    private Long updatedBy;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Справочник статусов пользователя
     */
    public UserStatus() {
    }

    /**
     * Создать Справочник статусов пользователя
     * @param id ID записи
     * @param label Состояние пользователя: Не в сети, В сети, Не беспокоить
     * @param userStatusType Тип статуса для связки наименование статуса с логикой
     * @param weight Вес статуса
     * @param color Цвет статуса
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public UserStatus(Long id, String label, UserStatusTypeEnum userStatusType, Integer weight, Integer color, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.label = label;
        this.userStatusType = userStatusType;
        this.weight = weight;
        this.color = color;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
        this.deleteTime = deleteTime;
        this.deletedBy = deletedBy;
    }

    @Override
    public void preInsert(SessionStorage session) {
        if (createTime == null) {
            createTime = System.currentTimeMillis();
        }
        if (createdBy == null) {
            createdBy = session.getUserId();
        }
        updateTime = System.currentTimeMillis();
        updatedBy = session.getUserId();
    }

    @Override
    public void preUpdate(SessionStorage session) {
        updateTime = System.currentTimeMillis();
        updatedBy = session.getUserId();
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
     * Получение состояние пользователя: не в сети, в сети, не беспокоить
     */
    public String getLabel() {
        return label;
    }

    /**
     * Установить состояние пользователя: не в сети, в сети, не беспокоить
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Получение тип статуса для связки наименование статуса с логикой
     */
    public UserStatusTypeEnum getUserStatusType() {
        return userStatusType;
    }

    /**
     * Установить тип статуса для связки наименование статуса с логикой
     */
    public void setUserStatusType(UserStatusTypeEnum userStatusType) {
        this.userStatusType = userStatusType;
    }

    /**
     * Получение вес статуса
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * Установить вес статуса
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * Получение цвет статуса
     */
    public Integer getColor() {
        return color;
    }

    /**
     * Установить цвет статуса
     */
    public void setColor(Integer color) {
        this.color = color;
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

    /**
     * Получение дата обновления записи
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * Установить дата обновления записи
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Получение пользователь обновивший запись
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Установить пользователь обновивший запись
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserStatus\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (label != null) {
            result.append(", label = \"").append(label).append('"');
        }
        if (userStatusType != null) {
            result.append(", userStatusType = \"").append(userStatusType).append('"');
        }
        if (weight != null) {
            result.append(", weight = \"").append(weight).append('"');
        }
        if (color != null) {
            result.append(", color = \"").append(color).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        if (updateTime != null) {
            result.append(", updateTime = \"").append(updateTime).append('"');
        }
        if (updatedBy != null) {
            result.append(", updatedBy = \"").append(updatedBy).append('"');
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

