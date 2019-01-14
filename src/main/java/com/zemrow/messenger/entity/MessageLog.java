package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithId;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * История сообщения
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageLog extends AbstractEntityWithId {
    /**
     * ID сообщения
     */
    @QuerySqlField(notNull = true)
    @AffinityKeyMapped
    public Long messageId;
    /**
     * Предыдущий текст
     */
    @QuerySqlField
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
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", oldText='").append(oldText).append('\'');
    }
}
