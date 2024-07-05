package com.aril;

import com.aril.interfaces.MailInterface;
import com.aril.plugin.ArilPluginManager;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;

/**
 * Hello world!
 */
@Slf4j
public class App {

    private static final Path PLUGIN_PATH = Paths.get(URI.create("file:///C:/Users/YusufOnder/IdeaProjects/pf4j-poc/main-app/src/main/resources/plugins"));

    public static void main(String[] args) {
        final PluginManager pm = new ArilPluginManager(PLUGIN_PATH);

        pm.loadPlugins();

        pm.startPlugins();

        final List<MailInterface> plugins = pm.getExtensions(MailInterface.class);
        log.info(MessageFormat.format(" {0} Plugin(s) found ", String.valueOf(plugins.size())));

        plugins.forEach(g ->
                log.info(MessageFormat.format(" {0}: {1}",
                        g.getClass().getCanonicalName(),
                        g.identify())));

        pm.stopPlugins();
    }
}
