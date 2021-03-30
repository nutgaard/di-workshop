package no.utgdev.diy.annotations

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.FIELD])
annotation class Inject()
