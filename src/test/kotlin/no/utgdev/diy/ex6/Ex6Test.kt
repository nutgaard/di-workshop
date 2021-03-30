package no.utgdev.diy.ex6

import no.utgdev.diy.DIY
import no.utgdev.diy.DIY.Companion.getBean
import no.utgdev.diy.DIY.Companion.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Ex6Test {
    @BeforeEach
    fun reset() {
        DIY.reset()
    }

    @Test
    fun run() {
        load("no.utgdev.diy.ex6")
        val controller = getBean("MinComponent") as MinComponent?
        Assertions.assertThat(controller).isNotNull
        Assertions.assertThat(controller!!.hei()).isEqualTo("Hei fra MinComponent og MinService")
    }
}