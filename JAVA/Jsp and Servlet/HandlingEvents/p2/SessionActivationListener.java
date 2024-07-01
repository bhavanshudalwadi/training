package com.example.servletdemo.handlingEvents.p2;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

@WebListener
public class SessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("Session will be passivated. Session ID: " + se.getSession().getId());
        // Perform tasks before session passivation (serialization)
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("Session activated. Session ID: " + se.getSession().getId());
        // Perform tasks after session activation (deserialization)
    }
}
