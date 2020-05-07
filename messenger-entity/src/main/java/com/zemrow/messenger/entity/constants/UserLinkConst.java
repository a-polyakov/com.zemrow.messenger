package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserLink;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.zemrow.messenger.entity.enums.UserLinkTypeEnum;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserLink(Организационная структура пользователей) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserLinkConst extends com.querydsl.sql.RelationalPathBase<UserLink> {

    private static final long serialVersionUID = 1696060332;

    /**
     * Организационная структура пользователей
     */
    public static final UserLinkConst UserLink = new UserLinkConst("UserLink");

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * ID пользователя родителя
     */
    public final NumberPath<Long> parentUserId = createNumber("parentUserId", Long.class);

    /**
     * ID пользователя потомка
     */
    public final NumberPath<Long> childUserId = createNumber("childUserId", Long.class);

    /**
     * Тип связи (подчинение, замена)
     */
    public final EnumPath<UserLinkTypeEnum> userLinkType = createEnum("userLinkType", UserLinkTypeEnum.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber("deleteTime", Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber("deletedBy", Long.class);

    public UserLinkConst(String variable) {
        super(UserLink.class, forVariable(variable), "public", "UserLink");
        addMetadata();
    }

    public UserLinkConst(com.querydsl.core.types.Path<? extends UserLink> path) {
        super(path.getType(), path.getMetadata(), "public", "UserLink");
        addMetadata();
    }

    public UserLinkConst(PathMetadata metadata) {
        super(UserLink.class, metadata, "public", "UserLink");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(parentUserId, ColumnMetadata.named("parentUserId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childUserId, ColumnMetadata.named("childUserId").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userLinkType, ColumnMetadata.named("userLinkType").withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(createTime, ColumnMetadata.named("createTime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named("createdBy").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named("deleteTime").withIndex(7).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named("deletedBy").withIndex(8).ofType(Types.BIGINT).withSize(19));
    }

}

