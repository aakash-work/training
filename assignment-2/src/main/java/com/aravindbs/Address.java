package com.aravindbs;

public class Address {
    int door_no;
    String street_name;
    String locality;
    String city;
    String state;
    String country;
    String type;
    int pin_code;

    public Address(int door_no, String street_name, String locality, String city, String state, String country, int pin_code, String type) {
        this.door_no = door_no;
        this.street_name = street_name;
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.country = country;
        this.type = type;
        this.pin_code = pin_code;
    }

    public int getDoor_no() {
        return door_no;
    }

    public void setDoor_no(int door_no) {
        this.door_no = door_no;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPin_code() {
        return pin_code;
    }

    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "door_no=" + door_no +
                ", street_name='" + street_name + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", pin_code=" + pin_code +
                '}';
    }
}
