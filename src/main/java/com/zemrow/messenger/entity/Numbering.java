package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

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
    public UUID userId;
    /**
     * Тип чата(документа)
     */
    public ChatTypeEnum chatType;
    /**
     * Префикс
     */
    public String prefix;
    /**
     * Последний выданный номер
     */
    public Long maxNumber;

//================================ AUTO GENERATE ==============================

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
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
}
