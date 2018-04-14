package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.enums.TagGroupEnum;

import java.util.UUID;

/**
 * Групповые теги чата (для упрощения поиска последнего тега из группы)
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class ChatTagGroup {
    /**
     * ID чата
     */
    public UUID chatId;
    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public TagGroupEnum tagGroup;
    /**
     * id тега из сообщения
     */
    public UUID messageTagId;

//================================ AUTO GENERATE ==============================

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public TagGroupEnum getTagGroup() {
        return tagGroup;
    }

    public void setTagGroup(TagGroupEnum tagGroup) {
        this.tagGroup = tagGroup;
    }

    public UUID getMessageTagId() {
        return messageTagId;
    }

    public void setMessageTagId(UUID messageTagId) {
        this.messageTagId = messageTagId;
    }
}
