package no.utgdev.diy.ex7;

import no.utgdev.diy.DIY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex7Test {
    @BeforeEach
    void reset() {
        DIY.reset();
    }

    @Test
    void run() {
        DIY.load("no.utgdev.diy.ex7");
        MinComponent controller = (MinComponent) DIY.getBean("MinComponent");

        assertThat(controller).isNotNull();
        assertThat(controller.hei()).isEqualTo("Hei fra MinComponent og MINSERVICE");
    }
}
