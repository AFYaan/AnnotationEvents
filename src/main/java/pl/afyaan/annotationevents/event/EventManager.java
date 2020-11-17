package pl.afyaan.annotationevents.event;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventManager {
    private List<MethodObject> methods = new ArrayList<>();

    public EventManager(String path) {
        findMethods(path);
    }

    private void findMethods(String pathClass){
        Reflections reflections = new Reflections(pathClass);
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Listener.class);

        for(Class<?> clazz : classes){
            Annotation clazzAnnotation = clazz.getAnnotation(Listener.class);
            if(clazzAnnotation == null) continue;

            for(Method method : clazz.getDeclaredMethods()){
                Annotation methodAnnotation = method.getAnnotation(EventHandler.class);
                if (methodAnnotation != null) {
                    this.methods.add(new MethodObject(clazz, method));
                }
            }
        }
    }

    public void callEvent(final Event event) throws RuntimeException{
        this.methods.stream()
                .filter(method -> method.getMethod().getParameterCount() == 1)
                .filter(method -> method.getMethod().getParameterTypes()[0] == event.getClass())
                .forEach(method -> method.invokeMethod(event));
    }
}
