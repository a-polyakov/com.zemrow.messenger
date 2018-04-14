package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import com.zemrow.messenger.entity.enums.UserLinkEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

/**
 * Организационная структура пользователей
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserLink extends AbstractEntityCreateAndDelete {
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
     * Тип связи
     */
    public UserLinkEnum userLinkType;

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

    public UserLinkEnum getUserLinkType() {
        return userLinkType;
    }

    public void setUserLinkType(UserLinkEnum userLinkType) {
        this.userLinkType = userLinkType;
    }
}
