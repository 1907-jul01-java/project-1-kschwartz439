package com.revature.movie.api.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.entities.UserDao;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
		try {
            setUser(username, password, firstName, lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	private void setUser(String username, String password, String firstName, String lastName) throws SQLException {
		ConnectionUtil connection = new ConnectionUtil();
        UserDao uDao = new UserDao(connection.getConnection());
        uDao.setUserObject(username, password, firstName, lastName);
        connection.close();
	}
}