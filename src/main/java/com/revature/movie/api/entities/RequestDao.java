package com.revature.movie.api.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Requests> getAll(String username) {
        Requests request;
        List<Requests> requests = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from requests where username = ?");
            while (resultSet.next()) {
                request = new Requests();
                request.setRequestName(resultSet.getString("requestName"));
                request.setRequestType(resultSet.getString("requestType"));
                request.setCost(resultSet.getDouble("cost"));
                request.setRequestDescription(resultSet.getString("requestDescription"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public void setRequestObject(String requestName, String requestType, double cost, String requestDescription, String username){
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into requests (requestName, requestType, cost, requestDescription, rUsersname, approved) values(?, ?, ?, ?, ?, ?)");
            pStatement.setString(1, requestName);
            pStatement.setString(2, requestType);
            pStatement.setDouble(3, cost);
            pStatement.setString(4, requestDescription);
            pStatement.setString(5, username);
            pStatement.setString(6, "pending");
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}