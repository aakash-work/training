package com.pratik;

/**
 * Vehicle
 */
public class Vehicle {

    private String name;
    private String number;

    public void addVehicle()
    {
        System.out.println("Enter your vehicle's name");
        this.name = App.input.nextLine();

        System.out.println("Enter your vehicle's number(String)");
        this.number = App.input.nextLine();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}