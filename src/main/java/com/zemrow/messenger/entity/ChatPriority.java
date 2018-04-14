package com.zemrow.messenger.entity;

import java.util.UUID;

/**
 * Приоритет задания
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatPriority {
    /**
     * ID чата
     */
    public UUID chatId;
    /**
     * Приоритет
     */
    public Long priority;

//================================ AUTO GENERATE ==============================

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
