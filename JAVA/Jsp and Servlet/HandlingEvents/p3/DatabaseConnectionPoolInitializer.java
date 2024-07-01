package com.example.servletdemo.handlingEvents.p3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class DatabaseConnectionPoolInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Perform initialization tasks, e.g., initializing a database connection pool
        initializeDatabaseConnectionPool(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Perform cleanup tasks, e.g., closing the database connection pool
        destroyDatabaseConnectionPool(sce.getServletContext());
    }

    private void initializeDatabaseConnectionPool(ServletContext servletContext) {
        // Perform database connection pool initialization here
        // For demonstration purposes, let's print a message to the console
        System.out.println("Database connection pool initialized.");
    }

    private void destroyDatabaseConnectionPool(ServletContext servletContext) {
        // Perform cleanup of the database connection pool here
        // For demonstration purposes, let's print a message to the console
        System.out.println("Database connection pool destroyed.");
    }
}