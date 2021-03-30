package no.utgdev.diy.annotations

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.FUNCTION])
annotation class PostConstruct()
