package com.zemrow.messenger.dto;

/**
 * Пакет из 3 объектов
 *
 * @author Alexandr Polyakov on 2018.04.13
 */
public class Triplet<T1, T2, T3> {
    private final T1 v1;
    private final T2 v2;
    private final T3 v3;

    public Triplet(T1 v1, T2 v2, T3 v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public T1 getV1() {
        return v1;
    }

    public T2 getV2() {
        return v2;
    }

    public T3 getV3() {
        return v3;
    }
}
