package no.utgdev.diy.ex3;

import no.utgdev.diy.annotations.Bean;

public class Ex3Config2 {
    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    public WorldDao worldDao() {
        return new WorldDao();
    }
}
