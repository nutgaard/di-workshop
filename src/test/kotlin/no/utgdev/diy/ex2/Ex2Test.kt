package no.utgdev.diy.ex2

import no.utgdev.diy.BeanDefinition
import no.utgdev.diy.DIYStatic
import no.utgdev.diy.DIYStatic.instansiate
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Ex2Test {
    @Test
    fun instansiate() {
        val methods: Set<BeanDefinition> = DIYStatic.scan(Ex2Config::class.java)
        val objects = instansiate(methods)
        Assertions.assertThat(objects).hasSize(4)
        Assertions.assertThat(objects["number"]).isEqualTo(2.0)
        Assertions.assertThat(objects["string"]).isEqualTo("")
        Assertions.assertThat(objects["list"]).isEqualTo(emptyList<Any>())
        Assertions.assertThat(objects["map"]).isEqualTo(emptyMap<Any, Any>())
    }
}