package com.zemrow.messenger.entity;

import com.zemrow.messenger.entity.enums.TagGroupEnum;

/**
 * Класс сгенерирован автоматически, для таблицы ChatTagGroup(Групповые теги чата (для упрощения поиска последнего тега из группы). Данные являются избыточными, возможно восстановить.) из БД
 *
 * @author com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer on 2020.10.23
 */
public class ChatTagGroup extends AbstractEntity {

    /**
     * ID чата
     */
    private Long chatId;

    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    private TagGroupEnum tagGroup;

    /**
     * ID тега из сообщения
     */
    private Long messageTagId;

    /**
     * Создать Групповые теги чата (для упрощения поиска последнего тега из группы). Данные являются избыточными, возможно восстановить.
     */
    public ChatTagGroup() {
    }

    /**
     * Создать Групповые теги чата (для упрощения поиска последнего тега из группы). Данные являются избыточными, возможно восстановить.
     * @param chatId ID чата
     * @param tagGroup Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     * @param messageTagId ID тега из сообщения
     */
    public ChatTagGroup(Long chatId, TagGroupEnum tagGroup, Long messageTagId) {
        this.chatId = chatId;
        this.tagGroup = tagGroup;
        this.messageTagId = messageTagId;
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
     * Получение группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public TagGroupEnum getTagGroup() {
        return tagGroup;
    }

    /**
     * Установить группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public void setTagGroup(TagGroupEnum tagGroup) {
        this.tagGroup = tagGroup;
    }

    /**
     * Получение id тега из сообщения
     */
    public Long getMessageTagId() {
        return messageTagId;
    }

    /**
     * Установить id тега из сообщения
     */
    public void setMessageTagId(Long messageTagId) {
        this.messageTagId = messageTagId;
    }

    @Override
    public String toString() {
        final StringBuilder result=new StringBuilder("{class = \"com.zemrow.messenger.entity.ChatTagGroup\"");
        if (chatId != null) {
            result.append(", chatId = \"").append(chatId).append('"');
        }
        if (tagGroup != null) {
            result.append(", tagGroup = \"").append(tagGroup).append('"');
        }
        if (messageTagId != null) {
            result.append(", messageTagId = \"").append(messageTagId).append('"');
        }
        result.append('}');
        return result.toString();
    }

}

