package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatTagGroup;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatTagGroup(Групповые теги чата (для упрощения поиска последнего тега из группы)) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatTagGroupConst extends com.querydsl.sql.RelationalPathBase<ChatTagGroup> {

    private static final long serialVersionUID = -1717584828;

    /**
     * Групповые теги чата (для упрощения поиска последнего тега из группы)
     */
    public static final ChatTagGroupConst ChatTagGroup = new ChatTagGroupConst("ChatTagGroup");

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber("chatId", Long.class);

    /**
     * Группа тегов, если в одном задании встречаются несколько тегов из одной группы, то считается что активен только один последний из группы
     */
    public final StringPath tagGroup = createString("tagGroup");

    /**
     * ID тега из сообщения
     */
    public final NumberPath<Long> messageTagId = createNumber("messageTagId", Long.class);

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
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tagGroup, ColumnMetadata.named("tagGroup").withIndex(2).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(messageTagId, ColumnMetadata.named("messageTagId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

