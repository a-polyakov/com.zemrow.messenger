package com.zemrow.messenger.сonstrain;

/**
 * TODO
 *
 * @author Alexandr Polyakov on 2018.05.26
 */
public class ForeignKeyConstrain extends AbstractFieldConstraint {

    private final Class relatedEntityClass;

    public ForeignKeyConstrain(Class entityClass, String fieldName, Class relatedEntityClass) {
        // TODO message
        super(entityClass, fieldName);
        this.relatedEntityClass = relatedEntityClass;
    }

    public Class getRelatedEntityClass() {
        return relatedEntityClass;
    }
}
