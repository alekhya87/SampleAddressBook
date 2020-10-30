package com.emphasis.model;
/*
 * @author:alekhya
 * @created date:22th oct 2020
 * @functionality:this is object file which contains objects of the
 *                original file ,constructor and default constructor
 *                with toString
 */
public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public Person(){

    }
    public Person(String[] data) {
        this.firstName = data[0];
        this.lastName = data[1];
        this.address = data[2];
        this.city = data[3];
        this.state = data[4];
        this.zip = data[5];
        this.phoneNumber = data[6];
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName +',' +lastName + ',' + address + ',' + city + ',' + state + ','
                + zip +','+ phoneNumber ;
    }
}
