package com.zemrow.messenger.exception;

import com.zemrow.messenger.сonstrain.UniqueConstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class UniqueConstraintViolationException extends FieldConstraintViolationException {
    public UniqueConstraintViolationException(UniqueConstrain uniqueConstrain) {
        //TODO
        super(uniqueConstrain);
    }
}
