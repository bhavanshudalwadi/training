package com.handlingevents;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerExample implements ServletContextListener{
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        initializeDatabaseConnectionPool(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        destroyDatabaseConnectionPool(sce.getServletContext());
    }

    private void initializeDatabaseConnectionPool(ServletContext servletContext) {
        System.out.println("Database connection pool initialized.");
    }

    private void destroyDatabaseConnectionPool(ServletContext servletContext) {
        System.out.println("Database connection pool destroyed.");
    }
}


