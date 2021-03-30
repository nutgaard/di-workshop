package no.utgdev.diy

import no.utgdev.diy.annotations.Bean
import no.utgdev.diy.annotations.Import
import no.utgdev.diy.annotations.Inject
import org.reflections.ReflectionUtils
import org.reflections.ReflectionUtils.withAnnotation
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass

object DIYStatic {
    @JvmStatic
    fun scan(classpath: String): Set<Method> {
        val scanner = Reflections(classpath, MethodAnnotationsScanner())
        return scanner.getMethodsAnnotatedWith(Bean::class.java)
    }

    @JvmStatic
    fun scan(root: Class<*>): Set<Method> {
        val collector = mutableSetOf<KClass<*>>()
        return recursiveScan(root.kotlin, collector)
            .flatMap(DIYStatic::load)
            .toSet()
    }

    @JvmStatic
    fun instansiate(beans: Set<Method>): Map<String, Any> {
        return beans
            .map { method ->
                val classInstance = method.declaringClass.getDeclaredConstructor().newInstance()
                method.name to method.invoke(classInstance)
            }
            .toMap()
    }

    @JvmStatic
    fun wireup(namedObjects: Map<String, Any?>) {
        namedObjects
            .values
            .filterNotNull()
            .flatMap { cls ->
                ReflectionUtils
                    .getAllFields(cls.javaClass, withAnnotation(Inject::class.java))
                    .map { field -> cls to field }
            }
            .map { (cls, field) ->
                val wantedValue = getObject(namedObjects, field)
                field.trySetAccessible()
                field.set(cls, wantedValue)
            }
    }

    @JvmStatic
    fun getBean(objects: Map<String, Any?>, name: String): Any? {
        return objects[name]
    }

    private fun recursiveScan(root: KClass<*>, collector: MutableSet<KClass<*>>): MutableSet<KClass<*>> {
        collector.add(root)

        root.getAnnotation<Import>()
            ?.value
            ?.forEach { recursiveScan(it, collector) }

        return collector
    }

    private fun load(cls: KClass<*>): Set<Method> {
        return ReflectionUtils.getAllMethods(cls.java, withAnnotation(Bean::class.java))
    }

    private fun getObject(namedObjects: Map<String, Any?>, field: Field): Any? {
        return namedObjects
            .values
            .filterNotNull()
            .find { value -> value::class.java.isAssignableFrom(field.type) }
    }

    private inline fun <reified T : Any> KClass<*>.getAnnotation(): T? {
        return this.annotations.find { it is T } as? T
    }
}