package com.zemrow.messenger.dto;

/**
 * Данные для плитки пользователя.
 *
 * @author Alexandr Polyakov on 2019.01.06
 */
public class UserTiledDto extends AbstractDto{
    /**
     * Идентификатор пользователя.
     */
    private Long userId;
    /**
     * Ссылка на File где хранится аватар.
     */
    private Long avatarId;
    /**
     * Наименование пользователя.
     */
    private String username;

    /**
     * При наличии контакта его идентификатор
     */
    private Long userContactId;

//================================ AUTO GENERATE ==============================


    public UserTiledDto() {
    }

    public UserTiledDto(Long userId, Long avatarId, String username, Long userContactId) {
        this.userId = userId;
        this.avatarId = avatarId;
        this.username = username;
        this.userContactId = userContactId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserContactId() {
        return userContactId;
    }

    public void setUserContactId(Long userContactId) {
        this.userContactId = userContactId;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("{class = \"com.zemrow.messenger.dto.UserTiledDto\"");
        if (userId != null) {
            result.append(", userId=\"").append(userId).append('"');
        }
        if (avatarId != null) {
            result.append(", avatarId=\"").append(avatarId).append('"');
        }
        if (username != null) {
            result.append(", username=\"").append(username).append('"');
        }
        if (userContactId != null) {
            result.append(", userContactId=\"").append(userContactId).append('"');
        }
        result.append('}');
        return result.toString();
    }
}
