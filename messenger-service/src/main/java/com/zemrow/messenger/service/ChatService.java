package com.zemrow.messenger.service;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.logic.ChatLogic;
import com.zemrow.messenger.service.transaction.DataBase;
import com.zemrow.messenger.service.transaction.ReadOnly;

import java.util.List;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class ChatService extends AbstractService<ChatLogic> {
    /**
     * TODO
     */
    public ChatService(DataBase dataBase, ChatLogic chatLogic) {
        super(dataBase, chatLogic);
    }

    /**
     * Получить список чатов пользователя отсортированных по последнему сообщению.
     *
     * @param session TODO
     * @param offset  TODO
     * @param limit   TODO
     * @return TODO
     */
    public PageNavigationDto<ChatTiledDto> listLast(SessionStorage session, long offset, long limit) throws Exception {
        try (ReadOnly readOnly = readOnly()) {
            return logic.listLast(readOnly.getConnection(), session, offset, limit);
        }
    }

    /**
     * TODO
     * @param chatId идентификатор чата
     * @return идентификаторы пользователей из чата
     */
    public List<Long> selectUserIdByChatId(Long chatId) throws Exception {
        try (ReadOnly readOnly = readOnly()) {
            return logic.selectUserIdByChatId(readOnly.getConnection(), chatId);
        }
    }

    /**
     * Получить информацию о чате.
     *
     * @param chatId идентификатор чата.
     */
//    public void selectById(Long chatId) {
//        //TODO
//    }
}
