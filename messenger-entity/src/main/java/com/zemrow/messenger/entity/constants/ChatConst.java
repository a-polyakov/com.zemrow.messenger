package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.Chat;


import com.querydsl.core.types.dsl.*;

import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы Chat(Чат) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatConst extends com.querydsl.sql.RelationalPathBase<Chat> {

    private static final long serialVersionUID = -1119490017;

    /**
     * Чат
     */
    public static final ChatConst Chat = new ChatConst("Chat");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Наименование чата
     */
    public final StringPath label = createString("label");

    /**
     * Тип чата: чат, задание
     */
    public final EnumPath<ChatTypeEnum> chatType = createEnum("chatType", ChatTypeEnum.class);

    /**
     * Использованый нумиратор (для определения префикса)
     */
    public final NumberPath<Long> numberingId = createNumber("numberingId", Long.class);

    /**
     * Номер чата(документа)
     */
    public final NumberPath<Long> orderNumber = createNumber("orderNumber", Long.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    /**
     * Дата обновления записи
     */
    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    /**
     * Пользователь обновивший запись
     */
    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

    public ChatConst(String variable) {
        super(Chat.class, forVariable(variable), "public", "Chat");
        addMetadata();
    }

    public ChatConst(com.querydsl.core.types.Path<? extends Chat> path) {
        super(path.getType(), path.getMetadata(), "public", "Chat");
        addMetadata();
    }

    public ChatConst(PathMetadata metadata) {
        super(Chat.class, metadata, "public", "Chat");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(label, ColumnMetadata.named("label").withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(chatType, ColumnMetadata.named("chatType").withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(numberingId, ColumnMetadata.named("numberingId").withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(orderNumber, ColumnMetadata.named("orderNumber").withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

