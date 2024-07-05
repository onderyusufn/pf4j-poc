package com.aril.plugin;

import org.pf4j.DefaultPluginManager;

import java.nio.file.Path;

/**
 * Plugin manager for Aril plugins.
 */
public class ArilPluginManager extends DefaultPluginManager {
    public ArilPluginManager(Path... pluginsRoots) {
        super(pluginsRoots);
    }

    @Override
    public void startPlugins() {
        resolvedPlugins.forEach(pluginWrapper -> {
            if (pluginWrapper.getPlugin() instanceof ArilPlugin) {
                ((ArilPlugin) pluginWrapper.getPlugin()).preProcess();
            }
        });
        super.startPlugins();
        resolvedPlugins.forEach(pluginWrapper -> {
            if (pluginWrapper.getPlugin() instanceof ArilPlugin) {
                ((ArilPlugin) pluginWrapper.getPlugin()).postProcess();
            }
        });
    }
}
