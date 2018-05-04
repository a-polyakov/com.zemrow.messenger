package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;

/**
 * Отметка пользователя о затраченом времени
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatWork extends AbstractEntity {
    /**
     * ID чата
     */
    public Long chatId;
    /**
     * ID пользователя
     */
    public Long userId;
    /**
     * Дата начала работы
     */
    public Long startTime;
    /**
     * Дата окончания работы
     */
    public Long endTime;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatWork{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
    }
}
