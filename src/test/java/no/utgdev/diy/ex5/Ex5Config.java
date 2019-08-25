package no.utgdev.diy.ex5;

import no.utgdev.diy.annotations.Bean;

public class Ex5Config {
    @Bean(name = "min-controller")
    public Controller1 controller() {
        return new Controller1();
    }

    @Bean(name = "min-controller2")
    public Controller2 controller2() {
        return new Controller2();
    }

    @Bean(name = "hello-dao")
    public HelloDao helloDao() {
        return new HelloDao("Greetings");
    }

    @Bean(name = "hello-dao2")
    public HelloDao helloDao2() {
        return new HelloDao("Welcome");
    }
}
