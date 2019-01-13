package com.swetha;
import java.sql.*;

public class DBConn
{
    // static variable single_instance of type Singleton
    private static DBConn sobj = null;

    // variable of type String

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/session";

    //  Database credentials
    private static final String USER = "swetha";
    private static final String PASS = "12345";
    private static Connection conn =null;
    private static Statement stmt = null;
    // private constructor restricted to this class itself
    private DBConn() throws
            ClassNotFoundException,SQLException
    {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("It works !");
        //conn.close();
    }

    // static method to create instance of Singleton class
    public static DBConn getInstance()
    {
      try {
          if (sobj == null)
              sobj = new DBConn();

          return sobj;
      }
      catch(Exception e)
      {
          System.out.println("Not connected");
          e.printStackTrace();
          return sobj;
      }
    }
    public int execute(String sql)
    {
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
            //System.out.println("Query successful");
        }
        catch (SQLException se)
        {
            se.printStackTrace();
            System.out.println("SQL Exception occured-invalid input");
            return -1;
        }
    }
    public ResultSet execute_sel(String sql)
    {
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            //System.out.println("Query successful");

        }
        catch (SQLException se)
        {
            se.printStackTrace();
            System.out.println("SQL Exception");
        }
        return rs;
    }
    public void closeConn()
    {
        try {
            conn.close();
            System.out.println("Connection closed");
        }
        catch (Exception e)
        {
            System.out.println("Can't close connection");
            e.printStackTrace();
        }
    }
}
