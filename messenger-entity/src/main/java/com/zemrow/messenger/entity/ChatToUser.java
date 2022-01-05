package com.zemrow.messenger.entity;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;

/**
 * Класс сгенерирован автоматически, для таблицы ChatToUser(Пользователи в чате) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class ChatToUser extends AbstractEntityWithId {

    /**
     * ID чата
     */
    private Long chatId;

    /**
     * ID пользователя
     */
    private Long userId;

    /**
     * Избранный чат
     */
    private Boolean favorite;

    /**
     * Тип участника. Например: обычный, скрытый только для чтения, скрытый полный доступ
     */
    private ChatToUserTypeEnum chatToUserType;

    /**
     * Отключить уведомления
     */
    private Boolean mute;

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
     * Создать Пользователи в чате
     */
    public ChatToUser() {
    }

    /**
     * Создать Пользователи в чате
     * @param id ID записи
     * @param chatId ID чата
     * @param userId ID пользователя
     * @param favorite Избранный чат
     * @param chatToUserType Тип участника. Например: обычный, скрытый только для чтения, скрытый полный доступ
     * @param mute Отключить уведомления
     * @param createTime Дата создания записи
     * @param createdBy Пользователь создавший запись
     * @param updateTime Дата обновления записи
     * @param updatedBy Пользователь обновивший запись
     * @param deleteTime Дата удаления записи
     * @param deletedBy Пользователь удаливший запись
     */
    public ChatToUser(Long id, Long chatId, Long userId, Boolean favorite, ChatToUserTypeEnum chatToUserType, Boolean mute, Long createTime, Long createdBy, Long updateTime, Long updatedBy, Long deleteTime, Long deletedBy) {
        this.id = id;
        this.chatId = chatId;
        this.userId = userId;
        this.favorite = favorite;
        this.chatToUserType = chatToUserType;
        this.mute = mute;
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
     * Получение избранный чат
     */
    public Boolean getFavorite() {
        return favorite;
    }

    /**
     * Установить избранный чат
     */
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * Получение тип участника. например: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public ChatToUserTypeEnum getChatToUserType() {
        return chatToUserType;
    }

    /**
     * Установить тип участника. например: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public void setChatToUserType(ChatToUserTypeEnum chatToUserType) {
        this.chatToUserType = chatToUserType;
    }

    /**
     * Получение отключить уведомления
     */
    public Boolean getMute() {
        return mute;
    }

    /**
     * Установить отключить уведомления
     */
    public void setMute(Boolean mute) {
        this.mute = mute;
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
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.ChatToUser\"");
        if (id != null) {
            result.append(", id = \"").append(id).append('"');
        }
        if (chatId != null) {
            result.append(", chatId = \"").append(chatId).append('"');
        }
        if (userId != null) {
            result.append(", userId = \"").append(userId).append('"');
        }
        if (favorite != null) {
            result.append(", favorite = \"").append(favorite).append('"');
        }
        if (chatToUserType != null) {
            result.append(", chatToUserType = \"").append(chatToUserType).append('"');
        }
        if (mute != null) {
            result.append(", mute = \"").append(mute).append('"');
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

