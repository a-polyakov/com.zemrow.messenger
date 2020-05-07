package com.zemrow.messenger.entity.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.zemrow.messenger.entity.RequestLog;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Класс сгенерирован автоматически, для таблицы RequestLog(Логи вызовов сервисов) из БД
 * 
 * @author com.zemrow.messenger.db.querydsl.QueryDslMetaDataSerializer on 2020.05.07
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
    public final NumberPath<Long> id = createNumber("id", Long.class);

    /**
     * Уникальный идентификатор сессии пользователя
     */
    public final StringPath token = createString("token");

    /**
     * Идентификатор сервиса
     */
    public final StringPath eventId = createString("eventId");

    /**
     * Время запуска
     */
    public final NumberPath<Long> startInvoke = createNumber("startInvoke", Long.class);

    /**
     * Время окончания
     */
    public final NumberPath<Long> endInvoke = createNumber("endInvoke", Long.class);

    /**
     * Ошибка если была (stacktrace)
     */
    public final StringPath errorStackTrace = createString("errorStackTrace");

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
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(token, ColumnMetadata.named("token").withIndex(2).ofType(Types.VARCHAR).withSize(72));
        addMetadata(eventId, ColumnMetadata.named("eventId").withIndex(3).ofType(Types.VARCHAR).withSize(32));
        addMetadata(startInvoke, ColumnMetadata.named("startInvoke").withIndex(4).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(endInvoke, ColumnMetadata.named("endInvoke").withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(errorStackTrace, ColumnMetadata.named("errorStackTrace").withIndex(6).ofType(Types.VARCHAR).withSize(2147483647));
    }

}

