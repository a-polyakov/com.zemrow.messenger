package com.zemrow.messenger.entity.constants;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.ColumnMetadata;
import com.zemrow.messenger.entity.RequestLog;

import java.sql.Types;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;




/**
 * Класс сгенерирован автоматически, для таблицы RequestLog(Логи вызовов сервисов) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.10.23
 */
public class RequestLogConst extends com.querydsl.sql.RelationalPathBase<RequestLog> {

    private static final long serialVersionUID = 777020860;

    /**
     * Логи вызовов сервисов
     */
    public static final RequestLogConst RequestLog = new RequestLogConst("RequestLog");

    /**
     * ID записи
     */
    public static final String ID = "id";

    /**
     * Уникальный идентификатор сессии пользователя
     */
    public static final String TOKEN = "token";

    /**
     * Идентификатор события
     */
    public static final String EVENT_ID = "eventId";

    /**
     * Время запуска
     */
    public static final String START_INVOKE = "startInvoke";

    /**
     * Время окончания
     */
    public static final String END_INVOKE = "endInvoke";

    /**
     * Ошибка если была (stacktrace)
     */
    public static final String ERROR_STACK_TRACE = "errorStackTrace";

    /**
     * ID записи
     */
    public final NumberPath<Long> id = createNumber(ID, Long.class);

    /**
     * Уникальный идентификатор сессии пользователя
     */
    public final StringPath token = createString(TOKEN);

    /**
     * Идентификатор события
     */
    public final StringPath eventId = createString(EVENT_ID);

    /**
     * Время запуска
     */
    public final NumberPath<Long> startInvoke = createNumber(START_INVOKE, Long.class);

    /**
     * Время окончания
     */
    public final NumberPath<Long> endInvoke = createNumber(END_INVOKE, Long.class);

    /**
     * Ошибка если была (stacktrace)
     */
    public final StringPath errorStackTrace = createString(ERROR_STACK_TRACE);

    public RequestLogConst(String variable) {
        super(RequestLog.class, forVariable(variable), "public", "RequestLog");
        addMetadata();
    }

    public RequestLogConst(com.querydsl.core.types.Path<? extends RequestLog> path) {
        super(path.getType(), path.getMetadata(), "public", "RequestLog");
        addMetadata();
    }

    public RequestLogConst(PathMetadata metadata) {
        super(RequestLog.class, metadata, "public", "RequestLog");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named(ID).withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(token, ColumnMetadata.named(TOKEN).withIndex(2).ofType(Types.VARCHAR).withSize(72));
        addMetadata(eventId, ColumnMetadata.named(EVENT_ID).withIndex(3).ofType(Types.VARCHAR).withSize(32));
        addMetadata(startInvoke, ColumnMetadata.named(START_INVOKE).withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(endInvoke, ColumnMetadata.named(END_INVOKE).withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(errorStackTrace, ColumnMetadata.named(ERROR_STACK_TRACE).withIndex(6).ofType(Types.VARCHAR).withSize(2147483647));
    }

}

