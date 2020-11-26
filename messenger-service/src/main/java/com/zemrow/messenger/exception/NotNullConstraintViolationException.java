package com.zemrow.messenger.exception;

import com.zemrow.messenger.сonstrain.NotNullConstraint;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class NotNullConstraintViolationException extends FieldConstraintViolationException {
    public NotNullConstraintViolationException(NotNullConstraint notNullConstrain) {
        //TODO
        super(notNullConstrain);
    }
}
