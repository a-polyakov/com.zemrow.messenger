package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

/**
 * Контакты пользователя
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserContact extends AbstractEntity {
    /**
     * ID пользователя родителя
     */
    @QuerySqlField(notNull = true, index = true)
    public UUID parentUserId;
    /**
     * ID пользователя потомка
     */
    @QuerySqlField(notNull = true, index = true)
    public UUID childUserId;
    /**
     * Наименование контакта
     */
    public String label;
    /**
     * Избранный контакт
     */
    private boolean favorite;
    /**
     * ID чата
     */
    @QuerySqlField(notNull = true, index = true)
    public UUID chatId;

//================================ AUTO GENERATE ==============================

    public UUID getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(UUID parentUserId) {
        this.parentUserId = parentUserId;
    }

    public UUID getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(UUID childUserId) {
        this.childUserId = childUserId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }
}
