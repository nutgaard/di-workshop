package no.utgdev.diy.utils;

public class Pair<S, T> {
    public final S s;
    public final T T;

    public Pair(S s, T t) {
        this.s = s;
        T = t;
    }

    public S getS() {
        return s;
    }

    public T getT() {
        return T;
    }
}
