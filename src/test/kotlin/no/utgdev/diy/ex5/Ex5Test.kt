package no.utgdev.diy.ex5

import no.utgdev.diy.DIY
import no.utgdev.diy.DIY.Companion.getBean
import no.utgdev.diy.DIY.Companion.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Ex5Test {
    @BeforeEach
    fun reset() {
        DIY.reset()
    }

    @Test
    fun run() {
        load(Ex5Config::class.java)
        val controller = getBean("min-controller") as Controller?
        Assertions.assertThat(controller).isNotNull
        Assertions.assertThat(controller!!.helloWorld()).isEqualTo("Greetings")
    }

    @Test
    fun run2() {
        load(Ex5Config::class.java)
        val controller = getBean("min-controller2") as Controller?
        Assertions.assertThat(controller).isNotNull
        Assertions.assertThat(controller!!.helloWorld()).isEqualTo("Welcome")
    }
}