package com.zemrow.messenger.entity;

/**
 * Класс сгенерирован автоматически, для таблицы ChatPriority(Приоритет задания) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class ChatPriority extends AbstractEntity {

    /**
     * ID чата
     */
    private Long chatId;

    /**
     * Приоритет
     */
    private Long priority;

    /**
     * Создать Приоритет задания
     */
    public ChatPriority() {
    }

    /**
     * Создать Приоритет задания
     * @param chatId ID чата
     * @param priority Приоритет
     */
    public ChatPriority(Long chatId, Long priority) {
        this.chatId = chatId;
        this.priority = priority;
    }

    /**
     * Получение id чата
     */
    public Long getChatId() {
        return chatId;
    }

    /**
     * Установить id чата
     */
    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    /**
     * Получение приоритет
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * Установить приоритет
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.ChatPriority\"");
        if (chatId != null) {
            result.append(", chatId = \"").append(chatId).append('"');
        }
        if (priority != null) {
            result.append(", priority = \"").append(priority).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

