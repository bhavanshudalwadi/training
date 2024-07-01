package com.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Logout Servlet</title></head><body>");

        if (session != null) {
            session.invalidate();
            out.println("<p>Logout successful. Session invalidated.</p>");

        } else {
            out.println("<p>No active session. You are already logged out.</p>");
        }

        out.println("</body></html>");
    }
}
