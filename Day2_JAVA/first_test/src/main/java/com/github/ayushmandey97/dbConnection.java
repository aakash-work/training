package com.github.ayushmandey97;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    public static void main(String[] args) {
        dbConnection obj_DB_Connection = new dbConnection();
        System.out.println(obj_DB_Connection.get_connection());
    }

    public Connection get_connection(){
        Connection connection = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root", "");
        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
}
