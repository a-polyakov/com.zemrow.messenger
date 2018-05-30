package com.zemrow.messenger.logic.сonstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public abstract class AbstractConstrain {
    private final Class entityClass;

    // TODO message
    public AbstractConstrain(Class entityClass) {
        this.entityClass = entityClass;
    }

    public Class getEntityClass() {
        return entityClass;
    }
}
