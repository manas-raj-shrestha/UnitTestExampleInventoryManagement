package com.leapfrog.inventorymanagementsystem.events;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * A singleton instance of Otto Event bus to act as common Bus for entire application
 */
public class EventBus {

    private static Bus eventBus;

    private static Bus getBus() {
        if (eventBus == null) {
            eventBus = new Bus(ThreadEnforcer.MAIN);
        }

        return eventBus;
    }

    /**
     * Wrapper method to register event
     */
    public static void register(Object event) {
        getBus().register(event);
    }

    /**
     * Wrapper method to unregister event
     */
    public static void unregister(Object event) {
        getBus().unregister(event);
    }

    /**
     * Wrapper method to post event
     */
    public static void post(Object event) {
        getBus().post(event);
    }
}
