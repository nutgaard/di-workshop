package no.utgdev.diy;

import no.utgdev.diy.annotations.Bean;

import java.lang.reflect.Method;

public abstract class BeanDefinition {

    public abstract String getName();
    public abstract Object getObject() throws Exception;


    static class FromMethod extends BeanDefinition {
        private final Method method;

        public FromMethod(Method method) {
            this.method = method;
        }

        @Override
        public String getName() {
            Bean annotation = method.getAnnotation(Bean.class);
            if (annotation != null && annotation.name().length() > 0) {
                return annotation.name();
            }
            return method.getName();
        }

        @Override
        public Object getObject() throws Exception {
            Object obj = method.getDeclaringClass().newInstance();
            return method.invoke(obj);
        }
    }

    static class FromClass extends BeanDefinition {
        private final Class<?> type;

        public FromClass(Class<?> type) {
            this.type = type;
        }

        @Override
        public String getName() {
            return type.getSimpleName();
        }

        @Override
        public Object getObject() throws Exception {
            return type.newInstance();
        }
    }
}