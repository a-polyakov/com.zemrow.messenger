package com.zemrow.messenger.server;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.ChatController;
import com.zemrow.messenger.controller.MessageController;
import com.zemrow.messenger.controller.NumberingController;
import com.zemrow.messenger.controller.TagController;
import com.zemrow.messenger.controller.UserContactController;
import com.zemrow.messenger.controller.UserController;
import com.zemrow.messenger.controller.UserSessionController;
import com.zemrow.messenger.controller.UserStatusController;
import com.zemrow.messenger.dto.AbstractScopeDto;
import com.zemrow.messenger.enums.OperationIdEnum;
import com.zemrow.messenger.exception.BadOperationIdException;

import java.util.Map;


/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class MessengerRout {

    public static final String OPERATION_ID = "operationId";
    public static final String REQUEST_ID = "requestId";

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
     *
     * @param operationId TODO
     * @param session     TODO
     * @param json        TODO
     * @return TODO
     */
    public AbstractScopeDto receive(OperationIdEnum operationId, SessionStorage session, Map json) throws Exception {
        AbstractScopeDto result = null;
        switch (operationId) {
            case user_current:
                result = userController.current(session, json);
                break;
            case userSession_delete:
                result = userSessionController.delete(session, json);
                break;
            case chat_listLast:
                result = chatController.listLast(session, json);
                break;
            case user_find:
                result = userController.find(session, json);
                break;
            case userContact_insert:
                result = userContactController.insert(session, json);
                break;
/*
            case OperationIdEnum.user_select:
                result = userController.select(session, json);
                break;
            case OperationIdEnum.user_updateStatus:
                userController.updateStatus(session, json);
                break;



            case OperationIdEnum.userContact_select:
                userContactController.select(session, json);
                break;


            case OperationIdEnum.chat_selectById:
                chatController.selectById(session, json);
                break;

            case OperationIdEnum.message_insert:
                messageController.insert(session, json);
                break;
            case OperationIdEnum.message_select:
                messageController.select(session, json);
                break;
            case OperationIdEnum.message_updateStatus:
                messageController.updateStatus(session, json);
                break;
            case OperationIdEnum.message_update:
                messageController.update(session, json);
                break;
            case OperationIdEnum.message_delete:
                messageController.delete(session, json);
                break;

            case OperationIdEnum.tag_select:
                tagController.select(session, json);
                break;

            case OperationIdEnum.userStatus_select:
                userStatusController.select(session, json);
                break;*/
            default:
                throw new BadOperationIdException("Operation \"" + operationId + "\" not found.");
        }
        return result;
    }
}
