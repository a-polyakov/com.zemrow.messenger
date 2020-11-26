package com.zemrow.messenger.exception;

import com.zemrow.messenger.сonstrain.AbstractFieldConstraint;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class FieldConstraintViolationException extends MessengerException {
    public FieldConstraintViolationException(AbstractFieldConstraint fieldConstrain) {
        //TODO
        super(fieldConstrain.getEntityClass().getName() + " " + fieldConstrain.getFieldName());
    }
}
