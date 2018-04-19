package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateAndDelete;
import com.zemrow.messenger.entity.enums.UserLinkEnum;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.lang.IgniteUuid;

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
    public IgniteUuid parentUserId;
    /**
     * ID пользователя потомка
     */
    @QuerySqlField(notNull = true, index = true)
    public IgniteUuid childUserId;
    /**
     * Тип связи
     */
    public UserLinkEnum userLinkType;

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

    public UserLinkEnum getUserLinkType() {
        return userLinkType;
    }

    public void setUserLinkType(UserLinkEnum userLinkType) {
        this.userLinkType = userLinkType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserLink{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
        sb.append(", userLinkType='").append(userLinkType).append('\'');
    }
}
