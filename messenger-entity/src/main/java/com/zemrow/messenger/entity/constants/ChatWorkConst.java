package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.ChatWork;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы ChatWork(Отметка пользователя о затраченом времени) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatWorkConst extends com.querydsl.sql.RelationalPathBase<ChatWork> {

    private static final long serialVersionUID = -894696496;

    /**
     * Отметка пользователя о затраченом времени
     */
    public static final ChatWorkConst ChatWork = new ChatWorkConst("ChatWork");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * ID чата
     */
    public static final String CHAT_ID = "chatId";

    /**
     * ID пользователя
     */
    public static final String USER_ID = "userId";

    /**
     * Дата начала работы
     */
    public static final String START_TIME = "startTime";

    /**
     * Дата окончания работы
     */
    public static final String END_TIME = "endTime";

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
     * ID чата
     */
    public final NumberPath<Long> chatId = createNumber(CHAT_ID, Long.class);

    /**
     * ID пользователя
     */
    public final NumberPath<Long> userId = createNumber(USER_ID, Long.class);

    /**
     * Дата начала работы
     */
    public final NumberPath<Long> startTime = createNumber(START_TIME, Long.class);

    /**
     * Дата окончания работы
     */
    public final NumberPath<Long> endTime = createNumber(END_TIME, Long.class);

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

    public ChatWorkConst(String variable) {
        super(ChatWork.class, forVariable(variable), "public", "ChatWork");
        addMetadata();
    }

    public ChatWorkConst(com.querydsl.core.types.Path<? extends ChatWork> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatWork");
        addMetadata();
    }

    public ChatWorkConst(PathMetadata metadata) {
        super(ChatWork.class, metadata, "public", "ChatWork");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named(CHAT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(startTime, ColumnMetadata.named(START_TIME).withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(endTime, ColumnMetadata.named(END_TIME).withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19));
    }

}

