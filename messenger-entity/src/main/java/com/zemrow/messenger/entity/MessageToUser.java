package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.zemrow.messenger.SessionStorage;

/**
 * Класс сгенерирован автоматически, для таблицы MessageToUser(Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.05.07
 */
public class MessageToUser extends AbstractEntityWithId {

    /**
     * ID сообщения
     */
    private Long messageId;

    /**
     * ID пользователя
     */
    private Long userId;

    /**
     * Статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     */
    private MessageStatusEnum messageStatus;

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
     * Создать Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.
     */
    public MessageToUser() {
    }

    /**
     * Создать Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.
     * @param id ID записи
     * @param messageId ID сообщения
     * @param userId ID пользователя
     * @param messageStatus Статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public MessageToUser(Long id, Long messageId, Long userId, MessageStatusEnum messageStatus, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.messageId = messageId;
        this.userId = userId;
        this.messageStatus = messageStatus;
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
     * Получение статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     */
    public MessageStatusEnum getMessageStatus() {
        return messageStatus;
    }

    /**
     * Установить статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     */
    public void setMessageStatus(MessageStatusEnum messageStatus) {
        this.messageStatus = messageStatus;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.MessageToUser\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (messageId != null) {
            result.append(", messageId = \"").append(messageId).append('"');
        }
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (messageStatus != null) {
            result.append(", messageStatus = \"").append(messageStatus).append('"');
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

