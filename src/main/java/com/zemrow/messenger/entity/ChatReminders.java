package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

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
    @AffinityKeyMapped
    public Long chatId;
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true, index = true)
    //TODO org.apache.ignite.cache.query.annotations.QuerySqlField#groups (chatId, userId) для индекса
    public Long userId;
    /**
     * Текст напоминания
     */
    @QuerySqlField
    public String text;
    /**
     * Дата напоминания
     */
    @QuerySqlField(notNull = true)
    public Long dateTime;

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

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", dateTime=").append(dateTime);
    }
}
