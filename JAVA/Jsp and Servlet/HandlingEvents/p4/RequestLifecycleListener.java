package com.example.servletdemo.handlingEvents.p4;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class RequestLifecycleListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // Called when a request is initialized
        System.out.println("Request initialized. Request URI: " + sre.getServletRequest());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // Called when a request is about to be destroyed
        System.out.println("Request destroyed. Request URI: " + sre.getServletRequest());
    }
}