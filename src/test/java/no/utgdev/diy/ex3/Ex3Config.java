package no.utgdev.diy.ex3;

import no.utgdev.diy.annotations.Bean;
import no.utgdev.diy.annotations.Import;

@Import(Ex3Config2.class)
public class Ex3Config {
    @Bean
    public Controller controller() {
        return new Controller();
    }

    @Bean
    public HelloDao helloDao() {
        return new HelloDao();
    }
}
