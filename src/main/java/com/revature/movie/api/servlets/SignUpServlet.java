package com.revature.movie.api.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.entities.UserDao;
import com.revature.movie.api.users.User;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
		try {
            setUser(req, resp);
            User user = getUser(username, password, firstName, lastName);
            if (user != null) {
                String result = user.getAccess();
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

	private User getUser(String username, String password, String firstName, String lastName) throws SQLException {
		User user = new User(firstName, lastName, password, username);
		ConnectionUtil connection = new ConnectionUtil();
        UserDao uDao = new UserDao(connection.getConnection());
        uDao.getUserObject(username, password, firstName, lastName);
        connection.close();
        return user;
	}

	private void setUser(String username, String password, String firstName, String lastName) throws SQLException {
		ConnectionUtil connection = new ConnectionUtil();
        UserDao uDao = new UserDao(connection.getConnection());
        uDao.setUserObject(username, password, firstName, lastName);
        connection.close();
	}

	private void setUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		String username = req.getParameter("userName");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
        setUser(username, password, firstName, lastName);
	}
}