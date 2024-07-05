package com.aril.interfaces;

import org.pf4j.ExtensionPoint;

/**
 * Interface for authentication.
 */
public interface AuthInterface extends ExtensionPoint {

    String identify();
    boolean authenticate(String username, String password);
    boolean authorize(String username, String role);
}
