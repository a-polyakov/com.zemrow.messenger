package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;

import java.util.UUID;

/**
 * Отметка пользователя о затраченом времени
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatWork extends AbstractEntity {
    /**
     * ID чата
     */
    public UUID chatId;
    /**
     * ID пользователя
     */
    public UUID userId;
    /**
     * Дата начала работы
     */
    public Long startTime;
    /**
     * Дата окончания работы
     */
    public Long endTime;

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
