package com.karthikbhat;

import javax.persistence.*;


@Entity
@Table(name="Employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Employee {

    @Column(name = "NAME")
    private String name;

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DESIGNATION")
    private String Designation;

    @Column(name = "DEPARTMENT")
    private String Department;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "VEHICLE_DETAILS")
    private String vehicleDetails;

    @Column(name = "COMPENSATION")
    private Integer compensation;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

//    public Employee(String name, String id, String designation, String department, ArrayList<String> contactNumbers, String vehicleDetails, Integer compensation, Address address) {
//        this.name = name;
//        this.id = id;
//        Designation = designation;
//        Department = department;
//        this.contactNumbers = contactNumbers;
//        this.vehicleDetails = vehicleDetails;
//        this.compensation = compensation;
//        this.address = address;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getContactNumbers() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Integer getCompensation() {
        return compensation;
    }

    public void setCompensation(Integer compensation) {
        this.compensation = compensation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", Designation='" + Designation + '\'' +
                ", Department='" + Department + '\'' +
                ", contactNumbers=" + contactNumber +
                ", vehicleDetails='" + vehicleDetails + '\'' +
                ", compensation=" + compensation +
                '}';
    }
}
