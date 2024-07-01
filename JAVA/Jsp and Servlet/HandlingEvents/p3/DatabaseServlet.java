package com.example.servletdemo.handlingEvents.p3;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/databaseServlet")
public class DatabaseServlet extends HttpServlet {

//    @Resource(name = "jdbc/yourDatabase")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get a connection from the initialized connection pool
            Connection connection = dataSource.getConnection();

            // Perform database operations using the connection
            // For demonstration purposes, let's print a message to the response
            response.getWriter().println("Connected to the database successfully!");

            // Close the connection when done
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error connecting to the database: " + e.getMessage());
        }
    }
}