package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы MessageLog(История сообщения) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class MessageLog extends AbstractEntityWithId {

    /**
     * ID сообщения
     */
    private Long messageId;

    /**
     * Предыдущий текст
     */
    private String oldText;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Создать История сообщения
     */
    public MessageLog() {
    }

    /**
     * Создать История сообщения
     * @param id ID записи
     * @param messageId ID сообщения
     * @param oldText Предыдущий текст
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     */
    public MessageLog(Long id, Long messageId, String oldText, Long createTime, Long createdBy) {
        this.id = id;
        this.messageId = messageId;
        this.oldText = oldText;
        this.createTime = createTime;
        this.createdBy = createdBy;
    }

    @Override
    public void preInsert(SessionStorage session) {
        if (createTime == null) {
            createTime = System.currentTimeMillis();
        }
        if (createdBy == null) {
            createdBy = session.getUserId();
        }
    }

    /**
     * Получение id сообщения
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * Установить id сообщения
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * Получение предыдущий текст
     */
    public String getOldText() {
        return oldText;
    }

    /**
     * Установить предыдущий текст
     */
    public void setOldText(String oldText) {
        this.oldText = oldText;
    }

    /**
     * Получение дата создания записи
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * Установить дата создания записи
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * Получение пользователь создавший запись
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Установить пользователь создавший запись
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.MessageLog\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (messageId != null) {
            result.append(", messageId = \"").append(messageId).append('"');
        }
        if (oldText != null) {
            result.append(", oldText = \"").append(oldText).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

