package com.handlingfilters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Filter implementation class ValidationSanitizationFilter
 */
@WebFilter("/Pr4")
public class ValidationSanitizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter initialization code here, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Wrap the request with a custom HttpServletRequestWrapper to validate and sanitize parameters
        HttpServletRequestWrapper sanitizedRequest = new HttpServletRequestWrapper(httpRequest) {
            @Override
            public String getParameter(String name) {
                // Validate and sanitize parameter
            	
                String value = request.getParameter(name);
                return sanitize(value);
            }

            @Override
            public String[] getParameterValues(String name) {
                String[] values = super.getParameterValues(name);
                if (values == null) return null;
                int count = values.length;
                String[] sanitizedValues = new String[count];
                for (int i = 0; i < count; i++) {
                    sanitizedValues[i] = sanitize(values[i]);
                }
                return sanitizedValues;
            }

            @Override
            public Map<String, String[]> getParameterMap() {
                Map<String, String[]> sanitizedMap = new HashMap<>();
                Map<String, String[]> parameterMap = super.getParameterMap();
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    String[] sanitizedValues = new String[entry.getValue().length];
                    for (int i = 0; i < entry.getValue().length; i++) {
                        sanitizedValues[i] = sanitize(entry.getValue()[i]);
                    }
                    sanitizedMap.put(entry.getKey(), sanitizedValues);
                }
                return sanitizedMap;
            }
        };

        chain.doFilter(sanitizedRequest, response);
    }

    @Override
    public void destroy() {
        // Filter destruction code here, if needed
    }

    // Implement your sanitization logic here. This is a basic example.
    private String sanitize(String value) {
        if (value == null) return null;
        // Replace script tags and escape HTML entities to mitigate XSS attacks
        return value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}