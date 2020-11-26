var ui = {
    body: {
        on_load: function () {
            api.user.current();
            //TODO
            ui.left_panel.tabs.chat_tab.tabs.chat_list_tab.on_click();
        }
    },
    left_panel: {
        get: function () {
            return $(".left_panel");
        },
        find_panel: {
            textfield: {
                get: function () {
                    return $(".find_panel .find_textfield input").val();
                },
                set: function (s) {
                    $(".find_panel .find_textfield input").val(s);
                },
                onkeydown: function (e) {
                    //console.log(e);
                    if (e.keyCode == 9 || e.keyCode == 13) {
                        ui.left_panel.find_panel.button.onclick();
                    } else if (e.keyCode == 27) {
                        ui.left_panel.find_panel.textfield.set('');
                        ui.left_panel.find_panel.findingArea.hide();
                    } else if (e.keyCode != 16) {
                        ui.left_panel.find_panel.findingArea.show();
                    }
                }
            },
            button: {
                onclick: function () {
                    ui.left_panel.find_panel.findingArea.hide();
                    var s = ui.left_panel.find_panel.textfield.get();
                    ui.dialog.search_user_dialog.textfield.set(s)
                    ui.dialog.search_user_dialog.find();
                    ui.dialog.search_user_dialog.show();
                }
            },
            findingArea: {
                show: function () {
                    $(".finding_area_dialog").animate({opacity: 'show'}, 300);
                },
                hide: function () {
                    $(".finding_area_dialog").animate({opacity: 'hide'}, 300);
                }
            }
        },
        tabs: {
            chat_tab: {
                get: function () {
                    return $(".chat_tab");
                },
                tabs: {
                    get: function () {
                        return $(".chat_tabs");
                    },
                    select: function (tab) {
                        $(".chat_tabs .current").removeClass("current");
                        $(".tab_panel>table:visible, .tab_panel>div:visible").hide();
                        if (tab) {
                            tab.get().addClass("current");
                            tab.panel.get().show();
                        }
                    },
                    chat_tree_tab: {
                        get: function () {
                            return $(".chat_tree_tab");
                        },
                        panel: {
                            get: function () {
                                return $(".chat_tree_panel");
                            }
                        },
                        on_click: function () {
                            ui.left_panel.tabs.chat_tab.tabs.select(ui.left_panel.tabs.chat_tab.tabs.chat_tree_tab);
                        }
                    },
                    chat_outbox_tab: {
                        get: function () {
                            return $(".chat_outbox_tab");
                        },
                        panel: {
                            get: function () {
                                return $(".chat_outbox_panel");
                            }
                        },
                        on_click: function () {
                            ui.left_panel.tabs.chat_tab.tabs.select(ui.left_panel.tabs.chat_tab.tabs.chat_outbox_tab);
                        }
                    },
                    chat_inbox_tab: {
                        get: function () {
                            return $(".chat_inbox_tab");
                        },
                        panel: {
                            get: function () {
                                return $(".chat_inbox_panel");
                            }
                        },
                        on_click: function () {
                            ui.left_panel.tabs.chat_tab.tabs.select(ui.left_panel.tabs.chat_tab.tabs.chat_inbox_tab);
                        }
                    }
                },
                on_click: function () {
                    ui.left_panel.tabs.contact_tab.get().removeClass("current");
                    ui.left_panel.tabs.contact_tab.tabs.get().hide();
                    ui.left_panel.tabs.chat_tab.get().addClass("current");
                    ui.left_panel.tabs.chat_tab.tabs.get().show();
                    // TODO panel show
                    ui.left_panel.tabs.chat_tab.tabs.select(ui.left_panel.tabs.chat_tab.tabs.chat_list_tab);
                }
            },
            contact_tab: {
                get: function () {
                    return $(".contact_tab");
                },
                tabs: {
                    get: function () {
                        return $(".contact_tabs");
                    },
                    select: function (tab) {
                        $(".contact_tabs .current").removeClass("current");
                        $(".tab_panel>table:visible, .tab_panel>div:visible").hide();
                        if (tab) {
                            tab.get().addClass("current");
                            tab.panel.get().show();
                        }
                    },
                    contact_list_tab: {
                        get: function () {
                            return $(".contact_list_tab");
                        },
                        panel: {
                            get: function () {
                                return $(".contact_list_panel");
                            }
                        },
                        on_click: function () {
                            ui.left_panel.tabs.contact_tab.tabs.select(ui.left_panel.tabs.contact_tab.tabs.contact_list_tab);
                        }
                    },
                    contact_tree_tab: {
                        get: function () {
                            return $(".contact_tree_tab");
                        },
                        panel: {
                            get: function () {
                                return $(".contact_tree_panel");
                            }
                        },
                        on_click: function () {
                            ui.left_panel.tabs.contact_tab.tabs.select(ui.left_panel.tabs.contact_tab.tabs.contact_tree_tab);
                        }
                    }
                },
                on_click: function () {
                    ui.left_panel.tabs.chat_tab.get().removeClass("current");
                    ui.left_panel.tabs.chat_tab.tabs.get().hide();
                    ui.left_panel.tabs.contact_tab.get().addClass("current");
                    ui.left_panel.tabs.contact_tab.tabs.get().show();
                    // TODO panel show
                    ui.left_panel.tabs.contact_tab.tabs.select(ui.left_panel.tabs.contact_tab.tabs.contact_list_tab);
                }
            },
            reload: function () {
                if ($(".chat_tabs .current").hasClass("chat_tab")) {
                    ui.left_panel.tabs.chat_tab.on_click()
                } else if ($(".chat_tabs .current").hasClass("contact_tab")) {
                    ui.left_panel.tabs.contact_tab.on_click()
                }
            }
        },
        open_close_button: {
            on_click: function () {
                ui.left_panel.get().toggle(300);
            }
        }
    },
    chat_panel: {},
    right_panel: {
        get: function () {
            return $(".right_panel");
        },
        open_close_button: {
            on_click: function () {
                ui.right_panel.get().toggle(300);
            }
        }
    },
    dialog: {
        login: {
            show: function () {
                $('.login').animate({opacity: 'show'}, 300);
            },
            hide: function () {
                $('.login').animate({opacity: 'hide'}, 300);
            },
            onsubmit: function () {
                var loginTable = $('.login');
                var usernameInput = loginTable.find('input[name=username]');
                var username = usernameInput.val();
                var passwordInput = loginTable.find('input[name=password]');
                var password = passwordInput.val();

                if (username != '') {
                    usernameInput.removeClass("error");
                    if (password != '') {
                        passwordInput.removeClass("error");
                        api.userSession.insert(username, password,
                            function (data) {
                                if (data.statusCode().status == 200) {
                                    passwordInput.val('');
                                    ui.dialog.login.hide();
                                    api.user.current();
                                    ui.left_panel.tabs.reload();
                                    // TODO перезапросить данные на которых возникла ошибка авторизации
                                } else {
                                    //TODO обработка ошибки входа
                                }
                            }
                        );
                    } else {
                        passwordInput.addClass("error");
                    }
                } else {
                    usernameInput.addClass("error");
                }
            },
            registration: {
                onclick: function () {
                    ui.dialog.login.hide();
                    ui.dialog.registration.show();
                }
            }
        },
        registration: {
            show: function () {
                $('.registration').animate({opacity: 'show'}, 300);
            },
            hide: function () {
                $('.registration').animate({opacity: 'hide'}, 300);
            },
            onsubmit: function () {
                var loginTable = $('.registration');
                var usernameInput = loginTable.find('input[name=username]');
                var username = usernameInput.val();
                var passwordInput = loginTable.find('input[name=password]');
                var password = passwordInput.val();
                var confirmPasswordInput = loginTable.find('input[name=confirmPassword]');
                var confirmPassword = confirmPasswordInput.val();

                if (username != '') {
                    usernameInput.removeClass("error");
                    if (password != '' && password == confirmPassword) {
                        passwordInput.removeClass("error");
                        confirmPasswordInput.removeClass("error");
                        api.user.insert(username, password,
                            function (data) {
                                if (data.statusCode().status == 200) {
                                    passwordInput.val('');
                                    confirmPasswordInput.val('');
                                    ui.dialog.registration.hide();
                                    api.user.current();
                                    ui.left_panel.tabs.chat_tab.tabs.chat_list_tab.on_click();
                                    ui.left_panel.tabs.chat_tab.on_click();


                                    // TODO перезапросить данные на которых возникла ошибка авторизации
                                } else {
                                    //TODO обработка ошибки регистрации
                                }
                            }
                        );
                    } else {
                        passwordInput.addClass("error");
                        confirmPasswordInput.addClass("error");
                    }
                } else {
                    usernameInput.addClass("error");
                }
            },
            login: {
                onclick: function () {
                    ui.dialog.registration.hide();
                    ui.dialog.login.show();
                }
            }
        },
        search_user_dialog: {
            show: function () {
                $('.search_user_dialog').animate({opacity: 'show'}, 300);
                $('.search_user_dialog .find_textfield input').focus();
            },
            hide: function () {
                $('.search_user_dialog').animate({opacity: 'hide'}, 300);
            },
            textfield: {
                timerId: 0,
                oldVal: '',
                get: function () {
                    return $(".search_user_dialog .find_textfield input").val();
                },
                set: function (s) {
                    $(".search_user_dialog .find_textfield input").val(s);
                },
                onkeydown: function (e) {
                    // console.log(e);
                    if (e.keyCode == 9 || e.keyCode == 13) {
                        ui.dialog.search_user_dialog.find();
                    } else if (e.keyCode == 27) {
                        ui.dialog.search_user_dialog.hide();
                    } else {
                        clearTimeout(ui.dialog.search_user_dialog.textfield.timerId);
                        ui.dialog.search_user_dialog.textfield.timerId = setTimeout(ui.dialog.search_user_dialog.find, 300);
                    }
                }
            },
            find: function () {
                var s = ui.dialog.search_user_dialog.textfield.get();
                if (ui.dialog.search_user_dialog.textfield.oldVal != s) {
                    ui.dialog.search_user_dialog.list.clear();
                    ui.dialog.search_user_dialog.textfield.oldVal = s;
                    api.user.find(s, 0, 10);
                }
            },
            list: {
                //TODO добавить: текущая страница и отслеживание прокрутки (life load)
                clear: function () {
                    $(".search_user_dialog_list>table").html('');
                },
                setPage: function (pageNavigationDto) {
                    //TODO
                    if (pageNavigationDto.offset == 0) {
                        var s = '';
                        for (var userTiledDto of pageNavigationDto.page) {
                            s += '<tr>' +
                                '<td>' + userTiledDto.avatarId + '</td>' +
                                '<td><a href="#" onclick="api.user.select(\'' + userTiledDto.userId + '\')">' + userTiledDto.username + '</a></td>' +
                                '<td>' + userTiledDto.userContactId + '</td>' +
                                '<td><input type="button" value="+" title="Добавить в контакты" onclick="api.userContact.insert(\'' + userTiledDto.userId + '\')"></td>' +
                                '</tr>';
                        }
                        $(".search_user_dialog_list>table").html(s);
                    }
                },

            }
        },
        user_info_dialog: {
            show: function (user) {
                $('.user_info_dialog .username').text(user.username);
                //TODO
                $('.user_info_dialog').animate({opacity: 'show'}, 300);
            },
            hide: function () {
                $('.user_info_dialog').animate({opacity: 'hide'}, 300);
            },
        }
    },
    template: {
        tiled: {
            contact: function (chatTiledDto) {
                if (!chatTiledDto.lastMessageText) {
                    chatTiledDto.lastMessageText = '';
                }
                // TODO chatTiledDto.lastMessageText предобработка: удалить теги
                var tiled_last_message_date = ''
                var tiled_last_message_time = ''
                if (chatTiledDto.lastMessageTime) {
                    tiled_last_message_date = ui.utils.date.getDate(chatTiledDto.lastMessageTime);
                    tiled_last_message_time = ui.utils.date.getTime(chatTiledDto.lastMessageTime);
                }
                return "<table class=\"tiled_contact\">\n" +
                    "    <colgroup style=\"width: 50px;\"/>\n" +
                    "    <colgroup style=\"width: 210px;\"/>\n" +
                    "    <colgroup style=\"width: 20px;\"/>\n" +
                    "    <tr>\n" +
                    "        <td rowspan=\"3\" class=\"tiled_contact_icon\">TODO</td>\n" +
                    "        <td class=\"tiled_name\">" + chatTiledDto.label + "</td>\n" +
                    //TODO
                    "        <td title=\"Статус: В сети\" style=\"color: red;\" class=\"tiled_status\">&#9873\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td title=\"Последнее сообщение: " + chatTiledDto.lastMessageText + "\"\n" +
                    "            colspan=\"2\" class=\"tiled_last_message\">" + chatTiledDto.lastMessageText + "</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td title=\"Последнее сообщение\"><span class=\"tiled_last_message_date\">" + tiled_last_message_date + "</span>\n" +
                    "            <span class=\"tiled_last_message_time\">" + tiled_last_message_time + "</span></td>\n" +
                    "        <td title=\"Непрочитано: " + chatTiledDto.unreadMessageCount + "\" class=\"tiled_unread_count\">" + chatTiledDto.unreadMessageCount + "</td>\n" +
                    "    </tr>\n" +
                    "</table>";
            },
            chat: function (chatDto) {
                return "<table class=\"tiled_chat\">\n" +
                    "    <colgroup style=\"width: 100px;\"/>\n" +
                    "    <colgroup style=\"width: 80px;\"/>\n" +
                    "    <colgroup style=\"width: 60px;\"/>\n" +
                    "    <colgroup style=\"width: 20px;\"/>\n" +
                    "    <colgroup style=\"width: 20px;\"/>\n" +
                    "    <tr>\n" +
                    "        <td title=\"Номер задачи\" class=\"tiled_chat_number\">IGNITE-10102</td>\n" +
                    "        <td title=\"Наименование задачи\" colspan=\"3\"  class=\"tiled_name\">наименование задачи</td>\n" +
                    "        <td title=\"Статус: Закрыто\" style=\"color: red;\" class=\"tiled_status\">&#9873</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td title=\"Последнее сообщение\"><span class=\"tiled_last_message_date\">2018.12.12</span> <span class=\"tiled_last_message_time\">10:00</span></td>\n" +
                    "        <td title=\"Последнее сообщение: последнее сообщение может быть очень длинным\" colspan=\"4\" class=\"tiled_last_message\">последнее сообщение может быть очень длинным</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td title=\"Исполнитель\" colspan=\"2\" class=\"tiled_chat_executor\">Иванов Иван Иванович</td>\n" +
                    "        <td title=\"Плановая дата завершения\" class=\"tiled_chat_deadline\">2019.02.01</td>\n" +
                    "        <td title=\"Признак работы над задачей\" class=\"tiled_chat_work_now\">&#9658;</td>\n" +
                    "        <td title=\"Непрочитано: 15\" colspan=\"2\" class=\"tiled_unread_count\">15</td>\n" +
                    "    </tr>\n" +
                    "</table>";
            }
        }
    },
    utils: {
        date: {
            getDate: function (timestamp) {
                // TODO timezone
                var date = new Date(parseInt("0x"+timestamp));
                return date.getFullYear() + "." + date.getMonth() + "." + date.getDate();
            },
            getTime: function (timestamp) {
                // TODO timezone
                var date = new Date(parseInt("0x"+timestamp));
                var hours = date.getHours();
                if (hours < 10) {
                    hours = "0" + hours;
                }
                var minutes = date.getMinutes();
                if (minutes < 10) {
                    minutes = "0" + minutes;
                }
                return hours + ":" + minutes;
            }
        },
        // TODO
        speak: function (text) {
            var url = 'https://tts.voicetech.yandex.net/generate?' +
                'key=069b6659-984b-4c5f-880e-aaedcfd84102' +
                '&text=' + encodeURI(text) +
                '&format=opus' +
                '&lang=ru-RU' +
                '&speed=1.1' +
                '&speaker=oksana';

            var audio = document.getElementById('audio');
            audio.src = url;
            audio.onloadeddata = function () {
                audio.play();
            };
            audio.load();
        }
    }
};