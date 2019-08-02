package com.revature.movie.api.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.movie.api.users.User;

public class UserDao implements Dao<User> {
    Connection connection;
    
    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        try {
            PreparedStatement p2Statement = connection.prepareStatement("insert into logins(username, password) values (?, ?)");
            p2Statement.setString(1, user.getUsername());
            p2Statement.setString(2, user.getPassword());
            p2Statement.executeUpdate();
            PreparedStatement pStatement = connection.prepareStatement("insert into users(firstName, lastName, usersName) values(?, ?, ?)");
            pStatement.setString(1, user.getFirstName());
            pStatement.setString(1, user.getLastName());
            pStatement.setString(3, user.getUsername());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

	public User getUserObject(String username) {
        User user = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM users INNER JOIN logins ON users.usersName = logins.username WHERE logins.username = ?");
            pStatement.setString(1, username);
            ResultSet pResultSet = pStatement.executeQuery();
            while (pResultSet.next()){
                String uname = pResultSet.getString("username");
                String password = pResultSet.getString("password");
                String access = pResultSet.getString("access");
                String firstName = pResultSet.getString("firstName");
                String lastName = pResultSet.getString("lastName");
                user = new User(uname, password, access, firstName, lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}
}