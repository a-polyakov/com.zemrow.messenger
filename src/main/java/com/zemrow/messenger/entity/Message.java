package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;

/**
 * Сообщение
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Message extends AbstractEntity {
    /**
     * ID чата
     */
    public Long chatId;
    /**
     * Текст
     */
    public String text;
    /**
     * ID прикрепленного файла
     */
    public Long fileId;
    /**
     * ID созданого дочернего чата (при наличии в сообщении управляющего тега например задание)
     */
    public Long childChatId;
    /**
     * Тип сообщения
     */
    public MessageTypeEnum messageType;

//================================ AUTO GENERATE ==============================

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getChildChatId() {
        return childChatId;
    }

    public void setChildChatId(Long childChatId) {
        this.childChatId = childChatId;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", fileId='").append(fileId).append('\'');
        sb.append(", childChatId='").append(childChatId).append('\'');
        sb.append(", messageType='").append(messageType).append('\'');
    }
}
