package com.handlingevents;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionBindingListenerServlet")
public class HttpSessionBindingListenerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        HttpSessionBindingListenerExample listener = new HttpSessionBindingListenerExample("someAttribute");
        session.setAttribute("someAttribute", listener);
        session.removeAttribute("someAttribute");
        session.setAttribute("someAttribute", "bhavanshu");
    }
}