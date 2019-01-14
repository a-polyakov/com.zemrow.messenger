package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageToUser extends AbstractEntity {
    /**
     * ID сообщения
     */
    @QuerySqlField(notNull = true)
    public Long messageId;
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true)
    @AffinityKeyMapped
    public Long userId;
    /**
     * Статус сообщения для конкретного пользователя (просмотрен/не просмотрен и т.д.)
     */
    @QuerySqlField(notNull = true)
    public MessageStatusEnum messageStatus;

//================================ AUTO GENERATE ==============================

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MessageStatusEnum getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatusEnum messageStatus) {
        this.messageStatus = messageStatus;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", messageStatus='").append(messageStatus).append('\'');
    }
}
