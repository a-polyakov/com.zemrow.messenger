package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;

/**
 * Класс сгенерирован автоматически, для таблицы Message(Сообщение) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class Message extends AbstractEntityWithId {

    /**
     * ID чата
     */
    private Long chatId;

    /**
     * Текст
     */
    private String text;

    /**
     * ID прикрепленного файла
     */
    private Long fileId;

    /**
     * ID созданного чата. Если сообщение содержало команду для создания дочернего чата (например задание).
     */
    private Long childChatId;

    /**
     * Тип сообщения (SIMPLE, ERROR)
     */
    private MessageTypeEnum messageType;

    /**
     * ID родительского сообщения
     */
    private Long parentMessageId;

    /**
     * Дата создания записи
     */
    private Long createTime;

    /**
     * Пользователь создавший запись
     */
    private Long createdBy;

    /**
     * Дата обновления записи
     */
    private Long updateTime;

    /**
     * Пользователь обновивший запись
     */
    private Long updatedBy;

    /**
     * Дата удаления записи
     */
    private Long deleteTime;

    /**
     * Пользователь удаливший запись
     */
    private Long deletedBy;

    /**
     * Создать Сообщение
     */
    public Message() {
    }

    /**
     * Создать Сообщение
     * @param id ID записи
     * @param chatId ID чата
     * @param text Текст
     * @param fileId ID прикрепленного файла
     * @param childChatId ID созданного чата. Если сообщение содержало команду для создания дочернего чата (например задание).
     * @param messageType Тип сообщения (SIMPLE, ERROR)
     * @param parentMessageId ID родительского сообщения
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public Message(Long id, Long chatId, String text, Long fileId, Long childChatId, MessageTypeEnum messageType, Long parentMessageId, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.chatId = chatId;
        this.text = text;
        this.fileId = fileId;
        this.childChatId = childChatId;
        this.messageType = messageType;
        this.parentMessageId = parentMessageId;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
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
        updateTime = System.currentTimeMillis();
        updatedBy = session.getUserId();
    }

    @Override
    public void preUpdate(SessionStorage session) {
        updateTime = System.currentTimeMillis();
        updatedBy = session.getUserId();
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
     * Получение текст
     */
    public String getText() {
        return text;
    }

    /**
     * Установить текст
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Получение id прикрепленного файла
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * Установить id прикрепленного файла
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * Получение id созданного чата. если сообщение содержало команду для создания дочернего чата (например задание).
     */
    public Long getChildChatId() {
        return childChatId;
    }

    /**
     * Установить id созданного чата. если сообщение содержало команду для создания дочернего чата (например задание).
     */
    public void setChildChatId(Long childChatId) {
        this.childChatId = childChatId;
    }

    /**
     * Получение тип сообщения (simple, error)
     */
    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    /**
     * Установить тип сообщения (simple, error)
     */
    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    /**
     * Получение id родительского сообщения
     */
    public Long getParentMessageId() {
        return parentMessageId;
    }

    /**
     * Установить id родительского сообщения
     */
    public void setParentMessageId(Long parentMessageId) {
        this.parentMessageId = parentMessageId;
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
     * Получение дата обновления записи
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * Установить дата обновления записи
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Получение пользователь обновивший запись
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Установить пользователь обновивший запись
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.Message\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (chatId != null) {
            result.append(", chatId = \"").append(chatId).append('"');
        }
        if (text != null) {
            result.append(", text = \"").append(text).append('"');
        }
        if (fileId != null) {
            result.append(", fileId = \"").append(fileId).append('"');
        }
        if (childChatId != null) {
            result.append(", childChatId = \"").append(childChatId).append('"');
        }
        if (messageType != null) {
            result.append(", messageType = \"").append(messageType).append('"');
        }
        if (parentMessageId != null) {
            result.append(", parentMessageId = \"").append(parentMessageId).append('"');
        }
        if (createTime != null) {
            result.append(", createTime = \"").append(createTime).append('"');
        }
        if (createdBy != null) {
            result.append(", createdBy = \"").append(createdBy).append('"');
        }
        if (updateTime != null) {
            result.append(", updateTime = \"").append(updateTime).append('"');
        }
        if (updatedBy != null) {
            result.append(", updatedBy = \"").append(updatedBy).append('"');
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

