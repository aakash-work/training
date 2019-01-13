package com.sahana;
import java.sql.*;

public class Database {


    public Connection connectDB()
    {
        {
            Connection con;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/emp","abc","123");

                if (con != null)
                    System.out.println("Connected");
                else
                    System.out.println("Not Connected");


            }
            catch(Exception e)
            {
                con=null;
                System.out.println(e);
            }
            return con;
        }
    }

    public void insert(Employee e)
    {
        try {
            Connection con = connectDB();
            Statement stmt = con.createStatement();

            String q2 = "select max(empID) from Employee;";
            ResultSet rs = stmt.executeQuery(q2);
            int id=-1;
            if (rs.next())
            {
                id = rs.getInt("max(empID)");

            }
            id=id+1;
            System.out.println("Your employee ID is "+ id);
            stmt.close();

            //Insert into employee table
            String q1 = "insert into Employee values( '" + id + "','" + e.getName() + "', '" + e.getDesignation() +
                    "', '" + e.getDept() + "', '" + e.getSalary() + "')";
            System.out.println(q1);
            stmt = con.createStatement();
            int x = stmt.executeUpdate(q1);
            if (x > 0)
                System.out.println("Successfully Inserted into employee");
            else
                System.out.println("Insert Failed");
            stmt.close();

            //Insert into address
            String q3 = "insert into Address values( '" + id + "','" + e.getStreet() + "', '" + e.getCity() +
                    "', '" + e.getState() + "', '" + e.getCountry() + "')";
            System.out.println(q3);
            stmt = con.createStatement();
            x = stmt.executeUpdate(q3);
            if (x > 0)
                System.out.println("Successfully Inserted into address");
            else
                System.out.println("Insert Failed");
            stmt.close();

            //insert into vehicle
            String q4= "insert into Vehicle values( '" + id + "','" + e.getRegNum() + "', '" + e.getType() +
                    "')";
            System.out.println(q4);
            stmt = con.createStatement();
            x = stmt.executeUpdate(q4);
            if (x > 0)
                System.out.println("Successfully Inserted into vehicle");
            else
                System.out.println("Insert Failed");
            stmt.close();

            //insert into contact
            for(int num : e.getContact())
            {
                String q5 = "insert into Contact values( '" + id + "','" + num + "')";
                System.out.println(q5);
                stmt = con.createStatement();
                x = stmt.executeUpdate(q5);
                if (x > 0)
                    System.out.println("Successfully Inserted into contact");
                else
                    System.out.println("Insert Failed");
                stmt.close();
            }

            con.close();
        }
        catch(Exception e2)
        {
            System.out.println(e2);
        }

    }

    public void readRecord(int id)
    {
        //select Employee.empID , name , designation, department, salary, street, city , state, country, regNumber, type FROM Employee, Vehicle, Address WHERE Employee.empID = Address.empID AND Address.empID = Vehicle.empID;
        try
        {

            Connection con = connectDB();
            String q1 = "select Employee.empID , name , designation, department, " +
                    "salary, street, city , state, country, regNumber, type FROM Employee, Vehicle, Address " +
                    "WHERE Employee.empID = Address.empID " +
                    "AND Address.empID = Vehicle.empID " +
                    "AND Employee.empID = " + id + "";
            System.out.println(q1);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q1);
            System.out.println("-----------------------------------------------");
            System.out.println("THE EMPLOYEE DETAILS:");
            if (rs.next())
            {
                System.out.println("Employee Id : " + rs.getString(1));
                System.out.println("Name :" + rs.getString(2));
                System.out.println("Designation :" + rs.getString(3));
                System.out.println("Department :" + rs.getString(4));
                System.out.println("Salary :" + rs.getString(5));
                System.out.println("ADDRESS:");
                System.out.println("Street :" + rs.getString(6));
                System.out.println("City :" + rs.getString(7));
                System.out.println("State :" + rs.getString(8));
                System.out.println("Country :" + rs.getString(9));
                System.out.println("VEHICLE DETAILS:");
                System.out.println("Registration Number :" + rs.getString(10));
                System.out.println("Type :" + rs.getString(11));


            }
            else
            {
                System.out.println("No such employee id is already registered");
            }
            stmt.close();


            String q2 = "select phNo from Contact WHERE empID = '" + id + "';";

            stmt = con.createStatement();
            rs = stmt.executeQuery(q2);

            System.out.println("CONTACT NUMBER:");
            if (rs.next())
            {
                System.out.println(rs.getString(1));
            }
            else
            {
                System.out.println("No contact details for this emp id");
            }
            stmt.close();

            System.out.println("-----------------------------------------------");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteRecord(int id)
    {
        try
        {
            Connection con = connectDB();
            Statement stmt = con.createStatement();




            //delete from addr

            String q2 = "DELETE from Vehicle WHERE empID = '" + id +
                    "'";

            int x = stmt.executeUpdate(q2);

            if (x > 0)
                System.out.println("Successfully Deleted vehicle details");
            else
                System.out.println("Error");

            //delete from vehicle

            String q3 = "DELETE from Address WHERE empID = '" + id +
                    "'";

            x = stmt.executeUpdate(q3);

            if (x > 0)
                System.out.println("Successfully Deleted Address details");
            else
                System.out.println("Error");

            //delete from contact

            String q4 = "DELETE from Contact WHERE empID = '" + id +
                    "'";

            x = stmt.executeUpdate(q4);

            if (x > 0)
                System.out.println("Successfully Deleted Contact details");
            else
                System.out.println("Error");

            // Deleting from database

            String q1 = "DELETE from Employee WHERE empID = '" + id +
                    "'";

            x = stmt.executeUpdate(q1);

            if (x > 0)
                System.out.println("One User Successfully Deleted (from employee)");
            else
                System.out.println("Error");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateDepartment(int id, String name)
    {
        try
        {
            Connection con = connectDB();
            Statement stmt = con.createStatement();
            System.out.println("Updating department");
            // Updating database
            String q1 = "UPDATE Employee set department = '" + name +
                    "' WHERE empID = '" + id + "'";

            System.out.println(q1);

            int x = stmt.executeUpdate(q1);

            if (x > 0)
                System.out.println("Department Successfully Updated");
            else
                System.out.println("Error");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}




