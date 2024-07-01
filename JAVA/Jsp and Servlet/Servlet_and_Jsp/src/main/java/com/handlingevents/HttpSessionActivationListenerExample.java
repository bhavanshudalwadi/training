package com.handlingevents;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class HttpSessionActivationListenerExample implements HttpSessionActivationListener, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("Session with ID " + se.getSession().getId() + " will be passivated.");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("Session with ID " + se.getSession().getId() + " has been activated.");
    }
}
