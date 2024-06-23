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
public class Transaction {
    private int trxnCode;
    private String accountNo;
    private double amount;
    private double workingBalance;
    private Date trxnDate;

    public Transaction(int trxnCode, String accountNo, double amount, double workingBalance, Date trxnDate) {
        this.trxnCode = trxnCode;
        this.accountNo = accountNo;
        this.amount = amount;
        this.workingBalance = workingBalance;
        this.trxnDate = trxnDate;
    }
    
    

    public int getTrxnCode() {
        return trxnCode;
    }

    public void setTrxnCode(int trxnCode) {
        this.trxnCode = trxnCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getWorkingBalance() {
        return workingBalance;
    }

    public void setWorkingBalance(double workingBalance) {
        this.workingBalance = workingBalance;
    }

    public Date getTrxnDate() {
        return trxnDate;
    }

    public void setTrxnDate(Date trxnDate) {
        this.trxnDate = trxnDate;
    }
    
}
