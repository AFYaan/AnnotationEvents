package pl.afyaan.annotationevents.event;

public interface Cancellable {
    boolean inCancelled();

    void setCancelled(boolean cancel);
}
