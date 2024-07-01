package com.handlingevents;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListenerExample implements ServletRequestListener {
	@Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request initialized. Request URI: " + sre.getServletRequest());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request destroyed. Request URI: " + sre.getServletRequest());
    }
}
