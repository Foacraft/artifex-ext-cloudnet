package com.foacraft.ext.artifex;

import eu.cloudnetservice.ext.platforminject.api.PlatformEntrypoint;
import eu.cloudnetservice.ext.platforminject.api.stereotype.Dependency;
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;
import jakarta.inject.Singleton;
import eu.cloudnetservice.ext.platforminject.api.stereotype.PlatformPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * artifex-ext-cloudnet
 * com.foacraft.ext.artifex.BukkitArtifexCloudnetExt
 *
 * @author scorez
 * @since 4/27/24 00:57.
 */
@Singleton
@PlatformPlugin(
    platform = "bukkit",
    name = "@project_name@",
    version = "@project_version@",
    authors = {"Score2"},
    dependencies = {@Dependency(name = "CloudNet-Bridge")}
)
public class BukkitArtifexCloudnetExt implements PlatformEntrypoint {

    private static final String PLATFORM = "bukkit";
    private static final ArtifexPlugin ARTIFEX_PLUGIN = new ArtifexPlugin();

    @Override
    public void onLoad() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Artifex");
        if (plugin == null) {
            return;
        }
        PlatformInjectSupportLoader.loadPlugin(
            PLATFORM,
            ARTIFEX_PLUGIN.getClass(),
            plugin,
            plugin.getClass().getClassLoader().getParent()
        );
    }

    @Override
    public void onDisable() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Artifex");
        if (plugin == null) {
            return;
        }
        PlatformInjectSupportLoader.disablePlugin(PLATFORM, plugin);
    }

    @Singleton
    @PlatformPlugin(
        platform = PLATFORM,
        name = "Artifex",
        version = "1.0.0",
        authors = {"Bkm016"}
    )
    public static class ArtifexPlugin implements PlatformEntrypoint {
    }
}
