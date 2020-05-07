package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы ChatReminder(Напоминание) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class ChatReminder extends AbstractEntityWithId {

    /**
     * ID чата
     */
    private Long chatId;

    /**
     * ID пользователя
     */
    private Long userId;

    /**
     * Текст напоминания
     */
    private String text;

    /**
     * Дата напоминания
     */
    private Long reminderTime;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Напоминание
     */
    public ChatReminder() {
    }

    /**
     * Создать Напоминание
     * @param id ID записи
     * @param chatId ID чата
     * @param userId ID пользователя
     * @param text Текст напоминания
     * @param reminderTime Дата напоминания
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public ChatReminder(Long id, Long chatId, Long userId, String text, Long reminderTime, Long createTime, Long createdBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.chatId = chatId;
        this.userId = userId;
        this.text = text;
        this.reminderTime = reminderTime;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.deleteTime = deleteTime;
        this.deletedBy = deletedBy;
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

    @Override
    public void preDelete(SessionStorage session) {
        if (deleteTime == null) {
            deleteTime = System.currentTimeMillis();
        }
        if (deletedBy == null) {
            deletedBy = session.getUserId();
        }
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
     * Получение id пользователя
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Установить id пользователя
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Получение текст напоминания
     */
    public String getText() {
        return text;
    }

    /**
     * Установить текст напоминания
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Получение дата напоминания
     */
    public Long getReminderTime() {
        return reminderTime;
    }

    /**
     * Установить дата напоминания
     */
    public void setReminderTime(Long reminderTime) {
        this.reminderTime = reminderTime;
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

    /**
     * Получение дата удаления записи
     */
    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * Установить дата удаления записи
     */
    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * Получение пользователь удаливший запись
     */
    public Long getDeletedBy() {
        return deletedBy;
    }

    /**
     * Установить пользователь удаливший запись
     */
    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.ChatReminder\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (chatId != null) {
            result.append(", chatId = \"").append(chatId).append('"');
        }
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (text != null) {
            result.append(", text = \"").append(text).append('"');
        }
        if (reminderTime != null) {
            result.append(", reminderTime = \"").append(reminderTime).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        if (deleteTime != null) {
            result.append(", deleteTime = \"").append(deleteTime).append('"');
        }
        if (deletedBy != null) {
            result.append(", deletedBy = \"").append(deletedBy).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

