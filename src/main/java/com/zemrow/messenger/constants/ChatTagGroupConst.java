package com.zemrow.messenger.constants;

/**
 * Константы
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public interface ChatTagGroupConst extends AbstractEntityConst {
    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";
    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public static final String TAG_GROUP = "tagGroup";
    /**
     * id тега из сообщения
     */
    public static final String MESSAGE_TAG_ID = "messageTagId";
}
