package com.pratik;

import java.util.Objects;

/**
 * Employee
 */
public class Employee {

    private int employeeID;
    private String name;
    private String designation;
    private String department;
    
    private Address address;
    private Contact contactNumber;
    private Vehicle vehicleDetails;

    private int compensation;

    public Employee() {
    }

    public Employee(int employeeID, String name, String designation, String department, Address address, Contact contactNumber, Vehicle vehicleDetails, int compensation) {
        this.employeeID = employeeID;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.address = address;
        this.contactNumber = contactNumber;
        this.vehicleDetails = vehicleDetails;
        this.compensation = compensation;
    }

    public void createEmployee() {
        System.out.println("Enter employee name: ");
        this.name = App.input.nextLine();

        System.out.println("Enter employee designation: ");
        this.designation = App.input.nextLine();

        System.out.println("Enter employee department: ");
        this.department = App.input.nextLine();

        System.out.println("Please enter your address");
        Address add = new Address();
        add.addAddress();
        this.address = add;

        System.out.println("Please enter your contact details: ");
        Contact cont = new Contact();
        cont.AddContacts();
        this.contactNumber = cont;

        System.out.println("Please enter your vehicle details");
        Vehicle veh = new Vehicle();
        veh.addVehicle();
        this.vehicleDetails = veh;

        System.out.println("Please enter your compensation");
        this.compensation = App.input.nextInt();

        App.dbContext.insert(this);
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(Contact contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Vehicle getVehicleDetails() {
        return this.vehicleDetails;
    }

    public void setVehicleDetails(Vehicle vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public int getCompensation() {
        return this.compensation;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID && Objects.equals(name, employee.name) && Objects.equals(designation, employee.designation) && Objects.equals(department, employee.department) && Objects.equals(address, employee.address) && Objects.equals(contactNumber, employee.contactNumber) && Objects.equals(vehicleDetails, employee.vehicleDetails) && compensation == employee.compensation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, name, designation, department, address, contactNumber, vehicleDetails, compensation);
    }

    @Override
    public String toString() {
        return "{" +
            " employeeID='" + getEmployeeID() + "'" +
            ", name='" + getName() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", department='" + getDepartment() + "'" +
            ", address='" + getAddress() + "'" +
            ", contactNumber='" + getContactNumber() + "'" +
            ", vehicleDetails='" + getVehicleDetails() + "'" +
            ", compensation='" + getCompensation() + "'" +
            "}";
    }
}