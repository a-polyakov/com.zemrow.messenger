package com.zemrow.messenger.controller;

import com.zemrow.messenger.controller.abstracts.AbstractController;
import com.zemrow.messenger.service.NumberingService;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class NumberingController extends AbstractController {

    private final NumberingService service;

    public NumberingController(NumberingService service) {
        this.service = service;
    }
}
