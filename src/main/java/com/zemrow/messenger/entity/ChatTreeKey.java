package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Дерево задач, ключ
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatTreeKey extends AbstractKey {
    /**
     * ID родительского чата
     */
    @QuerySqlField(notNull = true)
    public Long parentChatId;
    /**
     * ID дочернего чата
     */
    @QuerySqlField(notNull = true)
    public Long childChatId;

//================================ AUTO GENERATE ==============================


    public ChatTreeKey() {
    }

    public ChatTreeKey(Long parentChatId, Long childChatId) {
        this.parentChatId = parentChatId;
        this.childChatId = childChatId;
    }

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

    @Override
    public void toString(StringBuilder sb) {
        sb.append("parentChatId='").append(parentChatId).append('\'');
        sb.append(", childChatId='").append(childChatId).append('\'');
    }
}
