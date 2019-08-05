package com.revature.movie.api.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    LoginServlet lServ = new LoginServlet();

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        String username = lServ.session.getAttribute("username").toString();
        try {
            resp.getWriter().write(username);
            resp.setStatus(202);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}