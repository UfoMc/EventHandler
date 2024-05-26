package de.matga.event;

import de.matga.event.events.Event;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class EventRegistry {

    //here we define our list of clases wich extend the event manager
    private static final List<EventManager> eventManagers = new ArrayList<>();

    //basic register methode where we simply add a manager to our list
    public static void register(EventManager manager) {
        eventManagers.add(manager);
    }

    //that mathode is used to trigger our event for every event manager
    public static void triggerEvent(Event event) {
        for (EventManager manager : eventManagers) {
            manager.triggerEvent(event.getName(), event);
        }
    }

    public static void initializeEventHandlers(String packageName) {
        //here we loop through the set of Event Manager extending classes using Reflection and register them all to the list
        for (Class<? extends EventManager> clazz : new Reflections(packageName).getSubTypesOf(EventManager.class)) {
            try {
                //now we register the classes to the with creating a new instance of them
                register(clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
