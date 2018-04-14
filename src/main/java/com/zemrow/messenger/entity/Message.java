package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;

import java.util.UUID;

/**
 * Сообщение
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Message extends AbstractEntity {
    /**
     * ID чата
     */
    public UUID chatId;
    /**
     * Текст
     */
    public String text;
    /**
     * ID прикрепленного файла
     */
    public UUID fileId;
    /**
     * ID созданого дочернего чата (при наличии в сообщении управляющего тега например задание)
     */
    public UUID childChatId;
    /**
     * Тип сообщения
     */
    public MessageTypeEnum messageType;

//================================ AUTO GENERATE ==============================

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getFileId() {
        return fileId;
    }

    public void setFileId(UUID fileId) {
        this.fileId = fileId;
    }

    public UUID getChildChatId() {
        return childChatId;
    }

    public void setChildChatId(UUID childChatId) {
        this.childChatId = childChatId;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }
}
