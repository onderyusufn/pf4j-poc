package com.aril;

import com.aril.interfaces.AuthInterface;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.Extension;
import org.pf4j.Plugin;

/**
 * Auth Plugin.
 */
@Slf4j
public class AuthPlugin extends Plugin {

    @Override
    public void start() {
        log.info("Auth Plugin Started");
    }

    @Override
    public void stop() {
        log.info("Auth Plugin Stopped");
    }

    /**
     * AuthInterface implementation.
     */
    @Extension
    public static class AuthInterfaceImpl implements AuthInterface {
        @Override
        public String identify() {
            return "AuthInterfaceImpl";
        }

        @Override
        public boolean authenticate(String username, String password) {
            log.info("AuthPlugin: Authenticating user: {}", username);
            return true;
        }

        @Override
        public boolean authorize(String username, String role) {
            log.info("AuthPlugin: Authorizing user: {}", username);
            return true;
        }
    }

}
