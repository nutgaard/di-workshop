package no.utgdev.diy.ex1

//REMOVE import no.utgdev.diy.annotations.Bean
//REMOVE import no.utgdev.diy.annotations.Import

//REMOVE @Import([Ex1Config2::class])
class Ex1Config {
    //REMOVE @Bean
    fun list(): List<String> {
        return emptyList()
    }

    //REMOVE @Bean
    fun string(): String {
        return ""
    }
}