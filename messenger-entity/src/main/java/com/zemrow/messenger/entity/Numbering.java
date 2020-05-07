package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы Numbering(Настройка нумирации для компании и типа чата) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class Numbering extends AbstractEntityWithId {

    /**
     * id пользователя(компания, отдел)
     */
    private Long userId;

    /**
     * Префикс
     */
    private String prefix;

    /**
     * Последний выданный номер
     */
    private Long maxNumber;

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
     * Создать Настройка нумирации для компании и типа чата
     */
    public Numbering() {
    }

    /**
     * Создать Настройка нумирации для компании и типа чата
     * @param id ID записи
     * @param userId id пользователя(компания, отдел)
     * @param prefix Префикс
     * @param maxNumber Последний выданный номер
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public Numbering(Long id, Long userId, String prefix, Long maxNumber, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.userId = userId;
        this.prefix = prefix;
        this.maxNumber = maxNumber;
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
     * Получение id пользователя(компания, отдел)
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Установить id пользователя(компания, отдел)
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Получение префикс
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Установить префикс
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Получение последний выданный номер
     */
    public Long getMaxNumber() {
        return maxNumber;
    }

    /**
     * Установить последний выданный номер
     */
    public void setMaxNumber(Long maxNumber) {
        this.maxNumber = maxNumber;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.Numbering\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (prefix != null) {
            result.append(", prefix = \"").append(prefix).append('"');
        }
        if (maxNumber != null) {
            result.append(", maxNumber = \"").append(maxNumber).append('"');
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

