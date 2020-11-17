package pl.afyaan.annotationevents;

import pl.afyaan.annotationevents.event.Cancellable;
import pl.afyaan.annotationevents.event.Event;

public class TestEvent extends Event implements Cancellable {
    private final String value;
    private boolean cancel;

    public TestEvent(String value) {
        this.value = value;
    }

    public String getTestValue() {
        return value;
    }

    @Override
    public boolean inCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
