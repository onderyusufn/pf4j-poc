package com.aril;

import com.aril.interfaces.MailInterface;
import com.aril.plugin.ArilPlugin;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.Extension;
import org.pf4j.Plugin;

/**
 * Mail Plugin.
 */
@Slf4j
public class MailPlugin extends ArilPlugin {

    @Override
    public void start() {
        log.info("Mail Plugin Started");
    }

    @Override
    public void stop() {
        log.info("Mail Plugin Stopped");
    }

    @Override
    public void preProcess() {
        log.info("Mail Plugin Pre Process");
    }

    /**
     * Mail Interface Implementation.
     */
    @Extension
    public static class MailInterfaceImpl implements MailInterface {
        @Override
        public String identify() {
            return "MailInterfaceImpl";
        }

        @Override
        public void sendMail(String from, String to, String subject, String body) {
            log.info("MailPlugin: Sending mail from: {} to: {} with subject: {} and body: {}", from, to, subject, body);
        }
    }
}
