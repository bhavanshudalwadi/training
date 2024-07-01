package com.handlingfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/Pr3")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter initialization code here, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	System.out.println("Filter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // This is a simplistic way to check if a user session exists and has a "user" attribute.
        // Replace this with your actual authentication logic.
        if (request.getAttribute("user") == null) {
            
        
    		System.out.println("You can't access the resource");
            return;
        }

        // If the user is authenticated, check for authorization.
        // This example assumes the user role is stored in the session. Replace with your actual authorization logic.
        String userRole = (String) request.getAttribute("role");
        if (!isAuthorized(userRole)) {
            // User does not have the required permission, redirect or send an error response
        	System.out.println("Soory not access");
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have permission to access this resource.");
            return;
        }else {
        	response.setContentType("text/html");
    		PrintWriter pw=response.getWriter();
    		System.out.println("You can access the resource");
        }

        // User is authenticated and authorized, proceed with the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Filter destruction code here, if needed
    }

    // Example method to check if a user with a specific role is authorized to access a resource.
    // Replace this with your actual authorization logic.
    private boolean isAuthorized(String userRole) {
        // Implement your authorization logic here. This could involve checking if the user's role
    	if(userRole.equals("admin")) {
    		return true;
    	}else {
    		return false;
    	}
        // has the necessary permissions to access the requested URI.
        // This is a placeholder. Return true if authorized, false otherwise.
    }
}
