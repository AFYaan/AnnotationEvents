package pl.afyaan.annotationevents;

import pl.afyaan.annotationevents.event.EventHandler;
import pl.afyaan.annotationevents.event.Listener;

@Listener
public class TestListener {

    @EventHandler
    public void onTest(TestEvent e){
        System.out.println(e.getTestValue());
        e.setCancelled(true);
    }
}
