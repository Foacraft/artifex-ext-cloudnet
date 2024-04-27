package com.foacraft.ext.artifex;

import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class GeneratedBukkitartifex_ext_cloudnetEntrypoint extends JavaPlugin {
  public GeneratedBukkitartifex_ext_cloudnetEntrypoint() {
  }

  @Override
  public void onEnable() {
    PlatformInjectSupportLoader.loadPlugin("bukkit", BukkitArtifexCloudnetExt.class, this, this.getClass().getClassLoader().getParent());
  }

  @Override
  public void onDisable() {
    PlatformInjectSupportLoader.disablePlugin("bukkit", this);
  }
}
