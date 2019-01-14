package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Пользователи в чате
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatToUser extends AbstractEntity {
    /**
     * ID чата
     */
    @QuerySqlField(notNull = true, index = true)
    @AffinityKeyMapped
    public Long chatId;
    /**
     * ID пользователя
     */
    @QuerySqlField(notNull = true)
    public Long userId;
    /**
     * Избранный чат
     */
    @QuerySqlField(notNull = true)
    private boolean favorite;
    /**
     * Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
     */
    @QuerySqlField(notNull = true)
    public ChatToUserTypeEnum chatToUserType;

//================================ AUTO GENERATE ==============================

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public ChatToUserTypeEnum getChatToUserType() {
        return chatToUserType;
    }

    public void setChatToUserType(ChatToUserTypeEnum chatToUserType) {
        this.chatToUserType = chatToUserType;
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", favorite='").append(favorite).append('\'');
        sb.append(", chatToUserType='").append(chatToUserType).append('\'');
    }
}
