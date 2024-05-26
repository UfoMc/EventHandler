package de.matga.event;

import de.matga.event.events.Event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class EventManager {
    //this is a map of all event handlers in every class that extends this.
    private final Map<String, Method> eventHandlers = new HashMap<>();

    public EventManager() {
        //EventRegistry.register(this);
        registerEventHandlers();
    }

    //that is basically the init methode for Event Managers
    private void registerEventHandlers() {
        //with this we declare every methode beeing used in the class extending this. And loop them
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            //if the annotation EventHandler is above them we go on;
            if (method.isAnnotationPresent(EventHandler.class)) {

                final String eventName;

                //here we are searching for
                if (method.getParameterTypes().length == 1){
                    //here we look if the 1. parameter given in the methode extends Event.class
                    if (!Event.class.isAssignableFrom(method.getParameterTypes()[0])){
                        continue;
                    }

                    eventName = method.getParameterTypes()[0].getSimpleName().toLowerCase();
                } else {
                    continue;
                }

                //here we define our event to our map
                eventHandlers.put(eventName, method);
            }
        }
    }

    public void triggerEvent(String eventName, Object event) {
        //here we get our earlyer defined methode from the map
        Method method = eventHandlers.get(eventName);
        if (method != null) {
            try {
                //invoke the methode
                method.invoke(this, event);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
