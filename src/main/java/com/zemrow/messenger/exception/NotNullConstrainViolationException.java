package com.zemrow.messenger.exception;

import com.zemrow.messenger.logic.сonstrain.NotNullConstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class NotNullConstrainViolationException extends FieldConstraintViolationException {
    public NotNullConstrainViolationException(NotNullConstrain notNullConstrain) {
        //TODO
        super(notNullConstrain);
    }
}
