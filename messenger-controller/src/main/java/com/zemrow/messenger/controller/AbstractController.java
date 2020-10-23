package com.zemrow.messenger.controller;

import com.zemrow.messenger.service.AbstractService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class AbstractController<SERVICE extends AbstractService> {
    public static final int DEFAULT_OFFSET = 0;
    public static final int DEFAULT_LIMIT = 20;

    public static final String ATTR_OFFSET = "offset";
    public static final String ATTR_LIMIT = "limit";

    public static final String ATTR_CHAT_ID = "chatId";
    public static final String ATTR_MESSAGE_ID = "messageId";
    /**
     * ID пользователя
     */
    public static final String ATTR_USER_ID = "userId";

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
}
