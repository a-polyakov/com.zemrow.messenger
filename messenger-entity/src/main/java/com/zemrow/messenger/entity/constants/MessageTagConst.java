package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.MessageTag;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы MessageTag(Тег сообщения) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class MessageTagConst extends com.querydsl.sql.RelationalPathBase<MessageTag> {

    private static final long serialVersionUID = -950804070;

    /**
     * Тег сообщения
     */
    public static final MessageTagConst MessageTag = new MessageTagConst("MessageTag");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber("messageId", Long.class);

    /**
     * ID тега
     */
    public final NumberPath<Long> tagId = createNumber("tagId", Long.class);

    /**
     * Скрытое значение тега (ID чата, дата в ms, ID пользователя в зависимости от типа тега)
     */
    public final StringPath value = createString("value");

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

    public MessageTagConst(String variable) {
        super(MessageTag.class, forVariable(variable), "public", "MessageTag");
        addMetadata();
    }

    public MessageTagConst(com.querydsl.core.types.Path<? extends MessageTag> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageTag");
        addMetadata();
    }

    public MessageTagConst(PathMetadata metadata) {
        super(MessageTag.class, metadata, "public", "MessageTag");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named("messageId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tagId, ColumnMetadata.named("tagId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(value, ColumnMetadata.named("value").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(9).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(10).ofType(Types.BIGINT).withSize(19));
    }

}

