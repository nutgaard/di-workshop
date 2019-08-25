package no.utgdev.diy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("ALL")
public class DIYStatic {
    // TODO Oppgave 1.2.1
    public static Set<Method> scan(String classpath) {
        return new HashSet<>();
    }


    // TODO Oppgave 1.2.2
    public static Set<Method> scan(Class<?> root) {
        return new HashSet<>();
    }

    // TODO Oppgave 1.3
    public static Map<String, Object> instansiate(Set<Method> beans) {
        return new HashMap<>();
    }

    // TODO Oppgave 1.4
    public static void wireup(Map<String, Object> namedObjects) {

    }

    // TODO Oppgave 1.5
    public static Object getBean(Map<String, Object> objects, String name) {
        return null;
    }
}
