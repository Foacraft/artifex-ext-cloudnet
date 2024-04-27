package com.foacraft.ext.artifex;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.proxy.ProxyServer;
import eu.cloudnetservice.ext.platforminject.api.mapping.PlatformedContainer;
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;

public class GeneratedVelocityartifex_ext_cloudnetEntrypoint {
  private final PlatformedContainer data;

  @Inject
  public GeneratedVelocityartifex_ext_cloudnetEntrypoint(PluginContainer container,
      ProxyServer proxy) {
    this.data = new PlatformedContainer(this, container, proxy);
  }

  @Subscribe
  public void handleProxyInit(ProxyInitializeEvent event) {
    PlatformInjectSupportLoader.loadPlugin("velocity", VelocityArtifexCloudnetExt.class, this.data, this.getClass().getClassLoader().getParent());
  }

  @Subscribe
  public void handleProxyShutdown(ProxyShutdownEvent event) {
    PlatformInjectSupportLoader.disablePlugin("velocity", this.data);
  }
}
