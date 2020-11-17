package pl.afyaan.annotationevents;

import pl.afyaan.annotationevents.event.EventManager;

public class Example {
    private static EventManager eventManager;

    public static void main(String[] args) {

        eventManager = new EventManager(Example.class.getPackage().getName());
        TestEvent testEvent = new TestEvent("TestValue");

        eventManager.callEvent(testEvent);


        if(testEvent.inCancelled()){
            System.out.println("Event cancelled");
        }else {
            System.out.println("Event has not been canceled");
        }
    }
}
