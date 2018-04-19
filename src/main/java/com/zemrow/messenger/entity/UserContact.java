package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

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
    public IgniteUuid parentUserId;
    /**
     * ID пользователя потомка
     */
    @QuerySqlField(notNull = true, index = true)
    public IgniteUuid childUserId;
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
    public IgniteUuid chatId;

//================================ AUTO GENERATE ==============================

    public IgniteUuid getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(IgniteUuid parentUserId) {
        this.parentUserId = parentUserId;
    }

    public IgniteUuid getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(IgniteUuid childUserId) {
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

    public IgniteUuid getChatId() {
        return chatId;
    }

    public void setChatId(IgniteUuid chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserContact{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", favorite=").append(favorite);
        sb.append(", chatId='").append(chatId).append('\'');
    }
}
