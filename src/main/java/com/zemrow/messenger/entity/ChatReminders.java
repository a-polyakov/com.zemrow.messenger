package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

/**
 * Напоминание
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatReminders extends AbstractEntityCreateAndDelete {
    /**
     * ID чата
     */
    @QuerySqlField(notNull = true, index = true)
    public UUID chatId;
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true, index = true)
    public UUID userId;
    /**
     * Текст напоминания
     */
    public String text;
    /**
     * Дата напоминания
     */
    public Long dateTime;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }
}
