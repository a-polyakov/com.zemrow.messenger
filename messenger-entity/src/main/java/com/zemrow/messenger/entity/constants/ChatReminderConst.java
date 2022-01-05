package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.ChatReminder;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы ChatReminder(Напоминание) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class ChatReminderConst extends com.querydsl.sql.RelationalPathBase<ChatReminder> {

    private static final long serialVersionUID = -1450146383;

    /**
     * Напоминание
     */
    public static final ChatReminderConst ChatReminder = new ChatReminderConst("ChatReminder");

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
     * Текст напоминания
     */
    public static final String TEXT = "text";

    /**
     * Дата напоминания
     */
    public static final String REMINDER_TIME = "reminderTime";

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
     * Текст напоминания
     */
    public final StringPath text = createString(TEXT);

    /**
     * Дата напоминания
     */
    public final NumberPath<Long> reminderTime = createNumber(REMINDER_TIME, Long.class);

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

    public final com.querydsl.sql.PrimaryKey<ChatReminder> chatreminder_pkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> ChatReminder_userId_fk = createForeignKey(userId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> ChatReminder_deletedBy_fk = createForeignKey(deletedBy, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.Chat> ChatReminder_chatId_fk = createForeignKey(chatId, "id");

    public final com.querydsl.sql.ForeignKey<com.zemrow.messenger.entity.UserInfo> ChatReminder_createdBy_fk = createForeignKey(createdBy, "id");

    public ChatReminderConst(String variable) {
        super(ChatReminder.class, forVariable(variable), "public", "ChatReminder");
        addMetadata();
    }

    public ChatReminderConst(com.querydsl.core.types.Path<? extends ChatReminder> path) {
        super(path.getType(), path.getMetadata(), "public", "ChatReminder");
        addMetadata();
    }

    public ChatReminderConst(PathMetadata metadata) {
        super(ChatReminder.class, metadata, "public", "ChatReminder");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(chatId, ColumnMetadata.named(CHAT_ID).withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named(USER_ID).withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(text, ColumnMetadata.named(TEXT).withIndex(4).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(reminderTime, ColumnMetadata.named(REMINDER_TIME).withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createTime, ColumnMetadata.named(CREATE_TIME).withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(createdBy, ColumnMetadata.named(CREATED_BY).withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(deleteTime, ColumnMetadata.named(DELETE_TIME).withIndex(8).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletedBy, ColumnMetadata.named(DELETED_BY).withIndex(9).ofType(Types.BIGINT).withSize(19));
    }

}

