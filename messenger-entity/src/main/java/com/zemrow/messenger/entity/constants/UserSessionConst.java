package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserSession;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserSession(Сессия пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserSessionConst extends com.querydsl.sql.RelationalPathBase<UserSession> {

    private static final long serialVersionUID = -1148884572;

    /**
     * Сессия пользователя
     */
    public static final UserSessionConst UserSession = new UserSessionConst("UserSession");

    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    public final StringPath token = createString("token");

    /**
     * Точка входа пользователя
     */
    public final NumberPath<Long> userEntryPointId = createNumber("userEntryPointId", Long.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

    public UserSessionConst(String variable) {
        super(UserSession.class, forVariable(variable), "public", "UserSession");
        addMetadata();
    }

    public UserSessionConst(com.querydsl.core.types.Path<? extends UserSession> path) {
        super(path.getType(), path.getMetadata(), "public", "UserSession");
        addMetadata();
    }

    public UserSessionConst(PathMetadata metadata) {
        super(UserSession.class, metadata, "public", "UserSession");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(token, ColumnMetadata.named("token").withIndex(1).ofType(Types.CHAR).withSize(72).notNull());
        addMetadata(userEntryPointId, ColumnMetadata.named("userEntryPointId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(5).ofType(Types.BIGINT).withSize(19));
    }

}

