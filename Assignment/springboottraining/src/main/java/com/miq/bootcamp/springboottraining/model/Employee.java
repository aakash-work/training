package com.miq.bootcamp.springboottraining.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name="employee")
public class Employee{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long employeeId;

    @NotBlank
    private String name;

    @Email
    @Pattern(regexp=".*@miqdigital.com")
    private String email;

    @Positive(message="You cannot pay for working!")
    private double salary;

    public Employee() {
    }

    public Employee(long employeeId, String name, String email, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}