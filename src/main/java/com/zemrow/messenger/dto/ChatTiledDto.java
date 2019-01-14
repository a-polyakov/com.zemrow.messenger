package com.zemrow.messenger.dto;

import com.zemrow.messenger.entity.enums.ChatTypeEnum;

import java.util.List;

/**
 * Данные для плитки чата(контакта).
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatTiledDto {
    /**
     * ID чата
     */
    private Long chatId;
    /**
     * Тип чата: чат, задание
     */
    private ChatTypeEnum chatType;
    /**
     * Идентификатор контакта
     */
    private Long userContactId;
    /**
     * ID файла с аваторкой пользователя.
     */
    private Long avatarId;
    // TODO Статус пользователя
    // TODO Чат добавлен в избранное
    /**
     * Номер задания.
     */
    private String number;
    /**
     * Наименование чата(контакта/задания).
     */
    private String label;
    /**
     * Дата последнего сообщения
     */
    private Long lastMessageTime;
    /**
     * Текст последнего сообщения
     */
    private String lastMessageText;
    /**
     * Исполнитель
     */
    private Long executorUserId;
    /**
     * Плановая дата завершения
     */
    private Long deadline;
    /**
     * Сейчас работают.
     */
    private List<Long> workNowUserId;
    /**
     * Количество непрочитаных сообщений.
     */
    private Long unreadMessageCount;

//================================ AUTO GENERATE ==============================

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public ChatTypeEnum getChatType() {
        return chatType;
    }

    public void setChatType(ChatTypeEnum chatType) {
        this.chatType = chatType;
    }

    public Long getUserContactId() {
        return userContactId;
    }

    public void setUserContactId(Long userContactId) {
        this.userContactId = userContactId;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(Long lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

    public String getLastMessageText() {
        return lastMessageText;
    }

    public void setLastMessageText(String lastMessageText) {
        this.lastMessageText = lastMessageText;
    }

    public Long getExecutorUserId() {
        return executorUserId;
    }

    public void setExecutorUserId(Long executorUserId) {
        this.executorUserId = executorUserId;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public List<Long> getWorkNowUserId() {
        return workNowUserId;
    }

    public void setWorkNowUserId(List<Long> workNowUserId) {
        this.workNowUserId = workNowUserId;
    }

    public Long getUnreadMessageCount() {
        return unreadMessageCount;
    }

    public void setUnreadMessageCount(Long unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }
}
