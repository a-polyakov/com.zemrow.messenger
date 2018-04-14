package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;

import java.util.UUID;

/**
 * История сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageLog extends AbstractEntityCreateOnly {
    /**
     * ID сообщения
     */
    public UUID messageId;
    /**
     * Предыдущий текст
     */
    private String oldText;

//================================ AUTO GENERATE ==============================

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public String getOldText() {
        return oldText;
    }

    public void setOldText(String oldText) {
        this.oldText = oldText;
    }
}
