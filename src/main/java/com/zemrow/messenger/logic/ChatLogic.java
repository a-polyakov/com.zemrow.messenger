package com.zemrow.messenger.logic;

import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.dao.ChatDao;
import com.zemrow.messenger.dao.ChatPriorityDao;
import com.zemrow.messenger.dao.ChatToUserDao;
import com.zemrow.messenger.dao.ChatTreeDao;
import com.zemrow.messenger.dto.ChatTiledDto;
import com.zemrow.messenger.dto.PageNavigationDto;
import com.zemrow.messenger.entity.Chat;
import com.zemrow.messenger.entity.ChatToUser;
import com.zemrow.messenger.entity.ChatTree;
import com.zemrow.messenger.entity.enums.ChatToUserTypeEnum;
import com.zemrow.messenger.entity.enums.ChatTypeEnum;
import com.zemrow.messenger.logic.abstracts.AbstractLogic;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2019.01.02
 */
public class ChatLogic extends AbstractLogic {

    private final ChatDao chatDao;
    private final ChatPriorityDao chatPriorityDao;
    private final ChatToUserDao chatToUserDao;
    private final ChatTreeDao chatTreeDao;

    public ChatLogic(
            ChatDao chatDao,
            ChatPriorityDao chatPriorityDao,
            ChatToUserDao chatToUserDao,
            ChatTreeDao chatTreeDao
    ) {
        this.chatDao = chatDao;
        this.chatPriorityDao = chatPriorityDao;
        this.chatToUserDao = chatToUserDao;
        this.chatTreeDao = chatTreeDao;
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
        return chatDao.listLast(session, offset, limit);
    }

    /**
     * TODO
     *
     * @param session    TODO
     * @param chatType   TODO
     * @param userIdList TODO
     * @return TODO
     */
    public Chat insert(SessionStorage session, ChatTypeEnum chatType, long... userIdList) {
        final Chat result = new Chat();
        //TODO
        result.setLabel(userIdList.toString());
        result.setChatType(chatType);
        chatDao.insert(session, result);

        for (long userId : userIdList) {
            final ChatToUser chatToUser = new ChatToUser();
            chatToUser.setChatId(result.getId());
            chatToUser.setUserId(userId);
            chatToUser.setFavorite(false);
            chatToUser.setChatToUserType(ChatToUserTypeEnum.DEFAULT);
            chatToUserDao.insert(session, chatToUser);
        }

        chatPriorityDao.insert(session, result.getId());

        final ChatTree chatTree = new ChatTree();
        chatTree.setParentChatId(result.getId());
        chatTree.setChildChatId(result.getId());
        chatTree.setDistance(0);
        chatTreeDao.insert(session, chatTree);

        return result;
    }
}
