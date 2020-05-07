package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatToUser;


import com.querydsl.core.types.dsl.*;

import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatToUser(Пользователи в чате) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatToUserConst extends com.querydsl.sql.RelationalPathBase<ChatToUser> {

    private static final long serialVersionUID = -896613915;

    /**
     * Пользователи в чате
     */
    public static final ChatToUserConst ChatToUser = new ChatToUserConst("ChatToUser");

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
     * Избранный чат
     */
    public final BooleanPath favorite = createBoolean("favorite");

    /**
     * Тип участника: обычный, скрытый только для чтения, скрытый полный доступ
     */
    public final EnumPath<ChatToUserTypeEnum> chatToUserType = createEnum("chatToUserType", ChatToUserTypeEnum.class);

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

    public ChatToUserConst(String variable) {
        super(ChatToUser.class, forVariable(variable), "public", "ChatToUser");
        addMetadata();
    }

    public ChatToUserConst(com.querydsl.core.types.Path<? extends ChatToUser> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatToUser");
        addMetadata();
    }

    public ChatToUserConst(PathMetadata metadata) {
        super(ChatToUser.class, metadata, "public", "ChatToUser");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(favorite, ColumnMetadata.named("favorite").withIndex(4).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(chatToUserType, ColumnMetadata.named("chatToUserType").withIndex(5).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(10).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(11).ofType(Types.BIGINT).withSize(19));
    }

}

