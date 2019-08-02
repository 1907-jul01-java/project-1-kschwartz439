package com.revature.movie.api.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.movie.api.requests.Requests;

public class RequestDao implements Dao<Requests> {
    Connection connection;
    
    public RequestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Requests request) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into requests(requestName, requestType, cost, requestDescription, imageLocation, rUsersname) values(?, ?, ?, ?, ?, ?)");
            pStatement.setString(1, request.getRequestName());
            pStatement.setString(2, request.getRequestType());
            pStatement.setDouble(3, request.getCost());
            pStatement.setString(4, request.getRequestDescription());
            pStatement.setString(5, request.getImageLocation());
            pStatement.setString(6, request.getUsername());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}