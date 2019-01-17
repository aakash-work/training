package com.pratik;

import java.util.Scanner;

/**
 * Address
 */
public class Address {

    private String street;
    private String city;
    private String state;
    private String country;

    public void addAddress() {
        System.out.println("Enter your street address");
        this.street = App.input.nextLine();
        
        System.out.println("Enter your street city");
        this.city = App.input.nextLine();

        System.out.println("Enter your street state");
        this.state = App.input.nextLine();

        System.out.println("Enter your street country");
        this.country = App.input.nextLine();
        
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }
}