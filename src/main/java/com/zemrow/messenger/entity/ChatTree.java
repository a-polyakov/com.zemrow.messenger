package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityWithoutId;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Дерево задач
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatTree extends AbstractEntityWithoutId<ChatTreeKey> {
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
    @QuerySqlField(notNull = true)
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
    protected void toString(StringBuilder sb) {
        sb.append("parentChatId='").append(parentChatId).append('\'');
        sb.append(", childChatId='").append(childChatId).append('\'');
        sb.append(", distance=").append(distance);
    }

    @Override
    public ChatTreeKey getKey() {
        return new ChatTreeKey(parentChatId, childChatId);
    }
}
