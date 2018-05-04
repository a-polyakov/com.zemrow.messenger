package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;

/**
 * Пользователи в чате
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatToUser extends AbstractEntity {
    /**
     * ID чата
     */
    public Long chatId;
    /**
     * ID пользователя
     */
    public Long userId;
    /**
     * Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public ChatToUserTypeEnum chatToUserType;

//================================ AUTO GENERATE ==============================

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ChatToUserTypeEnum getChatToUserType() {
        return chatToUserType;
    }

    public void setChatToUserType(ChatToUserTypeEnum chatToUserType) {
        this.chatToUserType = chatToUserType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatToUser{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", chatToUserType='").append(chatToUserType).append('\'');
    }
}
