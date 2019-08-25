package no.utgdev.diy;

// TODO Oppgave 2
@SuppressWarnings("ALL")
public class DIY {

    public static DIY getInstance() {
        return getInstance(false);
    }

    public static void reset() {
        getInstance(true);
    }

    public static DIY getInstance(boolean refresh) {
        return null;
    }


    public static void load(String classPath) {

    }

    public static void load(Class<?> root) {
    }

    public static Object getBean(String name) {
        return null;
    }
}
