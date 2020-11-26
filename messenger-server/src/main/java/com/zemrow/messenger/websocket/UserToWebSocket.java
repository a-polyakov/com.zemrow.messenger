package com.zemrow.messenger.websocket;

import io.undertow.websockets.core.WebSocketChannel;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2020.11.28
 */
public class UserToWebSocket {

    // TODO оптимизировать ConcurrentHashMap только для connectToUser, а синхронизацию спрятать в compute
    private final ConcurrentHashMap<Long, Set<WebSocketChannel>> userToConnect;
    private final ConcurrentHashMap<WebSocketChannel, Long> connectToUser;

    public UserToWebSocket() {
        userToConnect = new ConcurrentHashMap<>();
        connectToUser = new ConcurrentHashMap<>();
    }

    public void put(Long userId, WebSocketChannel channel) {
        userToConnect.compute(userId,
                (key, value) -> {
                    if (value == null) {
                        value = new HashSet<WebSocketChannel>();
                    }
                    value.add(channel);
                    return value;
                });
        connectToUser.put(channel, userId);
    }

    public void remove(WebSocketChannel channel) {
        final Long userId = connectToUser.remove(channel);
        if (userId != null) {
            userToConnect.computeIfPresent(userId,
                    (key, value) -> {
                        value.remove(channel);
                        return value;
                    });
        }
    }

    public Set<WebSocketChannel> getChannels() {
        return connectToUser.keySet();
    }

    public Set<WebSocketChannel> getChannelsByUserId(Long userId) {
        return userToConnect.get(userId);
    }
}
