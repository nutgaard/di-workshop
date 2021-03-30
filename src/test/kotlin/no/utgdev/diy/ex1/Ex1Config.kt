package no.utgdev.diy.ex1

import no.utgdev.diy.annotations.Bean
import no.utgdev.diy.annotations.Import

@Import([Ex1Config2::class])
class Ex1Config {
    @Bean
    fun list(): List<String> {
        return emptyList()
    }

    @Bean
    fun string(): String {
        return ""
    }
}