package no.utgdev.diy.ex5;

//REMOVE import no.utgdev.diy.annotations.Bean;

public class Ex5Config {
    //REMOVE @Bean(name = "min-controller")
    public Controller1 controller() {
        return new Controller1();
    }

    //REMOVE @Bean(name = "min-controller2")
    public Controller2 controller2() {
        return new Controller2();
    }

    //REMOVE @Bean(name = "hello-dao")
    public HelloDao helloDao() {
        return new HelloDao("Greetings");
    }

    //REMOVE @Bean(name = "hello-dao2")
    public HelloDao helloDao2() {
        return new HelloDao("Welcome");
    }
}
