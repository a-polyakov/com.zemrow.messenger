package com.zemrow.messenger.web;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.*;


/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class MessengerRout {

    private final ChatController chatController;
    private final MessageController messageController;
    private final NumberingController numberingController;
    private final TagController tagController;
    private final UserContactController userContactController;
    private final UserController userController;
    private final UserSessionController userSessionController;
    private final UserStatusController userStatusController;

    public MessengerRout(
            ChatController chatController,
            MessageController messageController,
            NumberingController numberingController,
            TagController tagController,
            UserContactController userContactController,
            UserController userController,
            UserSessionController userSessionController,
            UserStatusController userStatusController
    ) {
        this.chatController = chatController;
        this.messageController = messageController;
        this.numberingController = numberingController;
        this.tagController = tagController;
        this.userContactController = userContactController;
        this.userController = userController;
        this.userSessionController = userSessionController;
        this.userStatusController = userStatusController;
    }

    /**
     * TODO
     * Методы доступные без авторизации
     *
     * @param eventId TODO
     * @param json    TODO
     * @return TODO
     */
    public ObjectNode receive(EventEnum eventId, ObjectNode json) {
        ObjectNode result = null;
        switch (eventId) {
            case userSession_insert:
                result = userSessionController.insert(json);
                break;
            case user_insert:
                result = userController.insert(json);
                break;
            default:
                throw new IllegalArgumentException("Handler not found. eventId: " + eventId);
        }
        return result;
    }

    /**
     * TODO
     *
     * @param eventId TODO
     * @param session TODO
     * @param json    TODO
     * @return TODO
     */
    public ObjectNode receive(EventEnum eventId, SessionStorage session, ObjectNode json) {
        ObjectNode result = null;
        switch (eventId) {
            case userSession_delete:
                userSessionController.delete(session, json);
                break;

            case user_current:
                result = userController.current(session, json);
                break;
            case user_select:
                result = userController.select(session, json);
                break;
            case user_updateStatus:
                userController.updateStatus(session, json);
                break;
            case user_find:
                result = userController.find(session, json);
                break;

            case userContact_insert:
                result = userContactController.insert(session, json);
                break;
            case userContact_select:
                userContactController.select(session, json);
                break;

            case chat_listLast:
                result = chatController.listLast(session, json);
                break;
            case chat_selectById:
                chatController.selectById(session, json);
                break;

            case message_insert:
                messageController.insert(session, json);
                break;
            case message_select:
                messageController.select(session, json);
                break;
            case message_updateStatus:
                messageController.updateStatus(session, json);
                break;
            case message_update:
                messageController.update(session, json);
                break;
            case message_delete:
                messageController.delete(session, json);
                break;

            case tag_select:
                tagController.select(session, json);
                break;

            case userStatus_select:
                userStatusController.select(session, json);
                break;
            default:
                throw new IllegalArgumentException("Handler not found. eventId: " + eventId);
        }
        return result;
    }
}
