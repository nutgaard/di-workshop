package no.utgdev.diy

import no.utgdev.diy.annotations.Bean
import java.lang.reflect.Method

sealed class BeanDefinition {
    abstract val name: String
    abstract val value: Any

    class FromMethod(private val method: Method) : BeanDefinition() {
        override val name: String get() {
            val annotation: Bean? = method.getAnnotation(Bean::class.java)
            return if (annotation != null && annotation.name.isNotBlank()) {
                annotation.name
            } else {
                method.name
            }
        }

        override val value: Any get() {
            val instance = method.declaringClass.getDeclaredConstructor().newInstance()
            return method.invoke(instance)
        }

    }

    class FromClass(private val cls: Class<*>) : BeanDefinition() {
        override val name: String get() = cls.simpleName
        override val value: Any get() = cls.getDeclaredConstructor().newInstance()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BeanDefinition) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode() = name.hashCode()
}