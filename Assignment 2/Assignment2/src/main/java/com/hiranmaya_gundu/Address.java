package com.hiranmaya_gundu;

class Address{
    String street;
    String city;
    String state;
    String country;
    public void printDetails()
    {
        System.out.println(street + ",\n" + city + ",\n" + state + ",\n" + country);
    }
    public Address()
    {
        System.out.println("For testing");
    }
    public Address(String str, String ci,String sta,String co)
    {
        street = str;
        city = ci;
        state = sta;
        country = co;   
    }
} 