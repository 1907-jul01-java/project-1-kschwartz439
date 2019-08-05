package com.revature.movie.api.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.entities.RequestDao;

public class SubmitServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String requestName = req.getParameter("requestName");
        String requestType = req.getParameter("requestType");
        double cost = Double.parseDouble(req.getParameter("cost"));
        String requestDescription = req.getParameter("requestDescription");
        String username = req.getParameter("username");
        // System.out.println(requestName+ requestType+ cost+ requestDescription+ username);
        try {
            setRequest(requestName, requestType, cost, requestDescription, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setRequest(String requestName, String requestType, double cost, String requestDescription, String username){
        ConnectionUtil connection = new ConnectionUtil();
        RequestDao dao = new RequestDao(connection.getConnection());
        dao.setRequestObject(requestName, requestType, cost, requestDescription, username);
        connection.close();
    }
}