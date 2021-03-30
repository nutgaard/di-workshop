package no.utgdev.diy.ex3

import no.utgdev.diy.annotations.Bean;

class Ex3Config2 {
    @Bean
    fun service(): Service {
        return Service()
    }

    @Bean
    fun worldDao(): WorldDao {
        return WorldDao()
    }
}