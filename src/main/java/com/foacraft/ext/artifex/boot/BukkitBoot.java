package com.foacraft.ext.artifex.boot;

import com.foacraft.ext.artifex.BukkitArtifexCloudnetExt;
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitBoot extends JavaPlugin {
  public BukkitBoot() {
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
