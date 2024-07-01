package com.handlingsessionattributes;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListner implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logAttributeChange("Attribute Added", event);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        logAttributeChange("Attribute Removed", event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        logAttributeChange("Attribute Replaced", event);
    }

    private void logAttributeChange(String action, HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object oldValue = event.getValue();
        Object newValue = event.getSession().getAttribute(attributeName);

        System.out.println(action + ": Attribute '" + attributeName + "' changed from '" + oldValue + "' to '" + newValue + "'");
    }
}
