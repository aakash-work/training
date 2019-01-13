package com.sahana;
import java.util.Scanner;

public class Address {
    private String street;
    private String city;
    private String state;
    private String country;

    public void createAddress()
    {

        System.out.println("Enter the street address");
        this.street = App.in.nextLine();

        System.out.println("Enter the city");
        this.city = App.in.nextLine();

        System.out.println("Enter the state");
        this.state = App.in.nextLine();

        System.out.println("Enter the country");
        this.country = App.in.nextLine();
        System.out.println(this.country);

    }

    public String gStreet()
    {
        return this.street;
    }

    public String gCity()
    {
        return this.city;
    }

    public String gState()
    {
        return this.state;
    }

    public String gCountry()
    {
        return this.country;
    }
};

