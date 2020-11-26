package com.zemrow.messenger.controller;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.UserContactInsertResponse;
import com.zemrow.messenger.entity.UserContact;
import com.zemrow.messenger.enums.ResponseScopeEnum;
import com.zemrow.messenger.service.UserContactService;

import java.util.Map;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class UserContactController extends AbstractController<UserContactService> {

    public UserContactController(UserContactService service) {
        super(service);
    }

    /**
     * Текущему пользователю добавить контакт на указанного пользователя
     *
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public UserContactInsertResponse insert(SessionStorage session, Map json) throws Exception {
        Long userId = getLong(json, ATTR_USER_ID);
        final UserContact userContact = service.insert(session, userId);
        // TODO для пользователя который добавляет контакт открывается окно с чатом
        // TODO для пользователя который был добавлен добавляется новый элемент в список чатов
        // TODO для пользователя который был добавлен добавляется новый элемент в список контактов
        final UserContactInsertResponse result = new UserContactInsertResponse();
        result.setParentUserId(userContact.getParentUserId());
        result.setChildUserId(userContact.getChildUserId());
        result.setScope(ResponseScopeEnum.CHAT);
        result.setTo(userContact.getChatId());
        return result;
    }

    // TODO
    /**
     * Список контактов пользователя отсортированных по алфавиту.
     */
//    public void select(SessionStorage session, ObjectNode json) {
//        int offset = json.get(ATTR_OFFSET).asInt();
//        int limit = json.get(ATTR_LIMIT).asInt();
//        service.select(offset, limit);
//    }
    // Список избранных контактов пользователя, отсортированных по алфавиту
    // Отметить контакт как избранный
    // Списка контактов пользователя отсортированный по алфавиту, с учетом сохраненного в базе фильтра
}
