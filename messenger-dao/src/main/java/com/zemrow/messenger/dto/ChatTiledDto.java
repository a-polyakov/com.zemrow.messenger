package com.zemrow.messenger.dto;

import com.zemrow.messenger.entity.enums.ChatTypeEnum;

import java.util.List;

/**
 * Данные для плитки чата(контакта).
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatTiledDto extends AbstractDto {
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
     * Наименование контакта
     */
    private String userContactLabel;
    /**
     * ID файла с аватаркой пользователя.
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
     * TODO
     */
    private List<Long> workNowUserId;
    /**
     * Количество непрочитанных сообщений.
     */
    private Long unreadMessageCount;

//================================ AUTO GENERATE ==============================


    public ChatTiledDto() {
    }

    public ChatTiledDto(Long chatId,
                        ChatTypeEnum chatType,
                        Long userContactId,
                        String userContactLabel,
                        Long avatarId,
                        String number,
                        String label,
                        Long lastMessageTime,
                        String lastMessageText,
                        Long executorUserId,
                        Long deadline,
                        Long unreadMessageCount) {
        this.chatId = chatId;
        this.chatType = chatType;
        this.userContactId = userContactId;
        this.userContactLabel = userContactLabel;
        this.avatarId = avatarId;
        this.number = number;
        this.label = label;
        this.lastMessageTime = lastMessageTime;
        this.lastMessageText = lastMessageText;
        this.executorUserId = executorUserId;
        this.deadline = deadline;
        this.unreadMessageCount = unreadMessageCount;
    }

    public ChatTiledDto(Long chatId,
                        String chatType,
                        Long userContactId,
                        String userContactLabel,
                        Long avatarId,
                        String number,
                        String label,
                        Long lastMessageTime,
                        String lastMessageText,
                        Long executorUserId,
                        Long deadline,
                        Long unreadMessageCount) {
        this.chatId = chatId;
        this.chatType = ChatTypeEnum.valueOf(chatType);
        this.userContactId = userContactId;
        this.userContactLabel = userContactLabel;
        this.avatarId = avatarId;
        this.number = number;
        this.label = label;
        this.lastMessageTime = lastMessageTime;
        this.lastMessageText = lastMessageText;
        this.executorUserId = executorUserId;
        this.deadline = deadline;
        this.unreadMessageCount = unreadMessageCount;
    }

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

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder().append("{class=\"com.zemrow.messenger.dto.ChatTiledDto\"");
        if (chatId != null) {
            result.append(", chatId=\"").append(chatId).append('"');
        }
        if (chatType != null) {
            result.append(", chatType=\"").append(chatType).append('"');
        }
        if (userContactId != null) {
            result.append(", userContactId=\"").append(userContactId).append('"');
        }
        if (avatarId != null) {
            result.append(", avatarId=\"").append(avatarId).append('"');
        }
        if (number != null) {
            result.append(", number=\"").append(number).append('"');
        }
        if (label != null) {
            result.append(", label=\"").append(label).append('"');
        }
        if (lastMessageTime != null) {
            result.append(", lastMessageTime=\"").append(lastMessageTime).append('"');
        }
        if (lastMessageText != null) {
            result.append(", lastMessageText=\"").append(lastMessageText).append('"');
        }
        if (executorUserId != null) {
            result.append(", executorUserId=\"").append(executorUserId).append('"');
        }
        if (deadline != null) {
            result.append(", deadline=\"").append(deadline).append('"');
        }
        if (workNowUserId != null) {
            result.append(", workNowUserId=\"").append(workNowUserId).append('"');
        }
        if (unreadMessageCount != null) {
            result.append(", unreadMessageCount=\"").append(unreadMessageCount).append('"');
        }
        result.append('}');
        return result.toString();
    }
}
