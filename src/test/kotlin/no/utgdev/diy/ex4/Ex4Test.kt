package no.utgdev.diy.ex4

import no.utgdev.diy.DIY
import no.utgdev.diy.DIY.Companion.getBean
import no.utgdev.diy.DIY.Companion.load
import no.utgdev.diy.ex3.Controller
import no.utgdev.diy.ex3.Ex3Config
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Ex4Test {
    @BeforeEach
    fun reset() {
        DIY.reset()
    }

    @Test
    fun run() {
        load(Ex3Config::class.java)
        val controller = getBean("controller") as Controller?
        Assertions.assertThat(controller).isNotNull
        Assertions.assertThat(controller!!.helloWorld()).isEqualTo("Hello, World")
    }
}