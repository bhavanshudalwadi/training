package com.example.demo.advanceSessionManagement;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(urlPatterns = "/*",asyncSupported = true)
public class MaxSessionsFilter implements Filter {

    private static final int MAX_SESSIONS_PER_USER = 2; // Adjust this value as needed
    private Map<String, Integer> activeSessionsPerUser = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Check if it's an HTTP request and if it has a session
        if (httpRequest.getSession(false) != null) {
            String username = getUsernameFromSession(httpRequest.getSession());

            if (username != null) {
                int activeSessions = getActiveSessionsForUser(username);

                if (activeSessions >= MAX_SESSIONS_PER_USER) {
                    // Too many active sessions for the user
                    // You may want to redirect to an error page or perform other actions
                    request.getRequestDispatcher("/sessionLimitExceeded.jsp").forward(request, response);
                    return;
                } else {
                    // Increment the active sessions count for the user
                    setActiveSessionsForUser(username, activeSessions + 1);
                }
            }
        }

        // Continue with the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    private String getUsernameFromSession(HttpSession session) {
        // Retrieve the username from the session attribute
        return (String) session.getAttribute("user");
    }

    private int getActiveSessionsForUser(String username) {
        // Get the active sessions count for the user
        return activeSessionsPerUser.getOrDefault(username, 0);
    }

    private void setActiveSessionsForUser(String username, int activeSessions) {
        // Set the active sessions count for the user
        activeSessionsPerUser.put(username, activeSessions);
    }
}