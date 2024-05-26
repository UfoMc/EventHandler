package de.matga.event.events;

/*
* This file is used to extend it to your custom events. You can put what ever you want here.
* !!!THE getName() METHODE IS REQUIRED. DO NOT DELETE IT!!!
*/

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Event {

    private String name;

    public String getName() {

        if (this.name == null) {
            /*this returns the name of the class wich the methode is used in.
            /If (for example) TEvent is inizialized as an object and you do getName for it the return will be TEvent (to lower cas)
            */
            return this.getClass().getSimpleName().toLowerCase();
        }

        return name;
    }


}
