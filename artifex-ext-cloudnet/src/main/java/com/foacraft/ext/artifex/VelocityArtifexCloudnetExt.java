package com.foacraft.ext.artifex;

import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.proxy.ProxyServer;
import eu.cloudnetservice.ext.platforminject.api.PlatformEntrypoint;
import eu.cloudnetservice.ext.platforminject.api.mapping.PlatformedContainer;
import eu.cloudnetservice.ext.platforminject.api.stereotype.Dependency;
import eu.cloudnetservice.ext.platforminject.api.stereotype.PlatformPlugin;
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

/**
 * artifex-ext-cloudnet
 * com.foacraft.ext.artifex.BukkitArtifexCloudnetExt
 *
 * @author scorez
 * @since 4/27/24 00:57.
 */
@Singleton
@PlatformPlugin(
    platform = "velocity",
    name = "@project_name@",
    version = "@project_version@",
    authors = {"Score2"},
    dependencies = {@Dependency(name = "CloudNet-Bridge")}
)
public class VelocityArtifexCloudnetExt implements PlatformEntrypoint {

    private static final String PLATFORM = "velocity";
    private static final ArtifexPlugin ARTIFEX_PLUGIN = new ArtifexPlugin();

    private final ProxyServer proxy;
    private PlatformedContainer data;

    @Inject
    public VelocityArtifexCloudnetExt(
        ProxyServer proxyServer
    ) {
        this.proxy = proxyServer;
    }

    @Override
    public void onLoad() {
        PluginContainer plugin = proxy.getPluginManager().getPlugin("artifex").orElse(null);
        if (plugin == null) {
            return;
        }
        data = new PlatformedContainer(plugin.getInstance().get(), plugin, proxy);
        PlatformInjectSupportLoader.loadPlugin(
            PLATFORM,
            ARTIFEX_PLUGIN.getClass(),
            data,
            plugin.getClass().getClassLoader().getParent()
        );
    }

    @Override
    public void onDisable() {
        PluginContainer plugin = proxy.getPluginManager().getPlugin("artifex").orElse(null);
        if (plugin == null) {
            return;
        }
        PlatformInjectSupportLoader.disablePlugin(PLATFORM, data);
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
