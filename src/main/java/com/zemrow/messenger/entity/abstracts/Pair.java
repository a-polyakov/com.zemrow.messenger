package com.zemrow.messenger.entity.abstracts;

/**
 * Пакет из 2 сообщений
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Pair<T1, T2> {
    private final T1 v1;
    private final T2 v2;

    public Pair(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public T1 getV1() {
        return v1;
    }

    public T2 getV2() {
        return v2;
    }
}
