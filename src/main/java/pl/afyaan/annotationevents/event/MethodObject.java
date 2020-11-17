package pl.afyaan.annotationevents.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodObject {
    private Class<?> clazz;
    private Method method;

    public MethodObject(Class<?> clazz, Method method) {
        this.clazz = clazz;
        this.method = method;
    }

    public void invokeMethod(Event event){
        try {
            this.method.invoke(this.clazz.newInstance(), event);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException();
        }
    }

    public Method getMethod() {
        return method;
    }
}
