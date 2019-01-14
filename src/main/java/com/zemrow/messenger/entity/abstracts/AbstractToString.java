package com.zemrow.messenger.entity.abstracts;

/**
 * Стандартная реализация строкового представления
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public abstract class AbstractToString {
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append('{');
        toString(sb);
        sb.append('}');
        return sb.toString();
    }

    protected abstract void toString(StringBuilder sb);
}
