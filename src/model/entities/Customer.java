/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.model.entities;

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

    public Customer(int customercode, String firstName, String middleName, String lastName, String address, String city, String state, String Country, String c_code, String mobile, String email, Date dob, String nok, char gender) {
        this.customercode = customercode;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.Country = Country;
        this.c_code = c_code;
        this.mobile = mobile;
        this.email = email;
        this.dob = dob;
        this.nok = nok;
        this.gender = gender;
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

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
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

    public Date setDob(Date dob) {
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
