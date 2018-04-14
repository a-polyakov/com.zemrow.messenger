package com.zemrow.messenger.entity;

import java.util.UUID;

/**
 * Дерево пользователей
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class UserTree {
    /**
     * ID родительского пользователя
     */
    public UUID parentUserId;
    /**
     * ID дочернего пользователя
     */
    public UUID childUserId;
    /**
     * Разность уровней
     */
    public Integer distance;

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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
