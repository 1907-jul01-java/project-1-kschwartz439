package com.revature.movie.api;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionUtil
 */
public class ConnectionUtil {
    private Connection connection;
    private String url;
    private String user;
    private String password;

    public ConnectionUtil() {
        try {
            Class.forName("org.postgresql.Driver");
            // Properties properties = new Properties();
            // properties.load(new FileReader(
            //         new File(
            //             getClass().getClassLoader().getResource("application.properties").getFile()
            //         )
            //     )
            // );
            this.url = "jdbc:postgresql://192.168.99.100:5432/reimbursement";//properties.getProperty("url");
            this.user = "postgres";//properties.getProperty("user");
            this.password = "postgres";//properties.getProperty("password");
        } /*catch (IOException e) {
            e.getMessage();
        }*/ catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}