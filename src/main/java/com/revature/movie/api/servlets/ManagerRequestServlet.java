package com.revature.movie.api.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.entities.RequestDao;
import com.revature.movie.api.requests.Requests;

public class ManagerRequestServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    //Return all requests
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Requests> requests = null;
        try {
            requests = getRequests();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("requests", requests);
    }

    public List<Requests> getRequests(){
        ConnectionUtil connection = new ConnectionUtil();
        RequestDao rDao = new RequestDao(connection.getConnection());
        List<Requests> requests = rDao.getAll();
        connection.close();
        return requests;
    }
}