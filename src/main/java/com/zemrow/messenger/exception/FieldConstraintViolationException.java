package com.zemrow.messenger.exception;

import com.zemrow.messenger.logic.сonstrain.AbstractFieldConstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class FieldConstraintViolationException extends MessengerException {
    public FieldConstraintViolationException(AbstractFieldConstrain fieldConstrain) {
        //TODO
        super(fieldConstrain.getEntityClass().getName()+" "+fieldConstrain.getFieldName());
    }
}
