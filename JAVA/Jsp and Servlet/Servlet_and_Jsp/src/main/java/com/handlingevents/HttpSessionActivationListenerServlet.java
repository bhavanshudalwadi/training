package com.handlingevents;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionActivationListenerServlet")
public class HttpSessionActivationListenerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        HttpSessionActivationListenerExample sampleActivationListener = new HttpSessionActivationListenerExample();
        session.setAttribute("activationListener", sampleActivationListener);

        session.setAttribute("sampleAttribute", "Hello, HttpSessionActivationListener!");

        session.invalidate();

        response.getWriter().println("Check the console for activation and passivation notifications.");
    }
}
