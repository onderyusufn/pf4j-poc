package com.aril.interfaces;

import org.pf4j.ExtensionPoint;

/**
 * Interface for sending mail.
 */
public interface MailInterface extends ExtensionPoint {
    String identify();
    void sendMail(String from, String to, String subject, String body);
}
