package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.UserTree;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы UserTree(Дерево пользователей. Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class UserTreeConst extends com.querydsl.sql.RelationalPathBase<UserTree> {

    private static final long serialVersionUID = 1696307024;

    /**
     * Дерево пользователей. Данные являются избыточными, возможно восстановить.
     */
    public static final UserTreeConst UserTree = new UserTreeConst("UserTree");

    /**
     * ID родительского пользователя
     */
    public static final String PARENT_USER_ID = "parentUserId";

    /**
     * ID дочернего пользователя
     */
    public static final String CHILD_USER_ID = "childUserId";

    /**
     * Разность уровней
     */
    public static final String DISTANCE = "distance";

    /**
     * ID родительского пользователя
     */
    public final NumberPath<Long> parentUserId = createNumber(PARENT_USER_ID, Long.class);

    /**
     * ID дочернего пользователя
     */
    public final NumberPath<Long> childUserId = createNumber(CHILD_USER_ID, Long.class);

    /**
     * Разность уровней
     */
    public final NumberPath<Integer> distance = createNumber(DISTANCE, Integer.class);

    public final com.querydsl.sql.PrimaryKey<UserTree> UserTree_pkey = createPrimaryKey(parentUserId, childUserId);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> UserTree_childUserId_fk = createForeignKey(childUserId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> UserTree_parentUserId_fk = createForeignKey(parentUserId, "id");

    public UserTreeConst(String variable) {
        super(UserTree.class, forVariable(variable), "public", "UserTree");
        addMetadata();
    }

    public UserTreeConst(com.querydsl.core.types.Path<? extends UserTree> path) {
        super(path.getType(), path.getMetadata(), "public", "UserTree");
        addMetadata();
    }

    public UserTreeConst(PathMetadata metadata) {
        super(UserTree.class, metadata, "public", "UserTree");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(parentUserId, ColumnMetadata.named(PARENT_USER_ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childUserId, ColumnMetadata.named(CHILD_USER_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(distance, ColumnMetadata.named(DISTANCE).withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

