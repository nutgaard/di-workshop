package no.utgdev.diy.ex2;

import no.utgdev.diy.DIYStatic;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;

class Ex2Test {
    @Test
    void instansiate() {
        Set<Method> methods = DIYStatic.scan(Ex2Config.class);

        Map<String, Object> objects = DIYStatic.instansiate(methods);

        assertThat(objects).hasSize(4);
        assertThat(objects.get("number")).isEqualTo(2.0);
        assertThat(objects.get("string")).isEqualTo("");
        assertThat(objects.get("list")).isEqualTo(emptyList());
        assertThat(objects.get("map")).isEqualTo(emptyMap());
    }
}
