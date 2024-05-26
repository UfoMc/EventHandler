package de.matga.event.events;

import lombok.Getter;

public abstract class Event {

    private String name;

    public String getName() {

        if (this.name == null) {
            return this.getClass().getSimpleName().toLowerCase();
        }

        return name;
    }


}
