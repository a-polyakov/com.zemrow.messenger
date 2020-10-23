package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserLog;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserLog(История изменения пользователь) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * ID пользователя
     */
    public static final String USER_ID = "userId";

    /**
     * Поле
     */
    public static final String FIELD_NAME = "fieldName";

    /**
     * Старое значение
     */
    public static final String FIELD_OLD_VALUE = "fieldOldValue";

    /**
     * Новое значение
     */
    public static final String FIELD_NEW_VALUE = "fieldNewValue";

    /**
     * Комментарий - сообщение соответствующее изменению
     */
    public static final String COMMENT = "comment";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber(ID, Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * Поле
     */
    public final StringPath fieldName = createString(FIELD_NAME);

    /**
     * Старое значение
     */
    public final StringPath fieldOldValue = createString(FIELD_OLD_VALUE);

    /**
     * Новое значение
     */
    public final StringPath fieldNewValue = createString(FIELD_NEW_VALUE);

    /**
     * Комментарий - сообщение соответствующее изменению
     */
    public final StringPath comment = createString(COMMENT);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(fieldName, ColumnMetadata.named(FIELD_NAME).withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(fieldOldValue, ColumnMetadata.named(FIELD_OLD_VALUE).withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fieldNewValue, ColumnMetadata.named(FIELD_NEW_VALUE).withIndex(5).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(comment, ColumnMetadata.named(COMMENT).withIndex(6).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

