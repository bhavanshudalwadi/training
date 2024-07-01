package com.example.servletdemo.handlingEvents.p2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/session-activation")
public class SessionActivationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        // Attach an object that implements HttpSessionActivationListener
        SessionActivationListener sampleActivationListener = new SessionActivationListener();
        session.setAttribute("activationListener", sampleActivationListener);

        // Set a sample attribute to the session
        session.setAttribute("sampleAttribute", "Hello, HttpSessionActivationListener!");

        // Invalidate the session to trigger passivation and activation
        session.invalidate();

        response.getWriter().println("Check the console for activation and passivation notifications.");
    }
}
