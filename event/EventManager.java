package de.matga.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class EventManager {
    private final Map<String, Method> eventHandlers = new HashMap<>();

    public EventManager() {
        //EventRegistry.register(this);
        registerEventHandlers();
    }

    private void registerEventHandlers() {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(EventHandler.class)) {

                //String eventName = method.getParameterTypes().length == 1 ? method.getParameterTypes()[0].getName().toLowerCase() : continue;

                String eventName;

                if (method.getParameterTypes().length == 1){
                    eventName = method.getParameterTypes()[0].getSimpleName().toLowerCase();
                } else {
                    continue;
                }

                eventHandlers.put(eventName, method);
            }
        }
    }

    public void triggerEvent(String eventName, Object event) {
        Method method = eventHandlers.get(eventName);
        if (method != null) {
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isInstance(event)) {
                    method.invoke(this, event);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
