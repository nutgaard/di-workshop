package no.utgdev.diy.ex5;

import no.utgdev.diy.DIY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex5Test {
    @BeforeEach
    void reset() {
        DIY.reset();
    }

    @Test
    void run() {
        DIY.load(Ex5Config.class);
        Controller controller = (Controller) DIY.getBean("min-controller");

        assertThat(controller).isNotNull();
        assertThat(controller.helloWorld()).isEqualTo("Greetings");
    }

    @Test
    void run2() {
        DIY.load(Ex5Config.class);
        Controller controller = (Controller) DIY.getBean("min-controller2");

        assertThat(controller).isNotNull();
        assertThat(controller.helloWorld()).isEqualTo("Welcome");
    }
}
