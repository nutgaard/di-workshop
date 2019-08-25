package no.utgdev.diy.ex1;

import no.utgdev.diy.DIYStatic;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class Ex1Test {
    @Test
    void finnAlleBeans() {
        List<String> methods = methodNames(DIYStatic.scan("no.utgdev.diy.ex1"));

        assertThat(methods).hasSize(4);
        assertThat(methods).containsExactlyInAnyOrder("number", "string", "list", "map");
    }

    @Test
    void finnAlleBeansFraRoot() {
        List<String> methods = methodNames(DIYStatic.scan(Ex1Config.class));

        assertThat(methods).hasSize(4);
        assertThat(methods).containsExactlyInAnyOrder("number", "string", "list", "map");
    }

    private static List<String> methodNames(Set<Method> methods) {
        return methods
                .stream()
                .map(Method::getName)
                .collect(toList());
    }
}
