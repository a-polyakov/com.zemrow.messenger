package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;

/**
 * Класс сгенерирован автоматически, для таблицы Chat(Чат) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class Chat extends AbstractEntityWithId {

    /**
     * Наименование чата
     */
    private String label;

    /**
     * Тип чата: чат, задание
     */
    private ChatTypeEnum chatType;

    /**
     * Использованный нумератор (для определения префикса)
     */
    private Long numberingId;

    /**
     * Номер чата(документа)
     */
    private Long orderNumber;

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
     * Создать Чат
     */
    public Chat() {
    }

    /**
     * Создать Чат
     * @param id ID записи
     * @param label Наименование чата
     * @param chatType Тип чата: чат, задание
     * @param numberingId Использованный нумератор (для определения префикса)
     * @param orderNumber Номер чата(документа)
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public Chat(Long id, String label, ChatTypeEnum chatType, Long numberingId, Long orderNumber, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.label = label;
        this.chatType = chatType;
        this.numberingId = numberingId;
        this.orderNumber = orderNumber;
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
     * Получение наименование чата
     */
    public String getLabel() {
        return label;
    }

    /**
     * Установить наименование чата
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Получение тип чата: чат, задание
     */
    public ChatTypeEnum getChatType() {
        return chatType;
    }

    /**
     * Установить тип чата: чат, задание
     */
    public void setChatType(ChatTypeEnum chatType) {
        this.chatType = chatType;
    }

    /**
     * Получение использованный нумератор (для определения префикса)
     */
    public Long getNumberingId() {
        return numberingId;
    }

    /**
     * Установить использованный нумератор (для определения префикса)
     */
    public void setNumberingId(Long numberingId) {
        this.numberingId = numberingId;
    }

    /**
     * Получение номер чата(документа)
     */
    public Long getOrderNumber() {
        return orderNumber;
    }

    /**
     * Установить номер чата(документа)
     */
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.Chat\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (label != null) {
            result.append(", label = \"").append(label).append('"');
        }
        if (chatType != null) {
            result.append(", chatType = \"").append(chatType).append('"');
        }
        if (numberingId != null) {
            result.append(", numberingId = \"").append(numberingId).append('"');
        }
        if (orderNumber != null) {
            result.append(", orderNumber = \"").append(orderNumber).append('"');
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

