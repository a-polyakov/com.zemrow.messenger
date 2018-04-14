package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageStatusEnum;

import java.util.UUID;

/**
 * Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class MessageToUser extends AbstractEntity {
    /**
     * ID сообщения
     */
    public UUID messageId;
    /**
     * ID пользователя
     */
    public UUID userId;
    /**
     * Статус сообщения для конкретного пользователя (просмотрен/не просмотрен и т.д.)
     */
    public MessageStatusEnum messageStatus;

//================================ AUTO GENERATE ==============================

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public MessageStatusEnum getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatusEnum messageStatus) {
        this.messageStatus = messageStatus;
    }
}
