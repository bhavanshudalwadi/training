package com.handlingsessionattributes;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SessionValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        // Validate and sanitize session attributes
        validateAndSanitizeSessionAttributes(session);

        // Continue with the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    private void validateAndSanitizeSessionAttributes(HttpSession session) {
        // Example: Validate and sanitize a session attribute named "user_name"
        Object userNameAttribute = session.getAttribute("user_name");
        if (userNameAttribute instanceof String) {
            String userName = (String) userNameAttribute;
            // Perform validation and sanitization
            String sanitizedUserName = sanitizeUserName(userName);
            // Update the session attribute with the sanitized value
            session.setAttribute("user_name", sanitizedUserName);
        }
        // Add additional checks for other session attributes as needed
    }

    private String sanitizeUserName(String userName) {
        // Example: Sanitize the user name (replace special characters, etc.)
        // Customize this method based on your specific requirements
        return userName.replaceAll("[^a-zA-Z0-9]", "_");
    }
}
