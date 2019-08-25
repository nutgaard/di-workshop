package no.utgdev.diy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

// TODO Oppgave 3.2
@Retention(value = RUNTIME)
@Target(value = {ElementType.TYPE})
@Component
public @interface Service {
    String value() default "";
}