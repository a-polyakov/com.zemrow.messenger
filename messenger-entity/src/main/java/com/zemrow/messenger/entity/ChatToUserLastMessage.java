package com.zemrow.messenger.entity;

/**
 * Класс сгенерирован автоматически, для таблицы ChatToUserLastMessage(Последнее сообщение для пользователя в чате (для упрощения поиска последнего сообщения). Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class ChatToUserLastMessage extends AbstractEntity {

    /**
     * Пользователи в чате (ID чата и ID пользователя)
     */
    private Long chatToUserId;

    /**
     * ID сообщения
     */
    private Long messageId;

    /**
     * Создать Последнее сообщение для пользователя в чате (для упрощения поиска последнего сообщения). Данные являются избыточными, возможно восстановить.
     */
    public ChatToUserLastMessage() {
    }

    /**
     * Создать Последнее сообщение для пользователя в чате (для упрощения поиска последнего сообщения). Данные являются избыточными, возможно восстановить.
     * @param chatToUserId Пользователи в чате (ID чата и ID пользователя)
     * @param messageId ID сообщения
     */
    public ChatToUserLastMessage(Long chatToUserId, Long messageId) {
        this.chatToUserId = chatToUserId;
        this.messageId = messageId;
    }

    /**
     * Получение пользователи в чате (id чата и id пользователя)
     */
    public Long getChatToUserId() {
        return chatToUserId;
    }

    /**
     * Установить пользователи в чате (id чата и id пользователя)
     */
    public void setChatToUserId(Long chatToUserId) {
        this.chatToUserId = chatToUserId;
    }

    /**
     * Получение id сообщения
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * Установить id сообщения
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.ChatToUserLastMessage\"");
        if (chatToUserId != null) {
            result.append(", chatToUserId = \"").append(chatToUserId).append('"');
        }
        if (messageId != null) {
            result.append(", messageId = \"").append(messageId).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

