package com.hiranmaya_gundu;
import java.util.ArrayList; 

class Employee{
    String name;
    int id;
    String designation;
    String department;
    int compensation;
    ArrayList<Integer> contact = new ArrayList<Integer>(); ;
    Address address;
    Vehicle vehicle;

    public void printDetails()
    {
        System.out.println("The details of the employee are: ");
        System.out.println("name: " + name);
        System.out.println("id: " + id);
        System.out.println("designation: " + designation);
        System.out.println("department: " + department);
        System.out.println("compensation: " + compensation);
        System.out.println("Contact numbers are: ");
        for(int i =0; i<contact.size(); i++)
        {
            System.out.print(contact.get(i) + " ");
        }
        System.out.println("");
        System.out.println("Address details are: ");
        address.printDetails();
        System.out.println("Vehicle details are: "); 
        vehicle.printDetails();
    }
    public Employee()
    {
        System.out.println("For testing");
    }
    public Employee(String n, int i, String des, String dep, int com, ArrayList<Integer> con, Address ad, Vehicle veh)
    {
        name = n;
        id = i;
        designation = des;
        department = dep;
        compensation = com;
        contact = con;
        address = ad;
        vehicle = veh;
    }
}