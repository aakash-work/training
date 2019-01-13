package com.sahana;
import java.util.Scanner;
public class Vehicle {
    String regNum;
    String type;

    public void createVehicle()
    {

        System.out.println("Enter the vehicle registration number");
        this.regNum = App.in.nextLine();

        System.out.println("Enter the vehicle type");
        this.type = App.in.nextLine();


    }

    public String gRegNum()
    {
        return this.regNum;
    }

    public String gType()
    {
        return this.type;
    }
}
