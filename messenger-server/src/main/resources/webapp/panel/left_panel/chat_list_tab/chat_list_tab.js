ui.left_panel.tabs.chat_tab.tabs.chat_list_tab = {
    get: function () {
        return $(".chat_list_tab");
    },
    panel: {
        //TODO добавить: текущая страница и отслеживание прокрутки (life load)
        get: function () {
            return $(".chat_list_panel");
        },
        setPage: function (pageNavigationDto) {
            //TODO
            if (pageNavigationDto.offset == 0) {
                var s = '';
                for (var chatTiledDto of pageNavigationDto.page) {
                    s += '<tr>' +
                        '<td class="chat_item">';
                    if (chatTiledDto.userContactId) {
                        s += ui.template.tiled.contact(chatTiledDto);
                    } else {
                        s += ui.template.tiled.chat(chatTiledDto);
                    }
                    s += '</td>' +
                        '</tr>';
                }
                $(".chat_list_panel").html(s);
            }
        },
    },
    on_click: function () {
        ui.left_panel.tabs.chat_tab.tabs.select(ui.left_panel.tabs.chat_tab.tabs.chat_list_tab);
        api.chat.listLast(0, 10);
    },
}

wsListener.chat.listLast = function (page) {
    ui.left_panel.tabs.chat_tab.tabs.chat_list_tab.panel.setPage(page);
}