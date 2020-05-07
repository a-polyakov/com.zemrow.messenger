package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.MessageLog;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы MessageLog(История сообщения) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class MessageLogConst extends com.querydsl.sql.RelationalPathBase<MessageLog> {

    private static final long serialVersionUID = -950811324;

    /**
     * История сообщения
     */
    public static final MessageLogConst MessageLog = new MessageLogConst("MessageLog");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber("messageId", Long.class);

    /**
     * Предыдущий текст
     */
    public final StringPath oldText = createString("oldText");

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public MessageLogConst(String variable) {
        super(MessageLog.class, forVariable(variable), "public", "MessageLog");
        addMetadata();
    }

    public MessageLogConst(com.querydsl.core.types.Path<? extends MessageLog> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageLog");
        addMetadata();
    }

    public MessageLogConst(PathMetadata metadata) {
        super(MessageLog.class, metadata, "public", "MessageLog");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named("messageId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(oldText, ColumnMetadata.named("oldText").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

