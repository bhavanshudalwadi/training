package com.asyncronousprocessing;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/async-servlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        HttpSession session = request.getSession(true);

        AsyncContext asyncContext = request.startAsync();

        session.setAttribute("asyncContext", asyncContext);

        new Thread(() -> {
            try {
                Thread.sleep(1000);

                AsyncContext storedAsyncContext = (AsyncContext) session.getAttribute("asyncContext");

                HttpServletResponse asyncResponse = (HttpServletResponse) storedAsyncContext.getResponse();

                PrintWriter out = asyncResponse.getWriter();
                out.println("<html><head><title>AsyncServlet</title></head><body>");
                out.println("<p>Asynchronous processing completed!</p>");
                out.println("</body></html>");
                storedAsyncContext.complete();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}