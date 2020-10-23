package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserSession;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserSession(Сессия пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String TOKEN = "token";

    /**
     * Точка входа пользователя
     */
    public static final String USER_ENTRY_POINT_ID = "userEntryPointId";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Дата удаления записи
     */
    public static final String DELETE_TIME = "deleteTime";

    /**
     * Пользователь удаливший запись
     */
    public static final String DELETED_BY = "deletedBy";

    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    public final StringPath token = createString(TOKEN);

    /**
     * Точка входа пользователя
     */
    public final NumberPath<Long> userEntryPointId = createNumber(USER_ENTRY_POINT_ID, Long.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber(DELETE_TIME, Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber(DELETED_BY, Long.class);

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
        addMetadata(token, ColumnMetadata.named(TOKEN).withIndex(1).ofType(Types.CHAR).withSize(72).notNull());
        addMetadata(userEntryPointId, ColumnMetadata.named(USER_ENTRY_POINT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(5).ofType(Types.BIGINT).withSize(19));
    }

}

