package com.aravindbs;
import java.sql.*;

public class DBConnection {


    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USER = "training";
    private static final String PASS = "password";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL +'?' +
                    String.format("user=%s&password=%s", USER,PASS));
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
