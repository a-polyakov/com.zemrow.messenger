package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.ChatTagGroup;
import com.zemrow.messenger.entity.enums.TagGroupEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы ChatTagGroup(Групповые теги чата. Для упрощения поиска последнего тега из группы. Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatTagGroupConst extends com.querydsl.sql.RelationalPathBase<ChatTagGroup> {

    private static final long serialVersionUID = -1717584828;

    /**
     * Групповые теги чата. Для упрощения поиска последнего тега из группы. Данные являются избыточными, возможно восстановить.
     */
    public static final ChatTagGroupConst ChatTagGroup = new ChatTagGroupConst("ChatTagGroup");

    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";

    /**
     * Группа тегов. Если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public static final String TAG_GROUP = "tagGroup";

    /**
     * ID тега из сообщения
     */
    public static final String MESSAGE_TAG_ID = "messageTagId";

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber(CHAT_ID, Long.class);

    /**
     * Группа тегов. Если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public final EnumPath<TagGroupEnum> tagGroup = createEnum(TAG_GROUP, TagGroupEnum.class);

    /**
     * ID тега из сообщения
     */
    public final NumberPath<Long> messageTagId = createNumber(MESSAGE_TAG_ID, Long.class);

    public final com.querydsl.sql.PrimaryKey<ChatTagGroup> ChatTagGroup_pkey = createPrimaryKey(chatId, tagGroup);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Chat> ChatTagGroup_chatId_fk = createForeignKey(chatId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.MessageTag> ChatTagGroup_messageTagId_fk = createForeignKey(messageTagId, "id");

    public ChatTagGroupConst(String variable) {
        super(ChatTagGroup.class, forVariable(variable), "public", "ChatTagGroup");
        addMetadata();
    }

    public ChatTagGroupConst(com.querydsl.core.types.Path<? extends ChatTagGroup> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatTagGroup");
        addMetadata();
    }

    public ChatTagGroupConst(PathMetadata metadata) {
        super(ChatTagGroup.class, metadata, "public", "ChatTagGroup");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(chatId, ColumnMetadata.named(CHAT_ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tagGroup, ColumnMetadata.named(TAG_GROUP).withIndex(2).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(messageTagId, ColumnMetadata.named(MESSAGE_TAG_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

