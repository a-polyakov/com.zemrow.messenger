package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatToUserLastMessage;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatToUserLastMessage(Последнее сообщение для пользователя в чате) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatToUserLastMessageConst extends com.querydsl.sql.RelationalPathBase<ChatToUserLastMessage> {

    private static final long serialVersionUID = -1930803860;

    /**
     * Последнее сообщение для пользователя в чате
     */
    public static final ChatToUserLastMessageConst ChatToUserLastMessage = new ChatToUserLastMessageConst("ChatToUserLastMessage");

    /**
     * Пользователи в чате (ID чата и ID пользователя)
     */
    public final NumberPath<Long> chatToUserId = createNumber("chatToUserId", Long.class);

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber("messageId", Long.class);

    public ChatToUserLastMessageConst(String variable) {
        super(ChatToUserLastMessage.class, forVariable(variable), "public", "ChatToUserLastMessage");
        addMetadata();
    }

    public ChatToUserLastMessageConst(com.querydsl.core.types.Path<? extends ChatToUserLastMessage> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatToUserLastMessage");
        addMetadata();
    }

    public ChatToUserLastMessageConst(PathMetadata metadata) {
        super(ChatToUserLastMessage.class, metadata, "public", "ChatToUserLastMessage");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(chatToUserId, ColumnMetadata.named("chatToUserId").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named("messageId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

