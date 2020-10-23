package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserEntryPoint;
import com.zemrow.messenger.entity.enums.EntryPointTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserEntryPoint(Способы авторизации пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * ID пользователя
     */
    public static final String USER_ID = "userId";

    /**
     * Прошел ли подтверждение
     */
    public static final String VALIDATE = "validate";

    /**
     * Способ(система) авторизации: логин_пароль, vk.com, google, ...
     */
    public static final String ENTRY_POINT_TYPE = "entryPointType";

    /**
     * Идентификатор в системе авторизации (логин)
     */
    public static final String CLIENT_ID = "clientId";

    /**
     * Удостоверение личности в системе авторизации (пароль)
     */
    public static final String CREDENTIAL = "credential";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * Дата обновления записи
     */
    public static final String UPDATE_TIME = "updateTime";

    /**
     * Пользователь обновивший запись
     */
    public static final String UPDATED_BY = "updatedBy";

    /**
     * Дата удаления записи
     */
    public static final String DELETE_TIME = "deleteTime";

    /**
     * Пользователь удаливший запись
     */
    public static final String DELETED_BY = "deletedBy";

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber(ID, Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * Прошел ли подтверждение
     */
    public final BooleanPath validate = createBoolean(VALIDATE);

    /**
     * Способ(система) авторизации: логин_пароль, vk.com, google, ...
     */
    public final EnumPath<EntryPointTypeEnum> entryPointType = createEnum(ENTRY_POINT_TYPE, EntryPointTypeEnum.class);

    /**
     * Идентификатор в системе авторизации (логин)
     */
    public final StringPath clientId = createString(CLIENT_ID);

    /**
     * Удостоверение личности в системе авторизации (пароль)
     */
    public final StringPath credential = createString(CREDENTIAL);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    /**
     * Дата обновления записи
     */
    public final NumberPath<Long> updateTime = createNumber(UPDATE_TIME, Long.class);

    /**
     * Пользователь обновивший запись
     */
    public final NumberPath<Long> updatedBy = createNumber(UPDATED_BY, Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber(DELETE_TIME, Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber(DELETED_BY, Long.class);

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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(validate, ColumnMetadata.named(VALIDATE).withIndex(3).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(entryPointType, ColumnMetadata.named(ENTRY_POINT_TYPE).withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(clientId, ColumnMetadata.named(CLIENT_ID).withIndex(5).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(credential, ColumnMetadata.named(CREDENTIAL).withIndex(6).ofType(Types.VARCHAR).withSize(255));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

