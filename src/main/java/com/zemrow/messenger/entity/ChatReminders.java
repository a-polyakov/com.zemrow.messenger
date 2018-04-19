package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

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
    public IgniteUuid chatId;
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true, index = true)
    public IgniteUuid userId;
    /**
     * Текст напоминания
     */
    public String text;
    /**
     * Дата напоминания
     */
    public Long dateTime;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getChatId() {
        return chatId;
    }

    public void setChatId(IgniteUuid chatId) {
        this.chatId = chatId;
    }

    public IgniteUuid getUserId() {
        return userId;
    }

    public void setUserId(IgniteUuid userId) {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatReminders{");
        toString(sb);
        sb.append('}');
        return sb.toString();
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
