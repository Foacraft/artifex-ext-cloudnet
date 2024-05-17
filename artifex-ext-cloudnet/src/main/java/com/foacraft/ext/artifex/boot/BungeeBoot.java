package com.foacraft.ext.artifex.boot;

import com.foacraft.ext.artifex.BungeeArtifexCloudnetExt;
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeBoot extends Plugin {
  public BungeeBoot() {
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
