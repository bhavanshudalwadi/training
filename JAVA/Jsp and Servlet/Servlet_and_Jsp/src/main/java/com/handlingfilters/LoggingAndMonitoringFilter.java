package com.handlingfilters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingAndMonitoringFilter
 */
@WebFilter("/Pr1")
public class LoggingAndMonitoringFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoggingAndMonitoringFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		long startTime = System.currentTimeMillis();

        // Cast the ServletRequest to HttpServletRequest to work with HTTP-specific features
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("Request Logged: " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());

        chain.doFilter(request, response); // Pass the request and response along the filter chain

        // Mark the time after processing the request
        long endTime = System.currentTimeMillis();

        // Log the time taken to process the request
        System.out.println("Response Logged: " + httpServletRequest.getRequestURI() + " taken " + (endTime - startTime) + " ms");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
