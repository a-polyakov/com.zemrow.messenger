ui.left_panel.user_info = {
    user_id: {
        get: function () {
            $(".user_info_panel").attr("user_id");
        },
        set: function (user_id) {
            $(".user_info_panel").attr("user_id", user_id);
        }
    },
    user_name: {
        get: function () {
            $(".user_info_panel .user_info_name").text();
        },
        set: function (user_name) {
            $(".user_info_panel .user_info_name").text(user_name);
        }
    },
    menu: {
        show: function () {
            $('.user_info_menu_dialog').animate({opacity: 'show'}, 300);
        },
        hide: function () {
            $('.user_info_menu_dialog').animate({opacity: 'hide'}, 300);
        },
        toggle: function () {
            if ($('.user_info_menu_dialog').is(":visible")) {
                ui.left_panel.user_info.menu.hide();
            } else {
                ui.left_panel.user_info.menu.show();
            }
        },
        exit: {
            onclick: function () {
                ui.left_panel.user_info.menu.hide();
                api.userSession.delete();
                // TODO ws close автоматически или вручную
                ui.dialog.login.show();
            }
        }
    }
};

wsListener.user.current = function (user) {
    ui.left_panel.user_info.user_id.set(user.userId)
    ui.left_panel.user_info.user_name.set(user.userName);
    //TODO status
    //ui.left_panel.user_info.user_status.set(user.status_id);
};