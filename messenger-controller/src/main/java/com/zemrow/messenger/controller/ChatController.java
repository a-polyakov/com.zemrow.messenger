package com.zemrow.messenger.controller;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.dto.PageNavigationResponse;
import com.zemrow.messenger.service.ChatService;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class ChatController extends AbstractController<ChatService> {

    public ChatController(ChatService service) {
        super(service);
    }

    /**
     * Получить список чатов пользователя отсортированных по последнему сообщению.
     *
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public PageNavigationResponse<ChatTiledDto> listLast(SessionStorage session, Map json) throws Exception {
        Long offset = getLong(json, AbstractController.ATTR_OFFSET, DEFAULT_OFFSET);
        Long limit = getLong(json, AbstractController.ATTR_LIMIT, DEFAULT_LIMIT);
        final PageNavigationDto<ChatTiledDto> page = service.listLast(session, offset, limit);
        return new PageNavigationResponse<>(page);
    }

    /**
     * TODO
     * @param chatId идентификатор чата
     * @return идентификаторы пользователей из чата
     */
    public List<Long> selectUserIdByChatId(Long chatId) throws Exception {
        return service.selectUserIdByChatId(chatId);
    }

    /**
     * Получить информацию о чате.
     *//*
     TODO
    public void selectById(SessionStorage session, Map json) {
        long chatId = (long) json.get(ChatConst.ID);
        service.selectById(chatId);
    }
    */
}
