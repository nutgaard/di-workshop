package no.utgdev.diy.ex1

import no.utgdev.diy.annotations.Bean

class Ex1Config2 {
    @Bean
    fun number(): Double {
        return 2.0
    }

    @Bean
    fun map(): Map<String, String> {
        return emptyMap()
    }
}