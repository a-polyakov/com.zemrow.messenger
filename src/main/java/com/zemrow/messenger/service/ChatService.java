package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.logic.ChatLogic;
import com.zemrow.messenger.service.abstracts.AbstractService;
import org.apache.ignite.transactions.Transaction;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class ChatService extends AbstractService {

    private final ChatLogic chatLogic;


    public ChatService(ChatLogic chatLogic) {
        this.chatLogic = chatLogic;
    }

    /**
     * Получить список чатов пользователя отсортированых по последнему сообщению.
     *
     * @param session TODO
     * @param offset  TODO
     * @param limit   TODO
     * @return TODO
     */
    public PageNavigationDto<ChatTiledDto> listLast(SessionStorage session, int offset, int limit) {
        try (Transaction transaction = transaction()) {
            return chatLogic.listLast(session, offset, limit);
        }
    }

    /**
     * Получить информацию о чате.
     *
     * @param chatId идентификатор чата.
     */
    public void selectById(Long chatId) {
        //TODO
    }
}
