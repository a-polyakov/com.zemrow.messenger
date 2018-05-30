package com.zemrow.messenger.logic.сonstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class AbstractFieldConstrain extends AbstractConstrain{
    private final String fieldName;

    public AbstractFieldConstrain(Class entityClass, String fieldName) {
        // TODO message
        super(entityClass);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
