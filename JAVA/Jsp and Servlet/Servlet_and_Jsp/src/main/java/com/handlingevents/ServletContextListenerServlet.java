package com.handlingevents;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ServletContextListenerServlet")
public class ServletContextListenerServlet extends HttpServlet {
	private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = dataSource.getConnection();
            
            response.getWriter().println("Connected to the database successfully!");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error connecting to the database: " + e.getMessage());
        }
    }
}
