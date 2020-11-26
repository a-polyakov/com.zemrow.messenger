var util = {
    nextId: function () {
        var id = Math.random().toString(16).substring(2).toUpperCase();
        var repeat=16-id.length;
        return "0".repeat(repeat)+id;
    }
}

var api = {
    /**
     * Отправка запроса на сервер через WebSocket
     */
    sendJson: function (obj) {
        obj['requestId'] = util.nextId();
        if (ws && ws.send && ws.readyState === 1) {
            // TODO какой метод(json->string) лучше
            console.log("WebSocket send", obj);
            ws.send(JSON.stringify(obj));
        } else {
            if (ws == null || ws.readyState > 1) {
                webSocketOpen(function () {
                    api.sendJson(obj);
                });
            }
        }
    },
    user: {
        /**
         * Регистрация пользователя.
         * @param username Имя пользователя.
         * @param password Пароль пользователя.
         * @param alwaysFunction Функция которую необходимо вызвать по завершению
         */
        insert: function (username, password, alwaysFunction) {
            // получение locale
            var locale = navigator.language;
            // получение timezone name
            var timeZone = Intl.DateTimeFormat().resolvedOptions().timeZone
            $.ajax({
                url: "/api/v1/user", type: "POST",
                data: JSON.stringify({username: username, password: password, locale: locale, timeZone: timeZone}),
                dataType: 'json',
                complete: alwaysFunction
            });
        },
        /**
         * Получить информацию о пользователе.
         * @param userId идентификатор пользователя.
         */
        select: function (userId) {
            api.sendJson({
                operationId: "user_select",
                userId: userId
            });
        },
        /**
         * Получить информацию о текущем пользователе.
         */
        current: function () {
            api.sendJson({
                operationId: "user_current"
            });
        },
        /**
         * Сменить статус пользователя.
         * @param userId идентификатор пользователя.
         * @param statusId идентификатор статуса.
         */
        updateStatus: function (userId, statusId) {
            api.sendJson({
                operationId: "user_updateStatus",
                userId: userId, statusId: statusId
            });
        },
        /**
         * Наити пользователей
         * @param userLike TODO
         * @param offset TODO
         * @param limit TODO
         */
        find: function (userLike, offset, limit) {
            api.sendJson({
                operationId: "user_find",
                userLike: userLike, offset: offset, limit: limit
            });
        }
    },
    userStatus: {
        // Получить список доступных статусов
        select: function () {
            api.sendJson({operationId: "userStatus_select"});
        }
    },
    userContact: {
        /**
         * Текущему пользователю добавить контакт на указанного пользователя
         * @param userId
         */
        insert: function (userId) {
            api.sendJson({
                operationId: "userContact_insert",
                userId: userId
            });
        },
        // Получить список контактов пользователя отсортированных по алфавиту.
        select: function (offset, limit) {
            api.sendJson({
                operationId: "userContact_select",
                offset: offset, limit: limit
            });
        },
    },
    chat: {
        // получить список чатов пользователя отсортированных по последнему сообщению
        listLast: function (offset, limit) {
            api.sendJson({
                operationId: "chat_listLast",
                offset: offset, limit: limit
            });
        },
        /**
         * Получить информацию о чате.
         * @param chatId идентификатор чата.
         */
        selectById: function (chatId) {
            api.sendJson({
                operationId: "chat_selectById",
                chatId: chatId
            });
        }
    },
    message: {
        /**
         * Получить сообщения чата отсортированные по дате получения
         * @param chatId идентификатор чата.
         * @param offset
         * @param limit
         */
        select: function (chatId, offset, limit) {
            api.sendJson({
                operationId: "message_select",
                chatId: chatId, offset: offset, limit: limit
            });
        },
        /**
         * Отправить сообщение
         * @param requestId
         * @param chatId идентификатор чата.
         * @param messageText текст сообщения.
         */
        insert: function (requestId, chatId, messageText) {
            api.sendJson({
                operationId: "message_insert",
                requestId: requestId, chatId: chatId, text: messageText
            });
        },
        /**
         * Отметить сообщение как прочитаное
         * @param messageId
         */
        setStatusRead: function (messageId) {
            api.sendJson({
                operationId: "message_updateStatus",
                messageId: messageId, status: "READ"
            });
        },
        /**
         * Отредактировать текст сообщения
         * @param messageId
         * @param messageText
         */
        update: function (messageId, messageText) {
            api.sendJson({
                operationId: "message_update",
                messageId: messageId, messageText: messageText
            });
        },
        /**
         * Удалить сообщение
         * @param messageId
         */
        delete: function (messageId) {
            api.sendJson({
                operationId: "message_delete",
                messageId: messageId
            });
        }
    },
    tag: {
        /**
         * Получить список доступных тегов
         */
        select: function () {
            api.sendJson({
                operationId: "tag_select"
            });
        }
    },
    userSession: {
        /**
         * Вход в систему
         * @param username Имя пользователя.
         * @param password Пароль пользователя.
         * @param alwaysFunction Функция которую необходимо вызвать по завершению
         */
        insert: function (username, password, alwaysFunction) {
            $.ajax({
                url: "/api/v1/userSession", type: "POST",
                data: JSON.stringify({username: username, password: password}),
                complete: alwaysFunction
            });
        },
        /**
         * Выход из системы (только текущую сессию)
         */
        delete: function () {
            api.sendJson({
                operationId: "userSession_delete"
            });
        }
    }
};