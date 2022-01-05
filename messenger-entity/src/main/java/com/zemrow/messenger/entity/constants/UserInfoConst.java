package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.SimplePath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserInfo;
import com.zemrow.messenger.entity.enums.UserStatusEnum;
import com.zemrow.messenger.entity.enums.UserTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserInfo(Пользователь) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class UserInfoConst extends com.querydsl.sql.RelationalPathBase<UserInfo> {

    private static final long serialVersionUID = 1695975520;

    /**
     * Пользователь
     */
    public static final UserInfoConst UserInfo = new UserInfoConst("UserInfo");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * Наименование пользователя
     */
    public static final String NAME = "name";

    /**
     * Тип пользователя. Например: физическое лицо, отдел, компания
     */
    public static final String USER_TYPE = "userType";

    /**
     * Ссылка на таблицу file где хранится аватар
     */
    public static final String AVATAR_ID = "avatarId";

    /**
     * Json с дополнительными полями
     */
    public static final String PUBLIC_INFO = "publicInfo";

    /**
     * Состояние пользователя. Не в сети, В сети
     */
    public static final String USER_STATUS = "userStatus";

    /**
     * Статус который указал пользователь
     */
    public static final String USER_STATUS_LABEL = "userStatusLabel";

    /**
     * Язык
     */
    public static final String LOCALE = "locale";

    /**
     * Часовой пояс
     */
    public static final String TIME_ZONE = "timeZone";

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
     * Наименование пользователя
     */
    public final StringPath name = createString(NAME);

    /**
     * Тип пользователя. Например: физическое лицо, отдел, компания
     */
    public final EnumPath<UserTypeEnum> userType = createEnum(USER_TYPE, UserTypeEnum.class);

    /**
     * Ссылка на таблицу file где хранится аватар
     */
    public final NumberPath<Long> avatarId = createNumber(AVATAR_ID, Long.class);

    /**
     * Json с дополнительными полями
     */
    public final StringPath publicInfo = createString(PUBLIC_INFO);

    /**
     * Состояние пользователя. Не в сети, В сети
     */
    public final EnumPath<UserStatusEnum> userStatus = createEnum(USER_STATUS, UserStatusEnum.class);

    /**
     * Статус который указал пользователь
     */
    public final StringPath userStatusLabel = createString(USER_STATUS_LABEL);

    /**
     * Язык
     */
    public final SimplePath<java.util.Locale> locale = createSimple(LOCALE, java.util.Locale.class);

    /**
     * Часовой пояс
     */
    public final SimplePath<java.time.ZoneId> timeZone = createSimple(TIME_ZONE, java.time.ZoneId.class);

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

    public final com.querydsl.sql.PrimaryKey<UserInfo> userinfo_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<UserInfo> UserInfo_updatedBy_fk = createForeignKey(updatedBy, "id");

    public final com.querydsl.sql.ForeignKey<UserInfo> UserInfo_deletedBy_fk = createForeignKey(deletedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.FileInfo> UserInfo_avatarId_fk = createForeignKey(avatarId, "id");

    public final com.querydsl.sql.ForeignKey<UserInfo> UserInfo_createdBy_fk = createForeignKey(createdBy, "id");

    public UserInfoConst(String variable) {
        super(UserInfo.class, forVariable(variable), "public", "UserInfo");
        addMetadata();
    }

    public UserInfoConst(com.querydsl.core.types.Path<? extends UserInfo> path) {
        super(path.getType(), path.getMetadata(), "public", "UserInfo");
        addMetadata();
    }

    public UserInfoConst(PathMetadata metadata) {
        super(UserInfo.class, metadata, "public", "UserInfo");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named(NAME).withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(userType, ColumnMetadata.named(USER_TYPE).withIndex(3).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(avatarId, ColumnMetadata.named(AVATAR_ID).withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(publicInfo, ColumnMetadata.named(PUBLIC_INFO).withIndex(5).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(userStatus, ColumnMetadata.named(USER_STATUS).withIndex(6).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(userStatusLabel, ColumnMetadata.named(USER_STATUS_LABEL).withIndex(7).ofType(Types.VARCHAR).withSize(255));
        addMetadata(locale, ColumnMetadata.named(LOCALE).withIndex(8).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(timeZone, ColumnMetadata.named(TIME_ZONE).withIndex(9).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(12).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(13).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(14).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(15).ofType(Types.BIGINT).withSize(19));
    }

}

