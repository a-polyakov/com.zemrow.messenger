package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserInfo;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.zemrow.messenger.entity.enums.UserTypeEnum;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserInfo(Пользователь) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
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
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Ссылка на таблицу file где хранится аватар
     */
    public final NumberPath<Long> avatarId = createNumber("avatarId", Long.class);

    /**
     * Наименование пользователя
     */
    public final StringPath name = createString("name");

    /**
     * Тип пользователя: физическое лицо, отдел, компания
     */
    public final EnumPath<UserTypeEnum> userType = createEnum("userType", UserTypeEnum.class);

    /**
     * Json с дополнительными полями
     */
    public final StringPath info = createString("info");

    /**
     * Состояние пользователя: Не в сети, В сети, Не беспокоить
     */
    public final NumberPath<Long> userStatusId = createNumber("userStatusId", Long.class);

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
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(avatarId, ColumnMetadata.named("avatarId").withIndex(2).ofType(Types.BIGINT).withSize(19));
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(userType, ColumnMetadata.named("userType").withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(info, ColumnMetadata.named("info").withIndex(5).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(userStatusId, ColumnMetadata.named("userStatusId").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updateTime, ColumnMetadata.named("updateTime").withIndex(9).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(updatedBy, ColumnMetadata.named("updatedBy").withIndex(10).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(11).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(12).ofType(Types.BIGINT).withSize(19));
    }

}

