package com.revature.movie.api.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.entities.UserDao;
import com.revature.movie.api.users.User;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String loginpass = req.getParameter("password");
        try {
            setSession(req, resp);
            User user = getUser(username, loginpass);
            if (user != null) {
                String result = user.getAccess();
                resp.setContentType("text/html");
                resp.getWriter().write(result);
            } else if (user == null) {
                String result = "false";
                resp.setContentType("text/html");
                resp.getWriter().write(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setSession(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String username = request.getParameter("userName");
        String loginpass = request.getParameter("password");
        User user = getUser(username, loginpass);
        HttpSession session = request.getSession(false);
        if (username == null) {
            if (session == null)
                username = getInitParameter("userName");
            else
                username = (String) session.getAttribute("userName");
        } else {
            session = request.getSession();
            session.setAttribute("userName", username);
            session.setAttribute("access", user.getAccess());
        }

    }

    private User getUser(String username, String password) {
        ConnectionUtil connection = new ConnectionUtil();
        UserDao uDao = new UserDao(connection.getConnection());
        User user = uDao.getUserObject(username, password);
        connection.close();
        return user;
    }
}