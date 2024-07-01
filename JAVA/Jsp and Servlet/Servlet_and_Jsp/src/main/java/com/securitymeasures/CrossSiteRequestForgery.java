package com.securitymeasures;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/CrossSiteRequestForgery")
public class CrossSiteRequestForgery implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) arg0;
        HttpServletResponse httpResponse = (HttpServletResponse) arg1;

        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            if (!isValidCsrfToken(httpRequest)) {
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
                return;
            }
        }

        arg2.doFilter(arg0, arg1);

        updateCsrfToken(httpRequest);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	private boolean isValidCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            String sessionCsrfToken = (String) session.getAttribute("csrfToken");
            
            String requestCsrfToken = request.getParameter("csrfToken");

            return sessionCsrfToken != null && sessionCsrfToken.equals(requestCsrfToken);
        }

        return false;
    }

    private void updateCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        String csrfToken = generateCsrfToken();

        session.setAttribute("csrfToken", csrfToken);

        request.setAttribute("csrfToken", csrfToken);
    }

    private String generateCsrfToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}
