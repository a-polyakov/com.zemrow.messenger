package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Сообщение
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Message extends AbstractEntity {
    /**
     * ID чата
     */
    public IgniteUuid chatId;
    /**
     * Текст
     */
    public String text;
    /**
     * ID прикрепленного файла
     */
    public IgniteUuid fileId;
    /**
     * ID созданого дочернего чата (при наличии в сообщении управляющего тега например задание)
     */
    public IgniteUuid childChatId;
    /**
     * Тип сообщения
     */
    public MessageTypeEnum messageType;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getChatId() {
        return chatId;
    }

    public void setChatId(IgniteUuid chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IgniteUuid getFileId() {
        return fileId;
    }

    public void setFileId(IgniteUuid fileId) {
        this.fileId = fileId;
    }

    public IgniteUuid getChildChatId() {
        return childChatId;
    }

    public void setChildChatId(IgniteUuid childChatId) {
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
