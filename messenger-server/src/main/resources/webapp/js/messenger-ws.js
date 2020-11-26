/**
 * WebSocket
 */
var ws;

var wsListener = {
    user: {
        select: function (user) {
            ui.dialog.user_info_dialog.show(user)
        },
        update: function (user) {
            //TODO
            debugger;
            console.log(user.id);
            console.log(user.name);
            console.log(user.status_id);
        },
        find: function (page) {
            ui.dialog.search_user_dialog.list.setPage(page);
        }
    },
    userStatus: {
        select: function (list) {
            debugger;
            //TODO показать список статусов пользователя
            console.log(list.offset);
            console.log(list.limit);
            console.log(list.total);
            console.log(list.items);
        }
    },
    userContact: {
        insert: function (userContact) {
            debugger;
            // TODO добавить чат в списки
            // TODO открыть чат
            // TODO загрузить шапку чата
            // TODO загрузить сообщения чата
        },
        select: function (list) {
            debugger;
            //TODO показать список контактов
            console.log(list.offset);
            console.log(list.limit);
            console.log(list.total);
            console.log(list.items);
        }
    },
    chat: {
        select: function (list) {
            debugger;
            //TODO показать список чатов
            console.log(list.offset);
            console.log(list.limit);
            console.log(list.total);
            console.log(list.items);
            // var uiList = "";
            // for (var i in data.data.data) {
            //     var chat = data.data.data[i];
            //     uiList += uiRender.left_panel.tab.chat_tab.chat_tab_list.chat_item.create(chat);
            // }
            // $('.chat_tab_list').html(uiList);
        },
        update: function (chat) {
            debugger;
            // TODO обновить шапку чата
            console.log(chat.chat_type);
            console.log(chat.number);
            console.log(chat.label);
        }
    },
    message: {
        select: function (list) {
            debugger;
            //TODO
            console.log(list.offset);
            console.log(list.limit);
            console.log(list.total);
            console.log(list.items);
//                        debugger;
//                     var uiList = "";
//                     var user_id = uiRender.left_panel.user_info.user_id.get();
//                     for (var i = data.data.data.length - 1; i >= 0; i--) {
//                         var message = data.data.data[i];
//                         uiList += uiRender.home_panel.chat_panel.chat_messenge_list.message.create(
//                             message.id,
//                             message.text,
//                             message.create_time,
//                             message.created_by,
//                             message.message_status,
//                             user_id,
//                             message.update_time,
//                             message.delete_time);
//                     }
//                     $('.chat_messenge_list').html(uiList);
//                     $('.send_message_panel_textfield').prop('disabled', false);
//                     $('.send_message_panel_submit').prop('disabled', false);
//                     $('.send_message_panel_textfield').focus();
        },
        update: function (message) {
            debugger;
//                    TODO
//                     var chat_id = uiRender.home_panel.chat_panel.chat_info.chat_id.get();
            // изменение списка прочитавших
//                     TODO количество изменить
            // if (data.data.chat_id == chat_id) {
            //     uiRender.home_panel.chat_panel.chat_messenge_list.message.mark_read(data.data.id);
            // }
            // TODO изменение текста
            // $('[message_id=' + message.id + ']').find('p:first').text(message.text);
            // $('[message_id=' + message.id + ']').attr("is_edit", "true");
        },
        insert: function (message) {
            debugger;
            //TODO
            // var chat_id = uiRender.home_panel.chat_panel.chat_info.chat_id.get();
            // var user_id = uiRender.left_panel.user_info.user_id.get();
            // if (message.chat_id == chat_id) {
            //     $('.chat_messenge_list').append(uiRender.home_panel.chat_panel.chat_messenge_list.message.create(
            //         message.id,
            //         message.text,
            //         message.create_time,
            //         message.created_by,
            //         message.message_status,
            //         user_id,
            //         message.update_time,
            //         message.delete_time));
            // }
            // if (message.created_by == user_id) {
            //     $('.send_message_panel_textfield').val('');
            //     $('.send_message_panel_textfield').prop('disabled', false);
            //     $('.send_message_panel_submit').prop('disabled', false);
            //     $('.send_message_panel_textfield').focus();
            // }
        },
        delete: function (data) {
            debugger;
            var message = data.data;
            $('[message_id=' + message.id + ']').attr("is_deleted", "true");
        }
    },
    tag: {
        select: function (list) {
            debugger;
            //TODO
            console.log(list.offset);
            console.log(list.limit);
            console.log(list.total);
            console.log(list.items);
        }
    },
    userSession: {
        delete: function () {
            debugger;
            ws.close();
            // TODO проследить что на сервере токен закрывается (проставляется deleteTime)
            ui.dialog.login.show();
        }
    }
};

function webSocketOpen(callback) {
    if (window.WebSocket) {
        if (ws) {
            debugger;
            ws.close();
        }
        ws = new WebSocket('ws://' + document.domain + ':' + location.port + '/websocket');
        ws.onopen = function () {
            console.log('WebSocket opened');
            if (callback) {
                callback.call();
            }
        };
        ws.onmessage = function (e) {
            console.log('WebSocket receive', e.data);
            var listener = null;
            var jsonResponse = null;
            // debugger; // все входящие сообщения
            if (e && e.data) {
                jsonResponse = JSON.parse(e.data);
                // глобальная проверка ошибок
                if ('400' == jsonResponse.status_code) {
                    errorShow(jsonResponse.data);
                } else if ('401' == jsonResponse.status_code) {
                    // TODO
                    alert("401")
                    ui.dialog.login.show();
                } else {
                    if (jsonResponse && jsonResponse.operationId) {
                        var i = jsonResponse.operationId.indexOf('_');
                        var operationService = jsonResponse.operationId.substring(0, i);
                        var serviceListener = wsListener[operationService];
                        if (serviceListener) {
                            var operationAction = jsonResponse.operationId.substring(i + 1);
                            listener = serviceListener[operationAction];
                        }
                    }
                }
            }

            if (listener) {
                listener(jsonResponse);
            } else {
                debugger;
                console.log("operationId not implement");
                console.log(e);
                console.log(e.data);
            }
        };
        ws.onclose = function (data) {
            console.log('WebSocket closed');
            if (data && data.code == 1008) {
                ui.dialog.login.show();
            } else {
                //TODO переподключение
            }
        };
    } else {
        //TODO
        alert("Your browser does not support WebSockets.");
    }
};