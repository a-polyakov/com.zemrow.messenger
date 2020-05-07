package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserSessionFail;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserSessionFail(Неудачные попытки войти в систему) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserSessionFailConst extends com.querydsl.sql.RelationalPathBase<UserSessionFail> {

    private static final long serialVersionUID = 1104233186;

    /**
     * Неудачные попытки войти в систему
     */
    public static final UserSessionFailConst UserSessionFail = new UserSessionFailConst("UserSessionFail");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Точка входа пользователя
     */
    public final NumberPath<Long> userEntryPointId = createNumber("userEntryPointId", Long.class);

    /**
     * IP адрес клиента
     */
    public final StringPath ipAddress = createString("ipAddress");

    /**
     * Сообщение об ошибке
     */
    public final StringPath comment = createString("comment");

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public UserSessionFailConst(String variable) {
        super(UserSessionFail.class, forVariable(variable), "public", "UserSessionFail");
        addMetadata();
    }

    public UserSessionFailConst(com.querydsl.core.types.Path<? extends UserSessionFail> path) {
        super(path.getType(), path.getMetadata(), "public", "UserSessionFail");
        addMetadata();
    }

    public UserSessionFailConst(PathMetadata metadata) {
        super(UserSessionFail.class, metadata, "public", "UserSessionFail");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userEntryPointId, ColumnMetadata.named("userEntryPointId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(ipAddress, ColumnMetadata.named("ipAddress").withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(comment, ColumnMetadata.named("comment").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

