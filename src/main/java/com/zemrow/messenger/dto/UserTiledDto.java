package com.zemrow.messenger.dto;

/**
 * Данные для плитки пользователя.
 *
 * @author Alexandr Polyakov on 2019.01.06
 */
public class UserTiledDto {
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
}
