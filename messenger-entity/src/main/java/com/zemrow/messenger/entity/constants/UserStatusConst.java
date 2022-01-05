package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserStatus;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserStatus(Справочник статусов пользователя) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class UserStatusConst extends com.querydsl.sql.RelationalPathBase<UserStatus> {

    private static final long serialVersionUID = -1963405532;

    /**
     * Справочник статусов пользователя
     */
    public static final UserStatusConst UserStatus = new UserStatusConst("UserStatus");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * Статус который указал пользователь
     */
    public static final String LABEL = "label";

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
     * Статус который указал пользователь
     */
    public final StringPath label = createString(LABEL);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    public final com.querydsl.sql.PrimaryKey<UserStatus> userstatus_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> UserStatus_createdBy_fk = createForeignKey(createdBy, "id");

    public UserStatusConst(String variable) {
        super(UserStatus.class, forVariable(variable), "public", "UserStatus");
        addMetadata();
    }

    public UserStatusConst(com.querydsl.core.types.Path<? extends UserStatus> path) {
        super(path.getType(), path.getMetadata(), "public", "UserStatus");
        addMetadata();
    }

    public UserStatusConst(PathMetadata metadata) {
        super(UserStatus.class, metadata, "public", "UserStatus");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(label, ColumnMetadata.named(LABEL).withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

