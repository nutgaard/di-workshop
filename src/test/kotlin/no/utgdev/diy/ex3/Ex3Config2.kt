package no.utgdev.diy.ex3

//REMOVE import no.utgdev.diy.annotations.Bean;

class Ex3Config2 {
    //REMOVE @Bean
    fun service(): Service {
        return Service()
    }

    //REMOVE @Bean
    fun worldDao(): WorldDao {
        return WorldDao()
    }
}