package no.utgdev.diy.ex5

import no.utgdev.diy.annotations.Bean;

class Ex5Config {
    @Bean(name = "min-controller")
    fun controller(): Controller1 {
        return Controller1()
    }

    @Bean(name = "min-controller2")
    fun controller2(): Controller2 {
        return Controller2()
    }

    @Bean(name = "hello-dao")
    fun helloDao(): HelloDao {
        return HelloDao("Greetings")
    }

    @Bean(name = "hello-dao2")
    fun helloDao2(): HelloDao {
        return HelloDao("Welcome")
    }
}