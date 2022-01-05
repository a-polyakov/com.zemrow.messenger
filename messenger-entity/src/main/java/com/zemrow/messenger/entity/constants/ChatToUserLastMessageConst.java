package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.ChatToUserLastMessage;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы ChatToUserLastMessage(Последнее сообщение для пользователя в чате. Для упрощения поиска последнего сообщения. Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatToUserLastMessageConst extends com.querydsl.sql.RelationalPathBase<ChatToUserLastMessage> {

    private static final long serialVersionUID = -1930803860;

    /**
     * Последнее сообщение для пользователя в чате. Для упрощения поиска последнего сообщения. Данные являются избыточными, возможно восстановить.
     */
    public static final ChatToUserLastMessageConst ChatToUserLastMessage = new ChatToUserLastMessageConst("ChatToUserLastMessage");

    /**
     * Пользователь в чата. ID чата и ID пользователя
     */
    public static final String CHAT_TO_USER_ID = "chatToUserId";

    /**
     * ID сообщения
     */
    public static final String MESSAGE_ID = "messageId";

    /**
     * Пользователь в чата. ID чата и ID пользователя
     */
    public final NumberPath<Long> chatToUserId = createNumber(CHAT_TO_USER_ID, Long.class);

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber(MESSAGE_ID, Long.class);

    public final com.querydsl.sql.PrimaryKey<ChatToUserLastMessage> chattouserlastmessage_pkey = createPrimaryKey(chatToUserId);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Message> ChatToUserLastMessage_messageId_fk = createForeignKey(messageId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.ChatToUser> ChatToUserLastMessage_chatToUserId_fk = createForeignKey(chatToUserId, "id");

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
        addMetadata(chatToUserId, ColumnMetadata.named(CHAT_TO_USER_ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named(MESSAGE_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

