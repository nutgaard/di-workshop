package no.utgdev.diy.ex4;

import no.utgdev.diy.DIY;
import no.utgdev.diy.ex3.Controller;
import no.utgdev.diy.ex3.Ex3Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex4Test {
    @BeforeEach
    void reset() {
        DIY.reset();
    }

    @Test
    void run() {
        DIY.load(Ex3Config.class);
        Controller controller = (Controller) DIY.getBean("controller");

        assertThat(controller).isNotNull();
        assertThat(controller.helloWorld()).isEqualTo("Hello, World");
    }
}
