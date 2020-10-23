package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserLink;
import com.zemrow.messenger.entity.enums.UserLinkTypeEnum;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserLink(Организационная структура пользователей) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
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
    public static final String ID = "id";

    /**
     * ID пользователя родителя
     */
    public static final String PARENT_USER_ID = "parentUserId";

    /**
     * ID пользователя потомка
     */
    public static final String CHILD_USER_ID = "childUserId";

    /**
     * Тип связи (подчинение, замена)
     */
    public static final String USER_LINK_TYPE = "userLinkType";

    /**
     * Дата создания записи
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * Пользователь создавший запись
     */
    public static final String CREATED_BY = "createdBy";

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
     * ID пользователя родителя
     */
    public final NumberPath<Long> parentUserId = createNumber(PARENT_USER_ID, Long.class);

    /**
     * ID пользователя потомка
     */
    public final NumberPath<Long> childUserId = createNumber(CHILD_USER_ID, Long.class);

    /**
     * Тип связи (подчинение, замена)
     */
    public final EnumPath<UserLinkTypeEnum> userLinkType = createEnum(USER_LINK_TYPE, UserLinkTypeEnum.class);

    /**
     * Дата создания записи
     */
    public final NumberPath<Long> createTime = createNumber(CREATE_TIME, Long.class);

    /**
     * Пользователь создавший запись
     */
    public final NumberPath<Long> createdBy = createNumber(CREATED_BY, Long.class);

    /**
     * Дата удаления записи
     */
    public final NumberPath<Long> deleteTime = createNumber(DELETE_TIME, Long.class);

    /**
     * Пользователь удаливший запись
     */
    public final NumberPath<Long> deletedBy = createNumber(DELETED_BY, Long.class);

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
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(parentUserId, ColumnMetadata.named(PARENT_USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childUserId, ColumnMetadata.named(CHILD_USER_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userLinkType, ColumnMetadata.named(USER_LINK_TYPE).withIndex(4).ofType(Types.VARCHAR).withSize(16).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(7).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(8).ofType(Types.BIGINT).withSize(19));
    }

}

