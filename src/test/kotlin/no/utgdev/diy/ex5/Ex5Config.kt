package no.utgdev.diy.ex5

//REMOVE import no.utgdev.diy.annotations.Bean;

class Ex5Config {
    //REMOVE @Bean(name = "min-controller")
    fun controller(): Controller1 {
        return Controller1()
    }

    //REMOVE @Bean(name = "min-controller2")
    fun controller2(): Controller2 {
        return Controller2()
    }

    //REMOVE @Bean(name = "hello-dao")
    fun helloDao(): HelloDao {
        return HelloDao("Greetings")
    }

    //REMOVE @Bean(name = "hello-dao2")
    fun helloDao2(): HelloDao {
        return HelloDao("Welcome")
    }
}