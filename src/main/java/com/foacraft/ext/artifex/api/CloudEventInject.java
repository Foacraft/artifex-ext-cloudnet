package com.foacraft.ext.artifex.api;

import eu.cloudnetservice.driver.event.EventListener;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

/**
 * artifex-ext-cloudnet
 * com.foacraft.ext.artifex.api.CloudEventInject
 *
 * @author scorez
 * @since 5/18/24 01:15.
 */
@Data
@AllArgsConstructor
public class CloudEventInject<E> {

    private Consumer<E> exec;

    @EventListener
    public void e(E e) {
        exec.accept(e);
    }

}
