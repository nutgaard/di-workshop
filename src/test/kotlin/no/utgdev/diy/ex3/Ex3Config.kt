package no.utgdev.diy.ex3

import no.utgdev.diy.annotations.Bean;
import no.utgdev.diy.annotations.Import;

@Import([Ex3Config2::class])
class Ex3Config {
    @Bean
    fun controller(): Controller {
        return Controller()
    }

    @Bean
    fun helloDao(): HelloDao {
        return HelloDao()
    }
}