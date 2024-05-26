package de.matga.event;

import de.matga.event.events.TEvent;

/*
/    This is a simple class used to demonstrate the usage of the EventHandlers
*/

public class TestEvent extends EventManager {

    @EventHandler
    public void handle(TEvent event) {
        event.helloWorld();
    }

}
