package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;

import java.util.UUID;

/**
 * Тег сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageTag extends AbstractEntity {
    /**
     * ID сообщения
     */
    public UUID messageId;
    /**
     * ID тега
     */
    public UUID tagId;
    /**
     * Скрытое значение тега (ID чата, дата в ms, ID пользователя в зависимости от типа тега)
     */
    public String value;

//================================ AUTO GENERATE ==============================

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getTagId() {
        return tagId;
    }

    public void setTagId(UUID tagId) {
        this.tagId = tagId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
