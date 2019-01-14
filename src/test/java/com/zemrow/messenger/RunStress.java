package com.zemrow.messenger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class RunStress {

    //    private static final int COUNT_USER = 5_000_000;
    private static final int COUNT_USER = 5_000;
    private static final int COUNT_SESSION = 10;
//    private static final int COUNT_USER_CONTACT = 200;
    private static final int COUNT_USER_CONTACT = 20;
//    private static final int COUNT_CHAT_MESSAGE = 500;
    private static final int COUNT_CHAT_MESSAGE = 50;

    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        AtomicInteger userIndex = new AtomicInteger();
        AtomicInteger contactIndex = new AtomicInteger();
        AtomicInteger messageIndex = new AtomicInteger();
        new Timer(true).schedule(new TimerTask() {
            @Override public void run() {
                System.out.println(userIndex + " " + contactIndex + " " + messageIndex);
            }
        }, 5000, 10000);

        try (AppContext appContext = new AppContext(new AppConfiguration(args))) {
            System.out.println("Пользователи");
            final List<Long> userIdList = new ArrayList<>(COUNT_USER);
            for (int i = 0; i < COUNT_USER; i++) {
                userIndex.set(i);
                final String username = "username" + i;
                appContext.getUserService().insert(username, username);
                //TODO
//                userIdList.add(user.getId());

                // Сессия пользователя
                for (int j = 0; j < COUNT_SESSION; j++) {
                    appContext.getUserSessionService().insert(username, username);
                }
            }

            System.out.println("Чаты");
            int otherUserIndex = 0;
            for (int i = 0; i < COUNT_USER; i++) {
                userIndex.set(i);
                for (int j = 0; j < COUNT_USER_CONTACT; j++) {
//                    final Long parentUserId = userIdList.get(i);
//                    otherUserIndex++;
//                    if (i == otherUserIndex) {
//                        otherUserIndex++;
//                    }
//                    if (otherUserIndex >= COUNT_USER) {
//                        otherUserIndex = 0;
//                    }
//                    final long childUserId = userIdList.get(otherUserIndex);
//
//                    UserContact userContact = userContactDao.selectByParentUserIdAndChildUserId(session, parentUserId, childUserId);
//                    if (userContact == null) {
//
//                        userContact = userContactDao.selectByParentUserIdAndChildUserId(session, childUserId, parentUserId);
//                        final long chatId;
//                        if (userContact == null) {
//                            final Chat chat = new Chat();
//                            chat.setLabel(userDao.select(session, new SimpleKey(childUserId)).getName());
//                            chat.setChatType(ChatTypeEnum.CHAT);
//                            chatDao.insert(session, chat);
//                            chatId = chat.getId();
//
//                            if (chat.getChatType() == ChatTypeEnum.ISSUE) {
//                                chatPriorityDao.insert(session, chat.getId());
//                            }
//
//                            final ChatTree chatTree = new ChatTree();
//                            chatTree.setParentChatId(chatId);
//                            chatTree.setChildChatId(chatId);
//                            chatTree.setDistance(0);
//                            chatTreeDao.insert(session, chatTree);
//
//                            ChatToUser chatToUser = new ChatToUser();
//                            chatToUser.setChatId(chatId);
//                            chatToUser.setUserId(parentUserId);
//                            chatToUser.setChatToUserType(ChatToUserTypeEnum.DEFAULT);
//                            chatToUserDao.insert(session, chatToUser);
//
//                            chatToUser = new ChatToUser();
//                            chatToUser.setChatId(chatId);
//                            chatToUser.setUserId(childUserId);
//                            chatToUser.setChatToUserType(ChatToUserTypeEnum.DEFAULT);
//                            chatToUserDao.insert(session, chatToUser);
//                        }
//                        else {
//                            chatId = userContact.getChatId();
//                        }
//
//                        userContact = new UserContact();
//                        userContact.setParentUserId(parentUserId);
//                        userContact.setChildUserId(childUserId);
//                        userContact.setLabel(userDao.select(session, new SimpleKey(childUserId)).getName());
//                        userContact.setChatId(chatId);
//                        userContactDao.insert(session, userContact);
//                    }
//
                    for (int k = 0; k < COUNT_CHAT_MESSAGE; k++) {
//                        final Message message = new Message();
//                        message.setChatId(userContact.getChatId());
//                        message.setText("message " + parentUserId + " " + childUserId + " " + k);
//                        message.setMessageType(MessageTypeEnum.SIMPLE);
//                        messageDao.insert(session, message);
//
//                        MessageToUser messageToUser = new MessageToUser();
//                        messageToUser.setMessageId(message.getId());
//                        messageToUser.setUserId(parentUserId);
//                        messageToUser.setMessageStatus(MessageStatusEnum.DELIVERED);
//                        messageToUserDao.insert(session, messageToUser);
//
//                        messageToUser = new MessageToUser();
//                        messageToUser.setMessageId(message.getId());
//                        messageToUser.setUserId(childUserId);
//                        messageToUser.setMessageStatus(MessageStatusEnum.DELIVERED);
//                        messageToUserDao.insert(session, messageToUser);
                    }
                }
            }

            time = System.currentTimeMillis() - time;
            System.out.println("Finish init " + time + " ms");
            time = System.currentTimeMillis();
        }

        time = System.currentTimeMillis() - time;
        System.out.println("Finish close " + time + " ms");
    }
}
