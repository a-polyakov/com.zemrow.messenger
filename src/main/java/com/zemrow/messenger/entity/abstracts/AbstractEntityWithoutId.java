package com.zemrow.messenger.entity.abstracts;

/**
 * Костяк сущности
 *
 * @author Alexandr Polyakov on 2018.04.19
 */
public abstract class AbstractEntityWithoutId<K extends AbstractKey> extends AbstractToString {
    /**
     * @return Ключ сущности.
     */
    public abstract K getKey();
}
