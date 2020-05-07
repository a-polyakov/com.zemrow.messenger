package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.ChatPriority;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы ChatPriority(Приоритет задания) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
 */
public class ChatPriorityConst extends com.querydsl.sql.RelationalPathBase<ChatPriority> {

    private static final long serialVersionUID = -2097004829;

    /**
     * Приоритет задания
     */
    public static final ChatPriorityConst ChatPriority = new ChatPriorityConst("ChatPriority");

    /**
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber("chatId", Long.class);

    /**
     * Приоритет
     */
    public final NumberPath<Long> priority = createNumber("priority", Long.class);

    public ChatPriorityConst(String variable) {
        super(ChatPriority.class, forVariable(variable), "public", "ChatPriority");
        addMetadata();
    }

    public ChatPriorityConst(com.querydsl.core.types.Path<? extends ChatPriority> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatPriority");
        addMetadata();
    }

    public ChatPriorityConst(PathMetadata metadata) {
        super(ChatPriority.class, metadata, "public", "ChatPriority");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(chatId, ColumnMetadata.named("chatId").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(priority, ColumnMetadata.named("priority").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

