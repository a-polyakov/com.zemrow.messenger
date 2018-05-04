package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;

/**
 * История сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageLog extends AbstractEntityCreateOnly {
    /**
     * ID сообщения
     */
    public Long messageId;
    /**
     * Предыдущий текст
     */
    private String oldText;

//================================ AUTO GENERATE ==============================

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getOldText() {
        return oldText;
    }

    public void setOldText(String oldText) {
        this.oldText = oldText;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageLog{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", oldText='").append(oldText).append('\'');
    }
}
