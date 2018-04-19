package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;
import org.apache.ignite.lang.IgniteUuid;

/**
 * Дерево пользователей
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserTree extends AbstractEntityWithoutId {
    /**
     * ID родительского пользователя
     */
    public IgniteUuid parentUserId;
    /**
     * ID дочернего пользователя
     */
    public IgniteUuid childUserId;
    /**
     * Разность уровней
     */
    public Integer distance;

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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTree{");
        sb.append("parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
        sb.append(", distance=").append(distance);
        sb.append('}');
        return sb.toString();
    }
}
