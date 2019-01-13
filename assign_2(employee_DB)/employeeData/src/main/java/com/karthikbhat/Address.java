package com.karthikbhat;


import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "ADDRESS", uniqueConstraints = {@UniqueConstraint(columnNames = {"ADDRESS_ID"})})
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    private String id;

    @Column(name = "PERM_ADDRESS")
    private String permanentAddress;

    @Column(name = "TEMP_ADDRESS")
    private String currentAddress;

//    public Address(String id, String permanentAddress, String curretnAddress) {
//        this.id = id;
//        this.permanentAddress = permanentAddress;
//        this.curretnAddress = curretnAddress;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String curretnAddress) {
        this.currentAddress = curretnAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", curretnAddress='" + currentAddress + '\'' +
                '}';
    }
}
