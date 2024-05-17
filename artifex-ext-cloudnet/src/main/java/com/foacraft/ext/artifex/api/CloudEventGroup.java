package com.foacraft.ext.artifex.api;

import eu.cloudnetservice.driver.event.EventManager;
import eu.cloudnetservice.driver.inject.InjectionLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * artifex-ext-cloudnet
 * com.foacraft.ext.artifex.api.CloudEventHelper
 *
 * @author scorez
 * @since 5/18/24 01:14.
 */
public class CloudEventGroup {

    private static final EventManager eventManager = InjectionLayer.ext().instance(EventManager.class);

    private final List<CloudEventInject<?>> injects = new ArrayList<>();

    public <E> void on(Consumer<E> exec) {
        var injector = new CloudEventInject<>(exec);
        eventManager.registerListener(injector);
        injects.add(injector);
    }

    public void unregisters() {
        injects.forEach(eventManager::unregisterListener);
        injects.clear();
    }

}
