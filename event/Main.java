package de.matga.event;

import de.matga.event.events.TEvent;

public class Main {

    //init the event registry
    public void init() {

        EventRegistry.initializeEventHandlers(this.getClass().getPackageName()/*you can also just insert a difined packed your self*/);

        //example for triggering an event
        EventRegistry.triggerEvent(new TEvent());

    }

    //execute the init methode
    public static void main(String[] args) {
        new Main().init();
    }
}