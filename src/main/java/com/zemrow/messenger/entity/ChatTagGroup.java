package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.abstracts.AbstractEntity;
import com.zemrow.messenger.entity.enums.TagGroupEnum;

/**
 * Групповые теги чата (для упрощения поиска последнего тега из группы)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatTagGroup extends AbstractEntity {
    /**
     * ID чата
     */
    public Long chatId;
    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public TagGroupEnum tagGroup;
    /**
     * id тега из сообщения
     */
    public Long messageTagId;

//================================ AUTO GENERATE ==============================

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public TagGroupEnum getTagGroup() {
        return tagGroup;
    }

    public void setTagGroup(TagGroupEnum tagGroup) {
        this.tagGroup = tagGroup;
    }

    public Long getMessageTagId() {
        return messageTagId;
    }

    public void setMessageTagId(Long messageTagId) {
        this.messageTagId = messageTagId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatTagGroup{");
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append(", chatId='").append(chatId).append('\'');
        sb.append(", tagGroup='").append(tagGroup).append('\'');
        sb.append(", messageTagId='").append(messageTagId).append('\'');
    }
}
