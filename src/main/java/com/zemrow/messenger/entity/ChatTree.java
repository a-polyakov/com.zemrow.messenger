package com.zemrow.messenger.entity;

import java.util.UUID;

/**
 * Дерево задач
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatTree {
    /**
     * ID родительского чата
     */
    public UUID parentChatId;
    /**
     * id дочернего чата
     */
    public UUID childChatId;
    /**
     * Разность уровней
     */
    public Integer distance;

//================================ AUTO GENERATE ==============================

    public UUID getParentChatId() {
        return parentChatId;
    }

    public void setParentChatId(UUID parentChatId) {
        this.parentChatId = parentChatId;
    }

    public UUID getChildChatId() {
        return childChatId;
    }

    public void setChildChatId(UUID childChatId) {
        this.childChatId = childChatId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
