package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Отметка пользователя о затраченом времени
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatWork extends AbstractEntity {
    /**
     * ID чата
     */
    @QuerySqlField(notNull = true)
    public Long chatId;
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true)
    public Long userId;
    /**
     * Дата начала работы
     */
    @QuerySqlField(notNull = true)
    public Long startTime;
    /**
     * Дата окончания работы
     */
    @QuerySqlField
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
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
    }
}
