package no.utgdev.diy.ex3

//REMOVE import no.utgdev.diy.annotations.Bean;
//REMOVE import no.utgdev.diy.annotations.Import;

//REMOVE @Import([Ex3Config2::class])
class Ex3Config {
    //REMOVE @Bean
    fun controller(): Controller {
        return Controller()
    }

    //REMOVE @Bean
    fun helloDao(): HelloDao {
        return HelloDao()
    }
}