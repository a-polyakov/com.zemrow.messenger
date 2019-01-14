package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Дерево пользователей
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserTree extends AbstractEntityWithoutId<UserTreeKey> {
    /**
     * ID родительского пользователя
     */
    public Long parentUserId;
    /**
     * ID дочернего пользователя
     */
    public Long childUserId;
    /**
     * Разность уровней
     */
    @QuerySqlField(notNull = true)
    public Integer distance;

//================================ AUTO GENERATE ==============================

    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Long getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(Long childUserId) {
        this.childUserId = childUserId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public void toString(StringBuilder sb) {
        sb.append("parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
        sb.append(", distance=").append(distance);
    }

    @Override
    public UserTreeKey getKey() {
        return new UserTreeKey(parentUserId, childUserId);
    }
}
