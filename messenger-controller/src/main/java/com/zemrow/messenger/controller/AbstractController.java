package com.zemrow.messenger.controller;

import com.zemrow.messenger.json.LongAsHex;
import com.zemrow.messenger.service.AbstractService;

import java.util.Map;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class AbstractController<SERVICE extends AbstractService> {
    public static final long DEFAULT_OFFSET = 0;
    public static final long DEFAULT_LIMIT = 20;

    public static final String ATTR_OFFSET = "offset";
    public static final String ATTR_LIMIT = "limit";

    public static final String ATTR_CHAT_ID = "chatId";
    public static final String ATTR_MESSAGE_ID = "messageId";
    /**
     * Уникальный идентификатор сессии, сложный для подбора
     */
    public static final String TOKEN = "token";
    /**
     * ID пользователя
     */
    public static final String ATTR_USER_ID = "userId";
    /**
     * MIME media type for JSON
     */
    protected static final String MIME_TYPE_JSON = "application/json";

    /**
     * TODO
     */
    protected final SERVICE service;

    /**
     * TODO
     */
    public AbstractController(SERVICE service) {
        this.service = service;
    }

    /**
     * TODO
     */
    public static Long getLong(Map json, String field) {
        Long result = null;
        Object o = json.get(field);
        if (o instanceof Long) {
            result = (Long) o;
        } else if (o instanceof String) {
            result = LongAsHex.hexStringToLong((String) o);
        } else {
            throw new RuntimeException("Error cast to long. Unknown type " + o.getClass() + ". Value " + o.toString());
        }
        return result;
    }

    /**
     * TODO
     */
    public static Long getLong(Map json, String field, Long defaultValue) {
        Long result = getLong(json, field);
        if (result == null) {
            result = defaultValue;
        }
        return result;
    }
}
