package no.utgdev.diy.ex3

import no.utgdev.diy.DIYStatic.instansiate
import no.utgdev.diy.DIYStatic.wireup
import no.utgdev.diy.DIYStatic.getBean
import org.junit.jupiter.api.Test
import no.utgdev.diy.DIYStatic
import org.assertj.core.api.Assertions
import java.lang.reflect.Method

internal class Ex3Test {
    @Test
    fun wireup() {
        val methods: Set<Method> = DIYStatic.scan(Ex3Config::class.java)
        val objects: Map<String, Any?> = instansiate(methods)
        wireup(objects)
        val controller = getBean(objects, "controller") as Controller?
        Assertions.assertThat(controller).isNotNull
        Assertions.assertThat(controller!!.helloWorld()).isEqualTo("Hello, World")
    }
}