package no.utgdev.diy.ex3;

import no.utgdev.diy.DIYStatic;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Ex3Test {
    @Test
    void wireup() {
        Set<Method> methods = DIYStatic.scan(Ex3Config.class);
        Map<String, Object> objects = DIYStatic.instansiate(methods);
        DIYStatic.wireup(objects);
        Controller controller = (Controller) DIYStatic.getBean(objects, "controller");

        assertThat(controller).isNotNull();
        assertThat(controller.helloWorld()).isEqualTo("Hello, World");
    }
}
