package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

/**
 * История изменения пользователь
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserLog extends AbstractEntityCreateOnly {
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true, index = true)
    public UUID userId;
    /**
     * Поле
     */
    public String fieldName;
    /**
     * Старое значение
     */
    public String fieldOldValue;
    /**
     * Новое значение
     */
    public String fieldNewValue;
    /**
     * Комментарий - сообщение соответствующее изменению
     */
    public String comment;

//================================ AUTO GENERATE ==============================

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldOldValue() {
        return fieldOldValue;
    }

    public void setFieldOldValue(String fieldOldValue) {
        this.fieldOldValue = fieldOldValue;
    }

    public String getFieldNewValue() {
        return fieldNewValue;
    }

    public void setFieldNewValue(String fieldNewValue) {
        this.fieldNewValue = fieldNewValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
