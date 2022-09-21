package edu.itstep.cw20220914.generics;

public class Passport<T> {
    private T id;

    public Passport(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
