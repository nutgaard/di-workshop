package no.utgdev.diy

import no.utgdev.diy.annotations.*
import org.reflections.ReflectionUtils
import org.reflections.ReflectionUtils.withAnnotation
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import org.reflections.scanners.Scanner
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass

object DIYStatic {
    private val scanners: Array<Scanner> = arrayOf(
        MethodAnnotationsScanner(),
        TypeAnnotationsScanner(),
        SubTypesScanner()
    )

    @JvmStatic
    fun scan(classpath: String): Set<BeanDefinition> {
        val scanner = Reflections("no.utgdev.diy.annotations", classpath, *scanners)

        val classes = scanner.getTypesAnnotatedWith(Component::class.java)
            .filter { !it.isAnnotation }
            .map { BeanDefinition.FromClass(it) }
        val methods = scanner.getMethodsAnnotatedWith(Bean::class.java)
            .map { BeanDefinition.FromMethod(it) }

        return (classes + methods).toSet()
    }

    @JvmStatic
    fun scan(root: Class<*>): Set<BeanDefinition> {
        val collector = mutableSetOf<KClass<*>>()
        return recursiveScan(root.kotlin, collector)
            .flatMap(DIYStatic::load)
            .map { BeanDefinition.FromMethod(it) }
            .toSet()
    }

    @JvmStatic
    fun instansiate(beans: Set<BeanDefinition>): Map<String, Any> {
        return beans
            .map { bean -> bean.name to bean.value }
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

        namedObjects
            .values
            .filterNotNull()
            .forEach{ obj ->
                ReflectionUtils.getMethods(obj.javaClass, withAnnotation(PostConstruct::class.java))
                    .forEach { method ->
                        method.trySetAccessible()
                        method.invoke(obj)
                    }
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
        val named: Named? = field.getAnnotation(Named::class.java)
        if (named != null) {
            return namedObjects[named.value]
        }

        return namedObjects
            .values
            .filterNotNull()
            .find { value -> value::class.java.isAssignableFrom(field.type) }
    }

    private inline fun <reified T : Any> KClass<*>.getAnnotation(): T? {
        return this.annotations.find { it is T } as? T
    }
}