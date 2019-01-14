package com.hiranmaya_gundu;

import java.sql.*;
import java.util.ArrayList;

class Connectivity{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";
    static final String USER = "emp";
    static final String PASS = "password";
    
    Connection conn = null;
    // Statement stmt = null;

    public Connectivity()
    {
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("The connection creation failed. Abort.");
            e.printStackTrace();
        }
        finally
        {
            System.out.println("");
        }
    }
    public void create(Employee e)
    {
        String SQL1 = "INSERT INTO Employee values(?,?,?,?,?)";
        String SQL2 = "INSERT INTO Address values(?,?,?,?,?)";
        String SQL3 = "INSERT INTO Vehicle values(?,?,?)";
        String SQL4 = "INSERT INTO Contact values(?,?)";
        PreparedStatement s1 = null;
        PreparedStatement s2 = null;
        PreparedStatement s3 = null;
        PreparedStatement s4 = null;
        try
        {
            conn.setAutoCommit(false);
            s1 = conn.prepareStatement(SQL1);
            s1.setInt(1, e.id);
            s1.setString(2, e.name);
            s1.setString(3, e.designation);
            s1.setString(4, e.department);
            s1.setInt(5, e.compensation);
            s1.executeUpdate();
            conn.commit();
            s2 = conn.prepareStatement(SQL2);
            s2.setInt(1,e.id);
            s2.setString(2,e.address.street);
            s2.setString(3,e.address.city);
            s2.setString(4,e.address.state);
            s2.setString(5,e.address.country);
            s2.executeUpdate();
            conn.commit();
            s3 = conn.prepareStatement(SQL3);
            s3.setInt(1,e.id);
            s3.setString(2,e.vehicle.regNo);
            s3.setString(3,e.vehicle.type);
            s3.executeUpdate();
            conn.commit();
            s4 = conn.prepareStatement(SQL4);
            for(int i =0; i<e.contact.size();i++)
            {
                s4.setInt(1,e.id);
                s4.setInt(2,e.contact.get(i));
                s4.executeUpdate();
                conn.commit();
            }
        }
        catch (SQLException ex) 
        {
            System.out.println("Error preparing statement");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(s1 != null)
                {
                    
                    s1.close();
                }
                if(s2 != null)
                {
                    s2.close();
                }
                if(s3 != null)
                {
                    s3.close();
                }
                if(s4 != null)
                {
                    s4.close();
                }
                // conn.setAutoCommit(true);
            }
            catch(SQLException se)
            {
                
            }   
        }
    } 
    public void delete(int id)
    {
        String SQL= "DELETE FROM Employee where id = ?";
        PreparedStatement s1 = null;
        try
        {
            conn.setAutoCommit(false);
            s1 = conn.prepareStatement(SQL);
            s1.setInt(1, id);
            s1.executeUpdate();
            conn.commit();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error preparing statement");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(s1 != null)
                {
                    s1.close();
                }
                // conn.setAutoCommit(true);
            }
            catch(SQLException se)
            {

            }
        }
    }
    public void update(int id, String name)
    {
        String SQL= "UPDATE Employee SET name = ? where id = ?";
        PreparedStatement s1 = null;
        try
        {
            conn.setAutoCommit(false);
            s1 = conn.prepareStatement(SQL);
            s1.setInt(2, id);
            s1.setString(1,name);
            s1.executeUpdate();
            conn.commit();
        }
        catch (SQLException ex) 
        {
            System.out.println("Error preparing statement");
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(s1 != null)
                {
                    s1.close();
                }
                // conn.setAutoCommit(true);
            }
            catch(SQLException se)
            {
                
            }
        }
    }
    public Employee read(int id)
    {
        Employee ret = null;
        String SQL1= "SELECT * FROM Employee WHERE id = ?";
        String SQL2= "SELECT * FROM Address WHERE id = ?";
        String SQL3= "SELECT * FROM Vehicle WHERE id = ?";
        String SQL4= "SELECT * FROM Contact WHERE id = ?";
        PreparedStatement s1 = null;
        PreparedStatement s2 = null;
        PreparedStatement s3 = null;
        PreparedStatement s4 = null;
        try
        {
            Address ad = null;
            Vehicle ve = null;
            s1 = conn.prepareStatement(SQL2);
            s1.setInt(1, id);
            ResultSet rs = s1.executeQuery();
            if(rs.next())
                ad = new Address(rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("country"));
            // ad.printDetails();
            s2 = conn.prepareStatement(SQL3);
            s2.setInt(1, id);
            rs = s2.executeQuery();
            if(rs.next())
                ve = new Vehicle(rs.getString("type"),rs.getString("reg_no"));
            // ve.printDetails();
            s3 = conn.prepareStatement(SQL4);
            s3.setInt(1, id);
            rs = s3.executeQuery();
            ArrayList<Integer> con = new ArrayList<Integer>();
            while(rs.next())
            {
                con.add(rs.getInt("no"));
            }
            s4 = conn.prepareStatement(SQL1);
            s4.setInt(1, id);
            rs = s4.executeQuery();
            if(rs.next())
                ret = new Employee(rs.getString("name"),rs.getInt("id"),rs.getString("designation"),rs.getString("department"),rs.getInt("compensation"),con,ad,ve);
        }
        catch(SQLException e)
        {
            System.out.println("Error reading ");
            e.printStackTrace();
        }
        return ret;
    }
}