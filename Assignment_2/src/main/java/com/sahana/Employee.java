package com.sahana;
import java.util.*;
import java.sql.*;

public class Employee {
    private int     empID;
    private String    empName;
    private float     salary;
    private List<Integer> contact = new ArrayList<Integer>();
    private Database db = new Database();
    private String  designation;
    private String dept;
    private Address addr;
    private Vehicle v;

    public String getName()
    {
        return this.empName;
    }

    public String getDesignation()
    {
        return this.designation;
    }

    public String getDept()
    {
        return this.dept;
    }

    public float getSalary()
    {
        return this.salary;
    }

    public List<Integer> getContact()
    {
        return this.contact;
    }

    public String getStreet()
    {
        return this.addr.gStreet();
    }

    public String getCity()
    {
        return this.addr.gCity();
    }

    public String getState()
    {
        return this.addr.gState();
    }

    public String getCountry()
    {
        return this.addr.gCountry();
    }

    public String getRegNum()
    {
        return this.v.gRegNum();
    }

    public String getType()
    {
        return this.v.gType();
    }

    public void createEmployee()
    {
//        Scanner in = new Scanner(System.in);
        System.out.println("Enter the employee name");
        this.empName = App.in.nextLine();

        System.out.println("Name: "+ this.empName);
        System.out.println("Enter the compensation");
        this.salary = App.in.nextFloat();

        System.out.println("Enter the contact number");
        this.contact.add(App.in.nextInt());
        App.in.nextLine();
        char ch;
        do {

            System.out.println("Would you like to provide another contact number (y/n)");
            ch = App.in.next().charAt(0);
            App.in.nextLine();
            if(ch=='y')
            {
                System.out.println("Enter the number\n");
                this.contact.add(App.in.nextInt());
                App.in.nextLine();
            }
        }while(ch=='y');

        System.out.println("Enter the employee designation");
        this.designation = App.in.nextLine();

        System.out.println("Enter the employee department");
        this.dept = App.in.nextLine();
        Address a = new Address();
        a.createAddress();
        this.addr = a;
        Vehicle veh = new Vehicle();
        veh.createVehicle();
        this.v = veh;

        db.insert(this);
    }

    public void displayEmployee()
    {
        System.out.println("Enter the Employee ID:");
        int id = App.in.nextInt();
        App.in.nextLine();
        db.readRecord(id);
    }

    public void updateEmployee()
    {
        System.out.println("Enter the Employee ID:");
        int id = App.in.nextInt();
        App.in.nextLine();
        System.out.println("Enter the new department of employee:");
        String dept = App.in.nextLine();
        db.updateDepartment(id, dept);
    }

    public void deleteEmployee()
    {
        System.out.println("Enter the Employee ID:");
        int id = App.in.nextInt();
        App.in.nextLine();
        db.deleteRecord(id);
    }



}
