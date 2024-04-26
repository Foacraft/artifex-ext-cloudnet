package com.foacraft.ext.artifex;

import eu.cloudnetservice.driver.event.EventManager;
import eu.cloudnetservice.driver.module.ModuleLifeCycle;
import eu.cloudnetservice.driver.module.ModuleTask;
import eu.cloudnetservice.driver.module.driver.DriverModule;
import eu.cloudnetservice.driver.util.ModuleHelper;
import eu.cloudnetservice.node.module.listener.PluginIncludeListener;
import jakarta.inject.Singleton;

@Singleton
public final class ArtifexCloudnetExt extends DriverModule {

    @ModuleTask(order = 64, lifecycle = ModuleLifeCycle.LOADED)
    public void initListeners(
        EventManager eventManager,
        ModuleHelper moduleHelper
    ) {
        eventManager.registerListener(new PluginIncludeListener(
            "artifex-ext-cloudnet",
            getClass(),
            moduleHelper,
            service -> true
        ));
    }
}
