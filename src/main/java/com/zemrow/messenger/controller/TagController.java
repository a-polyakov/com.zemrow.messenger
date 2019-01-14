package com.zemrow.messenger.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemrow.messenger.SessionStorage;
import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.service.TagService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class TagController extends AbstractController {

    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    /**
     * TODO
     * Получить список доступных тегов.
     */
    public void select(SessionStorage session, ObjectNode json) {
        service.select();
    }
}
