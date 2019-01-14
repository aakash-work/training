package com.aravindbs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Employee {
    String first_name;
    String last_name;
    String designation;
    String department;
    Long employee_id;
    Address perm_addr;
    Address temp_addr;
    String mobile_no;
    Double compensation;

    public Employee(String first_name, String last_name, String designation, String department, Long employee_id, Address perm_addr, Address temp_addr, String mobile_no, Double compensation) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.designation = designation;
        this.department = department;
        this.employee_id = employee_id;
        this.perm_addr = perm_addr;
        this.temp_addr = temp_addr;
        this.mobile_no = mobile_no;
        this.compensation = compensation;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {

        return last_name;
    }

    public void setLast_name(String last_name) {

        this.last_name = last_name;
    }

    public String getDesignation() {

        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Address getPerm_addr() {
        return perm_addr;
    }

    public void setPerm_addr(Address perm_addr) {
        this.perm_addr = perm_addr;
    }

    public Address getTemp_addr() {
        return temp_addr;
    }

    public void setTemp_addr(Address temp_addr) {
        this.temp_addr = temp_addr;
    }

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}





