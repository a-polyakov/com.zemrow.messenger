package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;

import java.util.UUID;

/**
 * Пользователи в чате
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatToUser extends AbstractEntity {
    /**
     * ID чата
     */
    public UUID chatId;
    /**
     * ID пользователя
     */
    public UUID userId;
    /**
     * Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public ChatToUserTypeEnum chatToUserTypeEnum;

//================================ AUTO GENERATE ==============================

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ChatToUserTypeEnum getChatToUserTypeEnum() {
        return chatToUserTypeEnum;
    }

    public void setChatToUserTypeEnum(ChatToUserTypeEnum chatToUserTypeEnum) {
        this.chatToUserTypeEnum = chatToUserTypeEnum;
    }
}
