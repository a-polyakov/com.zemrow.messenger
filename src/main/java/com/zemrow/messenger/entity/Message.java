package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Сообщение
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Message extends AbstractEntity {
    /**
     * ID чата
     */
    @QuerySqlField(notNull = true, index = true)
    public Long chatId;
    /**
     * Текст
     */
    @QuerySqlField
    public String text;
    /**
     * ID прикрепленного файла
     */
    @QuerySqlField
    public Long fileId;
    /**
     * ID созданого дочернего чата (при наличии в сообщении управляющего тега например задание)
     */
    @QuerySqlField
    public Long childChatId;
    /**
     * Тип сообщения
     */
    @QuerySqlField
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
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", fileId='").append(fileId).append('\'');
        sb.append(", childChatId='").append(childChatId).append('\'');
        sb.append(", messageType='").append(messageType).append('\'');
    }
}
