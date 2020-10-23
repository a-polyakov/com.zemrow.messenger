package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserSessionFail;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserSessionFail(Неудачные попытки войти в систему) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * Точка входа пользователя
     */
    public static final String USER_ENTRY_POINT_ID = "userEntryPointId";

    /**
     * IP адрес клиента
     */
    public static final String IP_ADDRESS = "ipAddress";

    /**
     * Сообщение об ошибке
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
     * Точка входа пользователя
     */
    public final NumberPath<Long> userEntryPointId = createNumber(USER_ENTRY_POINT_ID, Long.class);

    /**
     * IP адрес клиента
     */
    public final StringPath ipAddress = createString(IP_ADDRESS);

    /**
     * Сообщение об ошибке
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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userEntryPointId, ColumnMetadata.named(USER_ENTRY_POINT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(ipAddress, ColumnMetadata.named(IP_ADDRESS).withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(comment, ColumnMetadata.named(COMMENT).withIndex(4).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

