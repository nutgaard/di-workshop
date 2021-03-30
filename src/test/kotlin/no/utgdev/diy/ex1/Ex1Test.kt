package no.utgdev.diy.ex1

import no.utgdev.diy.BeanDefinition
import no.utgdev.diy.DIYStatic.scan
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions
import java.lang.reflect.Method
import java.util.stream.Collectors

internal class Ex1Test {
    @Test
    fun finnAlleBeans() {
        val methods = methodNames(scan("no.utgdev.diy.ex1"))
        Assertions.assertThat(methods).hasSize(4)
        Assertions.assertThat(methods).containsExactlyInAnyOrder("number", "string", "list", "map")
    }

    @Test
    fun finnAlleBeansFraRoot() {
        val methods = methodNames(scan(Ex1Config::class.java))
        Assertions.assertThat(methods).hasSize(4)
        Assertions.assertThat(methods).containsExactlyInAnyOrder("number", "string", "list", "map")
    }

    companion object {
        private fun methodNames(methods: Set<BeanDefinition>): List<String> {
            return methods
                .stream()
                .map { obj -> obj.name }
                .collect(Collectors.toList())
        }
    }
}