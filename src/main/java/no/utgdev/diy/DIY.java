package no.utgdev.diy;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// TODO Oppgave 2
@SuppressWarnings("ALL")
public class DIY {
    private static DIY instance;
    private boolean instansiated = false;
    private Set<BeanDefinition> beans = new HashSet<>();
    private Map<String, Object> objects;

    public static DIY getInstance() {
        return getInstance(false);
    }

    public static void reset() {
        getInstance(true);
    }

    public static DIY getInstance(boolean refresh) {
        if (instance == null || refresh) {
            instance = new DIY();
        }
        return instance;
    }


    public static void load(String classPath) {
        getInstance().beans.addAll(DIYStatic.scan(classPath));
    }

    public static void load(Class<?> root) {
        getInstance().beans.addAll(DIYStatic.scan(root));
    }

    public static Object getBean(String name) {
        DIY diy = getInstance();
        if (!diy.instansiated) {
            diy.objects = DIYStatic.instansiate(diy.beans);
            DIYStatic.wireup(diy.objects);
            diy.instansiated = true;
        }
        return DIYStatic.getBean(diy.objects, name);
    }
}
