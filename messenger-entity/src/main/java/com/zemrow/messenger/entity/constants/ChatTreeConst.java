package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.ChatTree;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы ChatTree(Дерево задач. Данные являются избыточными, возможно восстановить.) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatTreeConst extends com.querydsl.sql.RelationalPathBase<ChatTree> {

    private static final long serialVersionUID = -894783395;

    /**
     * Дерево задач. Данные являются избыточными, возможно восстановить.
     */
    public static final ChatTreeConst ChatTree = new ChatTreeConst("ChatTree");

    /**
     * ID родительского чата
     */
    public static final String PARENT_CHAT_ID = "parentChatId";

    /**
     * ID дочернего чата
     */
    public static final String CHILD_CHAT_ID = "childChatId";

    /**
     * Разность уровней
     */
    public static final String DISTANCE = "distance";

    /**
     * ID родительского чата
     */
    public final NumberPath<Long> parentChatId = createNumber(PARENT_CHAT_ID, Long.class);

    /**
     * ID дочернего чата
     */
    public final NumberPath<Long> childChatId = createNumber(CHILD_CHAT_ID, Long.class);

    /**
     * Разность уровней
     */
    public final NumberPath<Integer> distance = createNumber(DISTANCE, Integer.class);

    public final com.querydsl.sql.PrimaryKey<ChatTree> ChatTree_pkey = createPrimaryKey(parentChatId, childChatId);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Chat> ChatTree_childChatId_fk = createForeignKey(childChatId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Chat> ChatTree_parentChatId_fk = createForeignKey(parentChatId, "id");

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
        addMetadata(parentChatId, ColumnMetadata.named(PARENT_CHAT_ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(childChatId, ColumnMetadata.named(CHILD_CHAT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(distance, ColumnMetadata.named(DISTANCE).withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

