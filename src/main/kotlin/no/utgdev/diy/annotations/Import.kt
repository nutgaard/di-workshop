package no.utgdev.diy.annotations

import kotlin.reflect.KClass

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.CLASS])
annotation class Import(
    val value: Array<KClass<*>>
)
