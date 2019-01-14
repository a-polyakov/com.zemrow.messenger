package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.service.ChatService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class ChatController extends AbstractController {

    private final ObjectMapper jsonMapper;

    private final ChatService service;

    public ChatController(ObjectMapper jsonMapper, ChatService service) {
        this.jsonMapper = jsonMapper;
        this.service = service;
    }

    /**
     * Получить список чатов пользователя отсортированых по последнему сообщению.
     *
     * @param session TODO
     * @param json    TODO
     */
    public ObjectNode listLast(SessionStorage session, ObjectNode json) {
        final int offset = json.get(ATTR_OFFSET).asInt();
        final int limit = json.get(ATTR_LIMIT).asInt();
        final PageNavigationDto<ChatTiledDto> page = service.listLast(session, offset, limit);
        return jsonMapper.valueToTree(page);
    }

    /**
     * Получить информацию о чате.
     */
    public void selectById(SessionStorage session, ObjectNode json) {
        long chatId = json.get("chatId").asLong();
        service.selectById(chatId);
    }
}
