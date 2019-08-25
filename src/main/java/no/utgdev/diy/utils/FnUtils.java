package no.utgdev.diy.utils;

import java.util.function.Consumer;
import java.util.function.Function;

public class FnUtils {
    public interface ThrowingFunction<S, T> { T apply(S t) throws Exception;}
    public interface ThrowingConsumer<S> { void accept(S t) throws Exception;}

    public static <S, T> Function<S, T> sneakyThrow(ThrowingFunction<S, T> fn) {
        return (S s) -> {
            try {
                return fn.apply(s);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <S> Consumer<S> sneakyThrow(ThrowingConsumer<S> fn) {
        return (S s) -> {
            try {
                fn.accept(s);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
