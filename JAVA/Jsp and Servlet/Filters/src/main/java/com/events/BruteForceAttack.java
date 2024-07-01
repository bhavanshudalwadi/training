package com.events;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class BruteForceAttack implements HttpSessionListener {

	private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final long BLOCK_DURATION = 5 * 60 * 1000;
	
    public static void registerLoginAttempt(HttpSession session) {
        Integer loginAttempts = (Integer) session.getAttribute("loginAttempts");

        if (loginAttempts == null) {
            session.setAttribute("loginAttempts", 1);
        } else {
            session.setAttribute("loginAttempts", loginAttempts + 1);

            if (loginAttempts + 1 >= MAX_LOGIN_ATTEMPTS) 
                blockSession(session);
        }
    }
    
	private static void blockSession(HttpSession session) {
	    session.setAttribute("blocked", true);
	    session.setMaxInactiveInterval((int) BLOCK_DURATION / 1000);
	}
	
	public static boolean isSessionBlocked(HttpSession session) {
	    return session.getAttribute("blocked") != null && (boolean) session.getAttribute("blocked");
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
