/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.entities;

import java.util.Date;

/**
 *
 * @author femitemiola
 */
public class Customer {
    private final int customercode;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String Country;
    private String c_code;
    private String mobile;
    private String email;
    private Date dob;
    private String nok;
    private final char gender;

    public Customer(CustomerInfo customerInfo) {
        this.customercode = customerInfo.getCustomercode();
        this.firstName = customerInfo.getFirstName();
        this.middleName = customerInfo.getMiddleName();
        this.lastName = customerInfo.getLastName();
        this.address = customerInfo.getAddress();
        this.city = customerInfo.getCity();
        this.state = customerInfo.getState();
        this.Country = customerInfo.getCountry();
        this.c_code = customerInfo.getC_code();
        this.mobile = customerInfo.getMobile();
        this.email = customerInfo.getEmail();
        this.dob = customerInfo.getDob();
        this.nok = customerInfo.getNok();
        this.gender = customerInfo.getGender();
    }

    public char getGender() {
        return gender;
    }

    public int getCustomercode() {
        return customercode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCountryCode() {
        return c_code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public Date setdob(Date dob) {
        this.dob = dob;
        return null;
    }

    public String getNok() {
        return nok;
    }

    public void setNok(String nok) {
        this.nok = nok;
    }
    
}
