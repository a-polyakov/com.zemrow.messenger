package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatWork;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatWork(Отметка пользователя о затраченом времени) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatWorkConst extends com.querydsl.sql.RelationalPathBase<ChatWork> {

    private static final long serialVersionUID = -894696496;

    /**
     * Отметка пользователя о затраченом времени
     */
    public static final ChatWorkConst ChatWork = new ChatWorkConst("ChatWork");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber("chatId", Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    /**
     * Дата начала работы
     */
    public final NumberPath<Long> startTime = createNumber("startTime", Long.class);

    /**
     * Дата окончания работы
     */
    public final NumberPath<Long> endTime = createNumber("endTime", Long.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

    public ChatWorkConst(String variable) {
        super(ChatWork.class, forVariable(variable), "public", "ChatWork");
        addMetadata();
    }

    public ChatWorkConst(com.querydsl.core.types.Path<? extends ChatWork> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatWork");
        addMetadata();
    }

    public ChatWorkConst(PathMetadata metadata) {
        super(ChatWork.class, metadata, "public", "ChatWork");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(startTime, ColumnMetadata.named("startTime").withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(endTime, ColumnMetadata.named("endTime").withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(8).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(9).ofType(Types.BIGINT).withSize(19));
    }

}

