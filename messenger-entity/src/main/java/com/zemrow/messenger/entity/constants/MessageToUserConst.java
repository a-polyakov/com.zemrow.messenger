package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.MessageToUser;


import com.querydsl.core.types.dsl.*;

import com.zemrow.messenger.entity.enums.MessageStatusEnum;
import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы MessageToUser(Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class MessageToUserConst extends com.querydsl.sql.RelationalPathBase<MessageToUser> {

    private static final long serialVersionUID = -82225434;

    /**
     * Связка сообщения с пользователем. При этом наличие такой связки обеспечивает показ сообщения конкретному пользователю в чате. В случае отсутствия связки, данное сообщение не отображается пользователю.
     */
    public static final MessageToUserConst MessageToUser = new MessageToUserConst("MessageToUser");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID сообщения
     */
    public final NumberPath<Long> messageId = createNumber("messageId", Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    /**
     * Статус сообщения для конкретного контакта (просмотрен/не просмотрен и т.д.)
     */
    public final EnumPath<MessageStatusEnum> messageStatus = createEnum("messageStatus", MessageStatusEnum.class);

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

    public MessageToUserConst(String variable) {
        super(MessageToUser.class, forVariable(variable), "public", "MessageToUser");
        addMetadata();
    }

    public MessageToUserConst(com.querydsl.core.types.Path<? extends MessageToUser> path) {
        super(path.getType(), path.getMetadata(), "public", "MessageToUser");
        addMetadata();
    }

    public MessageToUserConst(PathMetadata metadata) {
        super(MessageToUser.class, metadata, "public", "MessageToUser");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageId, ColumnMetadata.named("messageId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(messageStatus, ColumnMetadata.named("messageStatus").withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(9).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(10).ofType(Types.BIGINT).withSize(19));
    }

}

