package com.customsessionmanagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Pr1
 */
@WebServlet("/Pr1")
public class Pr1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pr1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = "admin";
        String password = "password";

        // In a real application, you should validate the username and password against a database or other user store
        if ("admin".equals(username) && "password".equals(password)) {
            // Login successful, set user in session
            HttpSession session = req.getSession();
            session.setAttribute("user", username); // Use a more complex user object in real scenarios

            // Redirect to a protected resource or home page
            resp.setContentType("text/html");
            PrintWriter pr=resp.getWriter();
            pr.println("Successfully login");
        } else {
            // Login failed, set an error message and redirect back to the login page
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
			resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}

}
