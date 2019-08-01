package com.revature.movie.api.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.movie.api.domain.User;

/**
 * MovieDao
 */
public class UserDao implements Dao<User> {
    Connection connection;
    
    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into users(firstName, lastName, userId) values(?, ?, ?)");
            pStatement.setString(1, user.getFirstName());
            pStatement.setString(1, user.getLastName());
            pStatement.setInt(3, user.getUserId());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<User> getAll() {
        User user;
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from movies");
            while (resultSet.next()) {
                user = new User();
                user.setLastName(resultSet.getString("lastName"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setUserId(resultSet.getInt("userId"));
                user.add(user);
            }
        } catch (SQLException e) {

        }
        return users;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}