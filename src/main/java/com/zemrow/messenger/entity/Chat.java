package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;

import java.util.UUID;

/**
 * Чат
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Chat extends AbstractEntity {
    /**
     * Наименование чата
     */
    public String label;
    /**
     * Тип чата: чат, задание
     */
    public ChatTypeEnum chatType;
    /**
     * Использованый нумиратор (для определения префикса)
     */
    public UUID numberingId;
    /**
     * Номер чата(документа)
     */
    public Long orderNumber;

//================================ AUTO GENERATE ==============================

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ChatTypeEnum getChatType() {
        return chatType;
    }

    public void setChatType(ChatTypeEnum chatType) {
        this.chatType = chatType;
    }

    public UUID getNumberingId() {
        return numberingId;
    }

    public void setNumberingId(UUID numberingId) {
        this.numberingId = numberingId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
