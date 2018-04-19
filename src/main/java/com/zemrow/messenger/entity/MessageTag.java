package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Тег сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageTag extends AbstractEntity {
    /**
     * ID сообщения
     */
    public IgniteUuid messageId;
    /**
     * ID тега
     */
    public IgniteUuid tagId;
    /**
     * Скрытое значение тега (ID чата, дата в ms, ID пользователя в зависимости от типа тега)
     */
    public String value;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getMessageId() {
        return messageId;
    }

    public void setMessageId(IgniteUuid messageId) {
        this.messageId = messageId;
    }

    public IgniteUuid getTagId() {
        return tagId;
    }

    public void setTagId(IgniteUuid tagId) {
        this.tagId = tagId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageTag{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", tagId='").append(tagId).append('\'');
        sb.append(", value='").append(value).append('\'');
    }
}
