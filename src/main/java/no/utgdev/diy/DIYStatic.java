package no.utgdev.diy;

import no.utgdev.diy.annotations.*;
import no.utgdev.diy.utils.Pair;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static no.utgdev.diy.utils.FnUtils.sneakyThrow;
import static org.reflections.ReflectionUtils.withAnnotation;

@SuppressWarnings("ALL")
public class DIYStatic {
    // TODO Oppgave 1.2.1
    public static Set<BeanDefinition> scan(String classpath) {
        Reflections reflections = new Reflections("no.utgdev.diy.annotations", classpath, new MethodAnnotationsScanner(), new TypeAnnotationsScanner(), new SubTypesScanner());
        Stream<BeanDefinition> types = reflections.getTypesAnnotatedWith(Component.class, false)
                .stream()
                .filter((cls) -> !cls.isAnnotation())
                .map(BeanDefinition.FromClass::new);
        Stream<BeanDefinition> methods = reflections.getMethodsAnnotatedWith(Bean.class)
                .stream()
                .map(BeanDefinition.FromMethod::new);

        return Stream.concat(types, methods)
                .collect(toSet());
    }


    // TODO Oppgave 1.2.2
    public static Set<BeanDefinition> scan(Class<?> root) {
        return recursiveScan(root, new HashSet<>())
                .stream()
                .flatMap(DIYStatic::load)
                .map((method) -> new BeanDefinition.FromMethod(method))
                .collect(toSet());
    }

    // TODO Oppgave 1.2.2
    private static Set<Class<?>> recursiveScan(Class<?> cls, Set<Class<?>> set) {
        set.add(cls);

        Import annotation = cls.getAnnotation(Import.class);
        if (annotation != null) {
            Stream.of(annotation.value()).forEach((imp) -> recursiveScan(imp, set));
        }

        return set;
    }

    // TODO Oppgave 1.2.2
    private static Stream<Method> load(Class<?> cls) {
        return ReflectionUtils.getAllMethods(cls, withAnnotation(Bean.class)).stream();
    }

    // TODO Oppgave 1.3
    public static Map<String, Object> instansiate(Set<BeanDefinition> beans) {
        return beans
                .stream()
                .map(DIYStatic::instansiate)
                .collect(Collectors.toMap(Pair::getS, Pair::getT));
    }

    // TODO Oppgave 1.3
    private static Pair<String, Object> instansiate(BeanDefinition bean) {
        try {
            String name = bean.getName();
            Object obj = bean.getObject();
            return new Pair<>(name, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // TODO Oppgave 1.4
    public static void wireup(Map<String, Object> namedObjects) {
        namedObjects
                .values()
                .forEach((obj) -> ReflectionUtils.getAllFields(obj.getClass(), withAnnotation(Inject.class))
                        .forEach(sneakyThrow((field) -> {
                            Object wantedValue = getObject(namedObjects, field);
                            field.setAccessible(true);
                            field.set(obj, wantedValue);
                        }))
                );
    }

    private static Object getObject(Map<String, Object> namedObjects, Field field) {
        Named named = field.getAnnotation(Named.class);
        if (named != null) {
            return namedObjects.get(named.value());
        }

        return namedObjects
                .values()
                .stream()
                .filter((object) -> object.getClass().isAssignableFrom(field.getType()))
                .findFirst()
                .orElse(null);
    }

    // TODO Oppgave 1.5
    public static Object getBean(Map<String, Object> objects, String name) {
        return objects.get(name);
    }
}