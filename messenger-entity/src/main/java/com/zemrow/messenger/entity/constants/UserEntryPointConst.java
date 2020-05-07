package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserEntryPoint;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserEntryPoint(Способы авторизации пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserEntryPointConst extends com.querydsl.sql.RelationalPathBase<UserEntryPoint> {

    private static final long serialVersionUID = 827976304;

    /**
     * Способы авторизации пользователя
     */
    public static final UserEntryPointConst UserEntryPoint = new UserEntryPointConst("UserEntryPoint");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    /**
     * Прошел ли подтверждение
     */
    public final BooleanPath validate = createBoolean("validate");

    /**
     * Способ(система) авторизации: логин_пароль, vk.com, google, ...
     */
    public final EnumPath<EntryPointTypeEnum> entryPointType = createEnum("entryPointType", EntryPointTypeEnum.class);

    /**
     * Идентификатор в системе авторизации (логин)
     */
    public final StringPath clientId = createString("clientId");

    /**
     * Удостоверение личности в системе авторизации (пароль)
     */
    public final StringPath credential = createString("credential");

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

    public UserEntryPointConst(String variable) {
        super(UserEntryPoint.class, forVariable(variable), "public", "UserEntryPoint");
        addMetadata();
    }

    public UserEntryPointConst(com.querydsl.core.types.Path<? extends UserEntryPoint> path) {
        super(path.getType(), path.getMetadata(), "public", "UserEntryPoint");
        addMetadata();
    }

    public UserEntryPointConst(PathMetadata metadata) {
        super(UserEntryPoint.class, metadata, "public", "UserEntryPoint");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(validate, ColumnMetadata.named("validate").withIndex(3).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(entryPointType, ColumnMetadata.named("entryPointType").withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(clientId, ColumnMetadata.named("clientId").withIndex(5).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(credential, ColumnMetadata.named("credential").withIndex(6).ofType(Types.VARCHAR).withSize(255));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

