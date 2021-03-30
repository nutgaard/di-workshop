package no.utgdev.diy.ex2

import no.utgdev.diy.annotations.Bean;

class Ex2Config2 {
    @Bean
    fun number(): Double {
        return 2.0
    }

    @Bean
    fun map(): Map<String, String> {
        return emptyMap()
    }
}