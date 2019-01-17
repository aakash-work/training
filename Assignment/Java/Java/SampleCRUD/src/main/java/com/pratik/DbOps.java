package com.pratik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Thread.State;
import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

/**
 * DbOps
 */
public class DbOps {

    private static final String url = "jdbc:mysql://localhost:3306/session";
    private static final String user = "prkhandelwal";
    private static final String password = "Prk123";

    public Connection connect()
    {
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database succesfully");
        }

        catch(Exception e){
            con = null;
            System.out.println(e);
        }


        return con;
    }

    public void insert(Employee employee)
    {
        try(Connection con = connect()) {
            Statement stmt = (Statement)con.createStatement();

            String q1 = "select max(employeeid) from employees;";
            ResultSet rs = stmt.executeQuery(q1);
            int id=-1;
            if (rs.next())
            {
                id = rs.getInt("max(employeeid)");
            }
            id=id+1;
            stmt.close();


            String q2 = "insert into employees values( '" + id + "','" + employee.getName() + "', '" + employee.getDesignation() +
                    "', '" + employee.getDepartment() + "', '" + employee.getCompensation() + "')";
            stmt = (Statement)con.createStatement();
            int x = stmt.executeUpdate(q2);
            if (x > 0)
                System.out.println("Success!");
            else
                System.out.println("Failed");
                stmt.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}