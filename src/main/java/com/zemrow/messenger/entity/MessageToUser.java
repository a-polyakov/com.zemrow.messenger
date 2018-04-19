package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageToUser extends AbstractEntity {
    /**
     * ID сообщения
     */
    public IgniteUuid messageId;
    /**
     * ID пользователя
     */
    public IgniteUuid userId;
    /**
     * Статус сообщения для конкретного пользователя (просмотрен/не просмотрен и т.д.)
     */
    public MessageStatusEnum messageStatus;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getMessageId() {
        return messageId;
    }

    public void setMessageId(IgniteUuid messageId) {
        this.messageId = messageId;
    }

    public IgniteUuid getUserId() {
        return userId;
    }

    public void setUserId(IgniteUuid userId) {
        this.userId = userId;
    }

    public MessageStatusEnum getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatusEnum messageStatus) {
        this.messageStatus = messageStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageToUser{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", messageStatus='").append(messageStatus).append('\'');
    }
}
