package no.utgdev.diy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

// TODO Oppgave 1.1
@Retention(value = RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface Inject {
}