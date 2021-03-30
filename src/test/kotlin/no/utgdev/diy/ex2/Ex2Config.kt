package no.utgdev.diy.ex2

//REMOVE import no.utgdev.diy.annotations.Bean;
//REMOVE import no.utgdev.diy.annotations.Import;

//REMOVE @Import([Ex2Config2::class])
class Ex2Config {
    //REMOVE @Bean
    fun list(): List<String> {
        return emptyList()
    }

    //REMOVE @Bean
    fun string(): String {
        return ""
    }
}