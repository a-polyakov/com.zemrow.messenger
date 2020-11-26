package com.zemrow.messenger.сonstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class AbstractFieldConstraint extends AbstractConstraint {
    private final String fieldName;

    public AbstractFieldConstraint(Class entityClass, String fieldName) {
        // TODO message
        super(entityClass);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
