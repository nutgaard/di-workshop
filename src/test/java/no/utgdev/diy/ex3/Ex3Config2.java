package no.utgdev.diy.ex3;

//REMOVE import no.utgdev.diy.annotations.Bean;

public class Ex3Config2 {
    //REMOVE @Bean
    public Service service() {
        return new Service();
    }

    //REMOVE @Bean
    public WorldDao worldDao() {
        return new WorldDao();
    }
}
