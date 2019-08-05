package com.revature.movie.api.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.entities.RequestDao;
import com.revature.movie.api.requests.Requests;

public class RequestServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    //Return all requests
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Requests> request1 = null;
        String username = req.getParameter("username");
        try {
            request1 = getRequests(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("requests", request1);
    }

    private List<Requests> getRequests(String username){
        ConnectionUtil connection = new ConnectionUtil();
        RequestDao rDao = new RequestDao(connection.getConnection());
        List<Requests> request1 = rDao.getAll(username);
        connection.close();
        return request1;
    }
}