package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Последнее сообщение для пользователя в чате
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatToUserLastMessage extends AbstractEntity {
    /**
     * Пользователи в чате (ID чата и ID пользователя)
     */
    @QuerySqlField(notNull = true, index = true)
    public Long chatToUserId;
    /**
     * ID сообщения
     */
    @QuerySqlField(notNull = true)
    public Long messageId;

//================================ AUTO GENERATE ==============================


    public Long getChatToUserId() {
        return chatToUserId;
    }

    public void setChatToUserId(Long сhatToUserId) {
        this.chatToUserId = сhatToUserId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatToUserId='").append(chatToUserId).append('\'');
        sb.append(", messageId='").append(messageId).append('\'');
    }
}
