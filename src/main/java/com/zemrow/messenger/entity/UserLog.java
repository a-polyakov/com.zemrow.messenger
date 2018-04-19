package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

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
    public IgniteUuid userId;
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

    public IgniteUuid getUserId() {
        return userId;
    }

    public void setUserId(IgniteUuid userId) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserLog{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", fieldName='").append(fieldName).append('\'');
        sb.append(", fieldOldValue='").append(fieldOldValue).append('\'');
        sb.append(", fieldNewValue='").append(fieldNewValue).append('\'');
        sb.append(", comment='").append(comment).append('\'');
    }
}
