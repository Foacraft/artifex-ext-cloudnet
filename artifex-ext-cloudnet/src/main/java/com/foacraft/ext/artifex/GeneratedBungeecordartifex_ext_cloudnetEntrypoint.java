package com.foacraft.ext.artifex;

import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;
import net.md_5.bungee.api.plugin.Plugin;

public class GeneratedBungeecordartifex_ext_cloudnetEntrypoint extends Plugin {
  public GeneratedBungeecordartifex_ext_cloudnetEntrypoint() {
  }

  @Override
  public void onEnable() {
    PlatformInjectSupportLoader.loadPlugin("bungeecord", BungeeArtifexCloudnetExt.class, this, this.getClass().getClassLoader().getParent());
  }

  @Override
  public void onDisable() {
    PlatformInjectSupportLoader.disablePlugin("bungeecord", this);
  }
}
