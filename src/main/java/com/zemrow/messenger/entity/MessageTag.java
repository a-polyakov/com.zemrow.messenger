package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Тег сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageTag extends AbstractEntity {
    /**
     * ID сообщения
     */
    @QuerySqlField(notNull = true)
    @AffinityKeyMapped
    public Long messageId;
    /**
     * ID тега
     */
    @QuerySqlField(notNull = true)
    public Long tagId;
    /**
     * Скрытое значение тега (ID чата, дата в ms, ID пользователя в зависимости от типа тега)
     */
    @QuerySqlField
    public String value;

//================================ AUTO GENERATE ==============================

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", tagId='").append(tagId).append('\'');
        sb.append(", value='").append(value).append('\'');
    }
}
