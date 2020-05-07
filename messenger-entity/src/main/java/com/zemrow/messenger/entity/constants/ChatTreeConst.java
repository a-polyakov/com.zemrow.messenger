package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatTree;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatTree(Дерево задач) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatTreeConst extends com.querydsl.sql.RelationalPathBase<ChatTree> {

    private static final long serialVersionUID = -894783395;

    /**
     * Дерево задач
     */
    public static final ChatTreeConst ChatTree = new ChatTreeConst("ChatTree");

    /**
     * ID родительского чата
     */
    public final NumberPath<Long> parentChatId = createNumber("parentChatId", Long.class);

    /**
     * ID дочернего чата
     */
    public final NumberPath<Long> childChatId = createNumber("childChatId", Long.class);

    /**
     * Разность уровней
     */
    public final NumberPath<Integer> distance = createNumber("distance", Integer.class);

    public ChatTreeConst(String variable) {
        super(ChatTree.class, forVariable(variable), "public", "ChatTree");
        addMetadata();
    }

    public ChatTreeConst(com.querydsl.core.types.Path<? extends ChatTree> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatTree");
        addMetadata();
    }

    public ChatTreeConst(PathMetadata metadata) {
        super(ChatTree.class, metadata, "public", "ChatTree");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(parentChatId, ColumnMetadata.named("parentChatId").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childChatId, ColumnMetadata.named("childChatId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(distance, ColumnMetadata.named("distance").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

