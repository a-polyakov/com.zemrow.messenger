package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.Message;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.zemrow.messenger.entity.enums.MessageTypeEnum;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы Message(Сообщение) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class MessageConst extends com.querydsl.sql.RelationalPathBase<Message> {

    private static final long serialVersionUID = -90138144;

    /**
     * Сообщение
     */
    public static final MessageConst Message = new MessageConst("Message");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber("chatId", Long.class);

    /**
     * Текст
     */
    public final StringPath text = createString("text");

    /**
     * ID прикрепленного файла
     */
    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    /**
     * ID созданого дочернего чата (при наличии в сообщении управляющего тега например задание)
     */
    public final NumberPath<Long> childChatId = createNumber("childChatId", Long.class);

    /**
     * Тип сообщения
     */
    public final EnumPath<MessageTypeEnum> messageType = createEnum("messageType", MessageTypeEnum.class);

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

    public MessageConst(String variable) {
        super(Message.class, forVariable(variable), "public", "Message");
        addMetadata();
    }

    public MessageConst(com.querydsl.core.types.Path<? extends Message> path) {
        super(path.getType(), path.getMetadata(), "public", "Message");
        addMetadata();
    }

    public MessageConst(PathMetadata metadata) {
        super(Message.class, metadata, "public", "Message");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(text, ColumnMetadata.named("text").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fileId, ColumnMetadata.named("fileId").withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(childChatId, ColumnMetadata.named("childChatId").withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(messageType, ColumnMetadata.named("messageType").withIndex(6).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

