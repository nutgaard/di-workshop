package no.utgdev.diy.ex1

//REMOVE import no.utgdev.diy.annotations.Bean

class Ex1Config2 {
    //REMOVE @Bean
    fun number(): Double {
        return 2.0
    }

    //REMOVE @Bean
    fun map(): Map<String, String> {
        return emptyMap()
    }
}