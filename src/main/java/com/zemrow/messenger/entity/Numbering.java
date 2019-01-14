package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Настройка нумирации для компании и типа чата
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Numbering extends AbstractEntity {
    /**
     * ID пользователя (компании, отдела)
     */
    @QuerySqlField(notNull = true, index = true)
    public Long userId;
    /**
     * Тип чата(документа)
     */
    @QuerySqlField
    public ChatTypeEnum chatType;
    /**
     * Префикс
     */
    @QuerySqlField
    public String prefix;
    /**
     * Последний выданный номер
     */
    @QuerySqlField(notNull = true)
    public Long maxNumber;

//================================ AUTO GENERATE ==============================

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ChatTypeEnum getChatType() {
        return chatType;
    }

    public void setChatType(ChatTypeEnum chatType) {
        this.chatType = chatType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Long maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", chatType='").append(chatType).append('\'');
        sb.append(", prefix='").append(prefix).append('\'');
        sb.append(", maxNumber=").append(maxNumber);
    }
}
