package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы UserLog(История изменения пользователь) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class UserLog extends AbstractEntityWithId {

    /**
     * ID пользователя
     */
    private Long userId;

    /**
     * Поле
     */
    private String fieldName;

    /**
     * Старое значение
     */
    private String fieldOldValue;

    /**
     * Новое значение
     */
    private String fieldNewValue;

    /**
     * Комментарий. Сообщение соответствующее изменению
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
     * Создать История изменения пользователь
     */
    public UserLog() {
    }

    /**
     * Создать История изменения пользователь
     * @param id ID записи
     * @param userId ID пользователя
     * @param fieldName Поле
     * @param fieldOldValue Старое значение
     * @param fieldNewValue Новое значение
     * @param comment Комментарий. Сообщение соответствующее изменению
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     */
    public UserLog(Long id, Long userId, String fieldName, String fieldOldValue, String fieldNewValue, String comment, Long createTime, Long createdBy) {
        this.id = id;
        this.userId = userId;
        this.fieldName = fieldName;
        this.fieldOldValue = fieldOldValue;
        this.fieldNewValue = fieldNewValue;
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
     * Получение id пользователя
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Установить id пользователя
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Получение поле
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Установить поле
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Получение старое значение
     */
    public String getFieldOldValue() {
        return fieldOldValue;
    }

    /**
     * Установить старое значение
     */
    public void setFieldOldValue(String fieldOldValue) {
        this.fieldOldValue = fieldOldValue;
    }

    /**
     * Получение новое значение
     */
    public String getFieldNewValue() {
        return fieldNewValue;
    }

    /**
     * Установить новое значение
     */
    public void setFieldNewValue(String fieldNewValue) {
        this.fieldNewValue = fieldNewValue;
    }

    /**
     * Получение комментарий. сообщение соответствующее изменению
     */
    public String getComment() {
        return comment;
    }

    /**
     * Установить комментарий. сообщение соответствующее изменению
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.UserLog\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (fieldName != null) {
            result.append(", fieldName = \"").append(fieldName).append('"');
        }
        if (fieldOldValue != null) {
            result.append(", fieldOldValue = \"").append(fieldOldValue).append('"');
        }
        if (fieldNewValue != null) {
            result.append(", fieldNewValue = \"").append(fieldNewValue).append('"');
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

