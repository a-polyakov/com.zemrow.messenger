package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.service.UserStatusService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.10
 */
public class UserStatusController extends AbstractController {

    private final UserStatusService service;

    public UserStatusController(UserStatusService service) {
        this.service = service;
    }

    /**
     * TODO
     * Получить список доступных статусов.
     */
    public void select(SessionStorage session, ObjectNode json) {
        service.select();
    }
}
