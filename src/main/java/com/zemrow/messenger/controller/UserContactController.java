package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.constants.RoutConst;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.service.UserContactService;
import com.zemrow.messenger.web.ResponseScopeEnum;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class UserContactController extends AbstractController {

    private final ObjectMapper jsonMapper;

    private final UserContactService service;

    public UserContactController(ObjectMapper jsonMapper, UserContactService service) {
        this.jsonMapper = jsonMapper;
        this.service = service;
    }

    /**
     * Текущему пользователю добавить контак на указанного пользователя
     *
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public ObjectNode insert(SessionStorage session, ObjectNode json) {
        long userId = json.get(ATTR_USER_ID).asLong();
        final UserContact userContact = service.insert(session, userId);
        // TODO для пользователя который добавляет контакт открывается окно с чатом
        // TODO для пользователя который был добавлен добавляется новый элемент в список чатов
        // TODO для пользователя который был добавлен добавляется новый элемент в список контактов
        final ObjectNode result = jsonMapper.createObjectNode();
        result.set(RoutConst.SCOPE, new TextNode(ResponseScopeEnum.CHAT.name()));
        result.set(AbstractController.ATTR_CHAT_ID, new TextNode(String.valueOf(userContact.getChatId())));
        result.set("userContactId", new TextNode(userContact.getId().toString()));
        return result;
    }

    /**
     * Список контактов пользователя отсортированных по алфавиту.
     */
    public void select(SessionStorage session, ObjectNode json) {
        int offset = json.get(ATTR_OFFSET).asInt();
        int limit = json.get(ATTR_LIMIT).asInt();
        service.select(offset, limit);
    }
    // TODO
    // Список избранных контактов пользователя, отсортированных по алфавиту
    // Отметить контакткт как избранный
    // Списка контактов пользователя отсортированный по алфавиту, с учетом сохраненного в базе фильтра
}
