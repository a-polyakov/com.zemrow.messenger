package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatReminder;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatReminder(Напоминание) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatReminderConst extends com.querydsl.sql.RelationalPathBase<ChatReminder> {

    private static final long serialVersionUID = -1450146383;

    /**
     * Напоминание
     */
    public static final ChatReminderConst ChatReminder = new ChatReminderConst("ChatReminder");

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
     * Текст напоминания
     */
    public final StringPath text = createString("text");

    /**
     * Дата напоминания
     */
    public final NumberPath<Long> reminderTime = createNumber("reminderTime", Long.class);

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

    public ChatReminderConst(String variable) {
        super(ChatReminder.class, forVariable(variable), "public", "ChatReminder");
        addMetadata();
    }

    public ChatReminderConst(com.querydsl.core.types.Path<? extends ChatReminder> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatReminder");
        addMetadata();
    }

    public ChatReminderConst(PathMetadata metadata) {
        super(ChatReminder.class, metadata, "public", "ChatReminder");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(text, ColumnMetadata.named("text").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(reminderTime, ColumnMetadata.named("reminderTime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(8).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(9).ofType(Types.BIGINT).withSize(19));
    }

}

