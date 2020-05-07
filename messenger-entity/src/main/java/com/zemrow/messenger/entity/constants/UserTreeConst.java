package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.UserTree;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы UserTree(Дерево пользователей) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class UserTreeConst extends com.querydsl.sql.RelationalPathBase<UserTree> {

    private static final long serialVersionUID = 1696307024;

    /**
     * Дерево пользователей
     */
    public static final UserTreeConst UserTree = new UserTreeConst("UserTree");

    /**
     * ID родительского пользователя
     */
    public final NumberPath<Long> parentUserId = createNumber("parentUserId", Long.class);

    /**
     * ID дочернего пользователя
     */
    public final NumberPath<Long> childUserId = createNumber("childUserId", Long.class);

    /**
     * Разность уровней
     */
    public final NumberPath<Integer> distance = createNumber("distance", Integer.class);

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
        addMetadata(parentUserId, ColumnMetadata.named("parentUserId").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childUserId, ColumnMetadata.named("childUserId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(distance, ColumnMetadata.named("distance").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

