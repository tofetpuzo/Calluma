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
public class CustomerAccount {

    private String AccountNo;
    private final int customerCode;
    private final int accountCode;
    private String Pin;
    private double balance;
    private final Date dateCreated;
    private String status;

    public CustomerAccount(String AccountNo, int customerCode, int accountCode, String Pin, double balance, Date dateCreated, String status) {
        this.AccountNo = AccountNo;
        this.customerCode = customerCode;
        this.accountCode = accountCode;
        this.Pin = Pin;
        this.balance = balance;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public int getAccountCode() {
        return accountCode;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    

}
