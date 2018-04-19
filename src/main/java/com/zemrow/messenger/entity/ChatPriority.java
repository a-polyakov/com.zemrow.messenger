package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntityCreateOnly;

/**
 * Приоритет задания<br>
 * в качестве id используется идентификатор чата
 *
 * TODO нужен ли этот объект (кеш хранит chatId, priority)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatPriority extends AbstractEntityCreateOnly {
    /**
     * Приоритет
     */
    public Long priority;

//================================ AUTO GENERATE ==============================

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatPriority{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        sb.append(", priority=").append(priority);
    }
}
