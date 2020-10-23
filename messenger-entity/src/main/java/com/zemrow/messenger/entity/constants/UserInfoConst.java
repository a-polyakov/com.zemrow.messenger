package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserInfo;
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
     * Ссылка на таблицу file где хранится аватар
     */
    public static final String AVATAR_ID = "avatarId";

    /**
     * Наименование пользователя
     */
    public static final String NAME = "name";

    /**
     * Тип пользователя: физическое лицо, отдел, компания
     */
    public static final String USER_TYPE = "userType";

    /**
     * Json с дополнительными полями
     */
    public static final String PUBLIC_INFO = "publicInfo";

    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public static final String USER_STATUS_ID = "userStatusId";

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
     * Ссылка на таблицу file где хранится аватар
     */
    public final NumberPath<Long> avatarId = createNumber(AVATAR_ID, Long.class);

    /**
     * Наименование пользователя
     */
    public final StringPath name = createString(NAME);

    /**
     * Тип пользователя: физическое лицо, отдел, компания
     */
    public final EnumPath<UserTypeEnum> userType = createEnum(USER_TYPE, UserTypeEnum.class);

    /**
     * Json с дополнительными полями
     */
    public final StringPath publicInfo = createString(PUBLIC_INFO);

    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public final NumberPath<Long> userStatusId = createNumber(USER_STATUS_ID, Long.class);

    /**
     * Язык
     */
    public final StringPath locale = createString(LOCALE);

    /**
     * Часовой пояс
     */
    public final StringPath timeZone = createString(TIME_ZONE);

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
        addMetadata(avatarId, ColumnMetadata.named(AVATAR_ID).withIndex(2).ofType(Types.BIGINT).withSize(19));
        addMetadata(name, ColumnMetadata.named(NAME).withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(userType, ColumnMetadata.named(USER_TYPE).withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(publicInfo, ColumnMetadata.named(PUBLIC_INFO).withIndex(5).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(userStatusId, ColumnMetadata.named(USER_STATUS_ID).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(locale, ColumnMetadata.named(LOCALE).withIndex(7).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(timeZone, ColumnMetadata.named(TIME_ZONE).withIndex(8).ofType(Types.VARCHAR).withSize(6).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named(UPDATE_TIME).withIndex(11).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named(UPDATED_BY).withIndex(12).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(13).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(14).ofType(Types.BIGINT).withSize(19));
    }

}

