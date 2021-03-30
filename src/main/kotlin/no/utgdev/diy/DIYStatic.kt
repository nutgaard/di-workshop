package no.utgdev.diy

import java.lang.reflect.Method

object DIYStatic {
    @JvmStatic
    fun scan(classpath: String): Set<Method> {
        TODO("Oppgave 1.2.1")
    }

    @JvmStatic
    fun scan(root: Class<*>): Set<Method> {
        TODO("Oppgave 1.2.2")
    }

    @JvmStatic
    fun instansiate(beans: Set<Method>): Map<String, Any> {
        TODO("Oppgave 1.3")
    }

    @JvmStatic
    fun wireup(namedObjects: Map<String, Any?>) {
        TODO("Oppgave 1.4")
    }

    @JvmStatic
    fun getBean(objects: Map<String, Any?>, name: String): Any? {
        TODO("Oppgave 1.5")
    }
}