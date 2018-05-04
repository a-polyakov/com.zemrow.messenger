package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;

/**
 * Дерево пользователей
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserTree extends AbstractEntityWithoutId {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserTree{");
        sb.append("parentUserId='").append(parentUserId).append('\'');
        sb.append(", childUserId='").append(childUserId).append('\'');
        sb.append(", distance=").append(distance);
        sb.append('}');
        return sb.toString();
    }
}
