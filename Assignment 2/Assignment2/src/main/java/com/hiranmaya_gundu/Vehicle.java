package com.hiranmaya_gundu;

class Vehicle{
    String regNo;
    String type;
    public void printDetails()
    {
        System.out.println(type + " " + regNo);
    }
    public Vehicle()
    {
        System.out.println("For testing");
    }
    public Vehicle(String t, String r)
    {
        regNo = r;
        type = t;
    }
}
