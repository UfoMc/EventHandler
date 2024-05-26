package de.matga.event;

import de.matga.event.events.Event;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventRegistry {

    private static final List<EventManager> eventManagers = new ArrayList<>();

    public static void register(EventManager manager) {
        System.out.println("new manager added");
        eventManagers.add(manager);
    }

    public static void triggerEvent(String eventName, Event event) {
        for (EventManager manager : eventManagers) {
            manager.triggerEvent(eventName, event);
        }
    }

    public static void initializeEventHandlers(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends EventManager>> classes = reflections.getSubTypesOf(EventManager.class);
        for (Class<? extends EventManager> clazz : classes) {
            try {
                EventManager manager = clazz.getDeclaredConstructor().newInstance();
                register(manager);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}
