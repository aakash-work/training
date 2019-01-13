package com.swetha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
class Address{
    private int empId;
    private String house;
    private String street;
    private String city;
    private String country;
    public Address(int empId,String house, String street,String city,String country)
    {
        this.empId=empId;
        this.house=house;
        this.street=street;
        this.city=city;
        this.country=country;
        //System.out.println("House is "+this.house);
        DBConn con= DBConn.getInstance();
        String query="INSERT INTO address VALUES("+empId+",'"+house+"','"+street+"','"+city+"','"+country+"')";
        //
        con.execute(query);
    }
    public static void readInfo(int empId)
    {
        ResultSet rs;
        DBConn con= DBConn.getInstance();
        String query="SELECT * FROM address where empId="+empId;

        rs=con.execute_sel(query);
        try {

            //Retrieve by column name
            while(rs.next()) {
                System.out.println("-------------Address-----------------");
                System.out.println("House: " + rs.getString("houseNo"));
                System.out.println("Street: " + rs.getString("street"));
                System.out.println("City: " + rs.getString("city"));
                System.out.println("Country: " + rs.getString("country"));
            }
            rs.close();
        }
        catch (Exception se)
        {
            System.out.println("Exception occured");
        }
    }

}
class Vehicle{
    private int empId;
    private String regNo;
    private String type;
    public Vehicle(int empId,String regNo, String type)
    {
        this.empId=empId;
        this.regNo=regNo;
        this.type=type;
        System.out.println("Reg is "+this.regNo);
        DBConn con= DBConn.getInstance();
        String query="SELECT * FROM vehicle where empId="+empId;

        ResultSet rs=con.execute_sel(query);
        try {

            //no records insert
            if(!rs.isBeforeFirst())
            {
                query="INSERT INTO vehicle VALUES("+empId+",'"+regNo+"','"+type+"')";

                con.execute(query);
            }
            else //update
            {
                query="UPDATE vehicle SET regNo='"+regNo+"',type='"+type+"' where empId="+empId;

                int op=con.execute(query);
                if(op==0)
                    System.out.println("Employee record doesn't exist");
                else if(op!=-1)
                    System.out.println("Vehicle information updated");
            }

            rs.close();
        }
        catch (Exception se)
        {
            System.out.println("Exception occured");
        }

    }
    public static void readInfo(int empId)
    {
        ResultSet rs;
        DBConn con= DBConn.getInstance();
        String query="SELECT * FROM vehicle where empId="+empId;

        rs=con.execute_sel(query);
        try {

            //Retrieve by column name

            while(rs.next()) {
                System.out.println("-------------Vehicle info-----------------");
                System.out.println("RegNo: " + rs.getString("regNo"));
                System.out.println("Type: " + rs.getString("type"));
            }
            rs.close();
        }
        catch (Exception se)
        {
            System.out.println("Exception occured");
        }
    }

}
public class Employee {
    private int empId;
    private String name;
    private String department;
    private String designation;
    private int compensation;
    private Address addr;
    private ArrayList<Integer> contact;
    private Vehicle vehicle;

    public Employee(int empId,String name,String department,String designation,int compensation,ArrayList<Integer> contact,String house,String street,String city,String country)
    {
        this.empId=empId;
        this.name=name;
        this.department=department;
        this.designation=designation;
        this.compensation=compensation;
        this.contact=new ArrayList<Integer>();
        this.contact=contact;

        //add to db and extract empId
        DBConn con= DBConn.getInstance();
        String query="INSERT INTO employee VALUES("+empId+",'"+name+"','"+designation+"','"+department+"',"+compensation+")";

        con.execute(query);
        addr=new Address(empId,house,street,city,country);
        //vehicle=new Vehicle(empId,regNo,type);
        System.out.println("name is"+this.name);
        for (int cont : contact) {
            addContact(empId,cont);
        }

        //con.closeConn();
    }
    public static void addContact(int empId,int contact)
    {
        DBConn con= DBConn.getInstance();
        ResultSet rs;
        String query="SELECT count(*) FROM contact where empId="+empId;

        rs=con.execute_sel(query);
        try {
            while(rs.next()) {
                //Retrieve by column name
                if (rs.getInt("count(*)") < 3) {

                    query="INSERT INTO contact VALUES("+empId+","+contact+")";

                    con.execute(query);
                }
                else
                {
                    System.out.println("3 contacts exist already");
                }
            }
            rs.close();
        }
        catch (Exception se)
        {
            System.out.println("Exception occured");
        }

    }
    public static void addVehicle(int empId,String regNo,String type)
    {
        Vehicle vehicle=new Vehicle(empId,regNo,type);
    }
    public static void readInfo(int empId)
    {
        ResultSet rs;
        DBConn con= DBConn.getInstance();
        String query="SELECT * FROM employee where empId="+empId;

        rs=con.execute_sel(query);
        try {
                if(!rs.isBeforeFirst())
                {
                    System.out.println("Employee doesn't exist");
                    return;
                }
                while(rs.next()) {
                    //Retrieve by column name
                    System.out.println("-------------Employee info-----------------");
                    System.out.println("Employee ID: " + rs.getInt("empId"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Designation: " + rs.getString("designation"));
                    System.out.println("Department: " + rs.getString("department"));
                    System.out.println("Compensation: " + rs.getInt("compensation"));
                }
            rs.close();
        }
        catch (Exception se)
        {
            System.out.println("Exception occured");
        }
        query="SELECT * FROM contact where empId="+empId;

        rs=con.execute_sel(query);
        System.out.println("-------------Contact info-----------------");
        try {
            while (rs.next()) {
                //Retrieve by column name
                System.out.println("Contact: " + rs.getInt("phoneNo"));

            }
            rs.close();
        }
        catch (Exception se)
        {
            System.out.println("No results");
        }
        Address.readInfo(empId);
        Vehicle.readInfo(empId);
    }
    public static void updateComp(int empId,int comp)
    {
        DBConn con= DBConn.getInstance();
        String query="UPDATE employee SET compensation="+comp+" where empId="+empId;

        int op=con.execute(query);
        if(op==0)
            System.out.println("Employee record doesn't exist");
        else if(op!=-1)
            System.out.println("Employee compensation updated");
    }
    public static void deleteEmp(int empId)
    {
        DBConn con= DBConn.getInstance();
        int op;
        String query="DELETE FROM contact where empId="+empId;

        con.execute(query);
        query="DELETE FROM address where empId="+empId;

        con.execute(query);
        query="DELETE FROM vehicle where empId="+empId;

        con.execute(query);
        query="DELETE FROM employee where empId="+empId;

        op=con.execute(query);
        if(op==0)
            System.out.println("Employee record doesn't exist");
        else if(op!=-1)
            System.out.println("Employee record deleted");
    }
    public static void finish()
    {
        DBConn con= DBConn.getInstance();
        con.closeConn();
    }

}
