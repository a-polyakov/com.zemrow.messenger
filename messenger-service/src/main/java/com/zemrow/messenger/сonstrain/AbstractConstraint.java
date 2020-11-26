package com.zemrow.messenger.сonstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class AbstractConstraint {
    private final Class entityClass;

    // TODO message
    public AbstractConstraint(Class entityClass) {
        this.entityClass = entityClass;
    }

    public Class getEntityClass() {
        return entityClass;
    }
}
