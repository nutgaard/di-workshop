package no.utgdev.diy.ex3;

//REMOVE import no.utgdev.diy.annotations.Bean;
//REMOVE import no.utgdev.diy.annotations.Import;

//REMOVE @Import(Ex3Config2.class)
public class Ex3Config {
    //REMOVE @Bean
    public Controller controller() {
        return new Controller();
    }

    //REMOVE @Bean
    public HelloDao helloDao() {
        return new HelloDao();
    }
}
