package com.zemrow.messenger.exception;

import com.zemrow.messenger.logic.сonstrain.ForeignKeyConstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class ForeignKeyViolationException extends FieldConstraintViolationException {
    public ForeignKeyViolationException(ForeignKeyConstrain foreignKey) {
        //TODO
        super(foreignKey);
    }
}
