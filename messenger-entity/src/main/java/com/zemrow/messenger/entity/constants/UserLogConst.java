package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserLog;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserLog(История изменения пользователь) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserLogConst extends com.querydsl.sql.RelationalPathBase<UserLog> {

    private static final long serialVersionUID = -1192214190;

    /**
     * История изменения пользователь
     */
    public static final UserLogConst UserLog = new UserLogConst("UserLog");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    /**
     * Поле
     */
    public final StringPath fieldName = createString("fieldName");

    /**
     * Старое значение
     */
    public final StringPath fieldOldValue = createString("fieldOldValue");

    /**
     * Новое значение
     */
    public final StringPath fieldNewValue = createString("fieldNewValue");

    /**
     * Комментарий - сообщение соответствующее изменению
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

    public UserLogConst(String variable) {
        super(UserLog.class, forVariable(variable), "public", "UserLog");
        addMetadata();
    }

    public UserLogConst(com.querydsl.core.types.Path<? extends UserLog> path) {
        super(path.getType(), path.getMetadata(), "public", "UserLog");
        addMetadata();
    }

    public UserLogConst(PathMetadata metadata) {
        super(UserLog.class, metadata, "public", "UserLog");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("userId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(fieldName, ColumnMetadata.named("fieldName").withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(fieldOldValue, ColumnMetadata.named("fieldOldValue").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fieldNewValue, ColumnMetadata.named("fieldNewValue").withIndex(5).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(comment, ColumnMetadata.named("comment").withIndex(6).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

