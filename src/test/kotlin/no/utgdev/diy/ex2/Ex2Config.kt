package no.utgdev.diy.ex2

import no.utgdev.diy.annotations.Bean;
import no.utgdev.diy.annotations.Import;

@Import([Ex2Config2::class])
class Ex2Config {
    @Bean
    fun list(): List<String> {
        return emptyList()
    }

    @Bean
    fun string(): String {
        return ""
    }
}