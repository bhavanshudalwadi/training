package com.example.servletdemo.handlingEvents.p4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-servlet")
public class RequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This servlet will trigger the ServletRequestListener events

        // For demonstration purposes, let's print a message to the response
        response.getWriter().println("Hello from request servlet!");
    }
}