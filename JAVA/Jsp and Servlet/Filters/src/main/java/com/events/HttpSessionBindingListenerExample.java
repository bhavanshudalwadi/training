package com.events;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class HttpSessionBindingListenerExample implements HttpSessionBindingListener {

    private String attributeName;

    // Constructor to set the attribute name to be tracked
    public HttpSessionBindingListenerExample(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // This method is called when the attribute is added to the session
        System.out.println("Attribute '" + attributeName + "' added to session.");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // This method is called when the attribute is removed from the session
        System.out.println("Attribute '" + attributeName + "' removed from session.");
    }

    // Additional method to handle attribute value updates (replacement)
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute '" + attributeName + "' replaced in session.");
    }
}
