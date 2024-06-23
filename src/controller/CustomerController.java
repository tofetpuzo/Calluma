/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.controller;

import kebank_datababse.model.entities.CustomerAccount;
import kebank_datababse.model.CustomerAccountDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebank_datababse.model.CustomerDAO;
import kebank_datababse.model.TransactionDAO;
import kebank_datababse.model.entities.Customer;
import kebank_datababse.model.entities.Transaction;

/**
 *
 * @author femitemiola
 */
public class CustomerController {

    private static CustomerAccount customeraccount = null;

    public double checkBalance() {
        return CustomerController.customeraccount.getBalance();
    }

    public double deposit(double amount) {
    
        synchronized (this) {
            double balance = customeraccount.getBalance() + amount;
            customeraccount.setBalance(balance);
            CustomerAccountDAO.updateCustomerAccount(customeraccount);
            TransactionDAO.insertTransaction(new Transaction(-1, customeraccount.getAccountNo(), amount, customeraccount.getBalance(), null));
            return checkBalance();
        }
    }

    public double withdraw(double amount) {

        synchronized (this) {
            if (customeraccount.getBalance() >= amount) {
                double newAmount = customeraccount.getBalance() - amount;
                customeraccount.setBalance(newAmount);
                CustomerAccountDAO.updateCustomerAccount(customeraccount);
                TransactionDAO.insertTransaction(new Transaction(-1, customeraccount.getAccountNo(), amount, customeraccount.getBalance(), null));
            }
        }
        return this.checkBalance();
    }

    public CustomerAccount getCustomerAccount(String accountNo) {
        ResultSet rs = CustomerAccountDAO.getCustomerAccountbyAccountNo(accountNo);
        if (accountNo != null) {
            try {
                while (rs.next()) {
                    return new CustomerAccount(rs.getString(1), rs.getInt(2),
                            rs.getInt(3), rs.getString(3),
                            rs.getDouble(5), rs.getDate(6), rs.getString(7));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }
    public double transferAmount(String accountTo, double amount){
       CustomerAccount account = getCustomerAccount(accountTo);
        if(account != null){
            if(customeraccount.getBalance() >= amount){
                customeraccount.setBalance(customeraccount.getBalance() - amount);           
                account.setBalance(account.getBalance() + amount);
                CustomerAccountDAO.updateCustomerAccount(customeraccount);
                CustomerAccountDAO.updateCustomerAccount(account);
                TransactionDAO.insertTransaction(new Transaction(-1, customeraccount.getAccountNo(), amount * -1, customeraccount.getBalance(), null));
                TransactionDAO.insertTransaction(new Transaction(-1, account.getAccountNo(), amount * -1, customeraccount.getBalance(), null));
            }
        }
        return this.checkBalance();
        
        
    }
    public boolean authenticateCustomer(String accountNo, String Pin) {
        customeraccount = getCustomerAccount(accountNo);
        if (customeraccount != null) {
            if (Pin != null) {
                return customeraccount.getPin().equals(Pin);
            }

        }
        return false;

    }

    //This is when we have created the customeraccount but we want to normal fill in the details
    private Customer getCustomer() {
        if (customeraccount != null) {

            try {

                ResultSet rs = CustomerDAO.getCustomerById(customeraccount.getCustomerCode());
                while (rs.next()) {
                    return new Customer(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6),
                            rs.getString(7), rs.getString(8),
                            rs.getString(9), rs.getString(10),
                            rs.getString(11), rs.getDate(12),
                            rs.getString(13), rs.getString(14).charAt(0));
                }

            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        return null;

    }

    public boolean updateCustomerPin(String oldValue, String newPin) {
        if (customeraccount != null) {
            if (customeraccount.getPin().equals(oldValue)) {
                customeraccount.setPin(newPin);
                CustomerAccountDAO.updateCustomerAccount(customeraccount);
                return true;
            }

        }
        return false;
    }

    public boolean updateCustomerlastName(String newValue) {
        Customer cust = getCustomer();
        if (customeraccount != null) {
            cust.setLastName(newValue);
            cust.getLastName();
            CustomerDAO.updateCustomer(cust);
            return true;
        }
        return false;
    }

    public boolean updateBalance(double newBalance) {
        if (customeraccount != null) {
            customeraccount.setBalance(newBalance);
            CustomerAccountDAO.updateCustomerAccount(customeraccount);
            return true;
        }
        return false;
    }

    public boolean updateAddress(String newValue) {
        Customer cust = getCustomer();
        if (customeraccount != null) {
            String[] values = newValue.split(":");
            cust.setAddress(values[0]);
            cust.setCity(values[1]);
            cust.setState(values[2]);
            CustomerDAO.updateCustomer(cust);
            return true;
        }
        return false;
    }

    public boolean insertCustomer(Customer customer) {
        return CustomerDAO.insertCustomer(customer);
    }

}
