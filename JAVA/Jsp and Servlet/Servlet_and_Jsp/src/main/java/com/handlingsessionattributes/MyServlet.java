package com.handlingsessionattributes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/my-servlet")
public class MyServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user input from the form
        String userName = request.getParameter("userName");

        // Store the user name in the session
        request.getSession().setAttribute("user_name", userName);

        // Redirect to another page or display a response
        response.sendRedirect("/confirmation.jsp");
    }
}

