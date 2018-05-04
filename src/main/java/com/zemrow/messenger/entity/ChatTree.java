package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;

/**
 * Дерево задач
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatTree extends AbstractEntityWithoutId {
    /**
     * ID родительского чата
     */
    public Long parentChatId;
    /**
     * id дочернего чата
     */
    public Long childChatId;
    /**
     * Разность уровней
     */
    public Integer distance;

//================================ AUTO GENERATE ==============================

    public Long getParentChatId() {
        return parentChatId;
    }

    public void setParentChatId(Long parentChatId) {
        this.parentChatId = parentChatId;
    }

    public Long getChildChatId() {
        return childChatId;
    }

    public void setChildChatId(Long childChatId) {
        this.childChatId = childChatId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatTree{");
        sb.append("parentChatId='").append(parentChatId).append('\'');
        sb.append(", childChatId='").append(childChatId).append('\'');
        sb.append(", distance=").append(distance);
        sb.append('}');
        return sb.toString();
    }
}
