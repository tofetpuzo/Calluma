/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.controller;

import java.util.ArrayList;
import kebank_datababse.model.AccountDAO;
import kebank_datababse.model.CustomerAccountDAO;
import kebank_datababse.model.entities.Accounts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebank_datababse.model.CustomerDAO;
import kebank_datababse.model.entities.Customer;
import kebank_datababse.model.entities.CustomerAccount;

/**
 *
 * @author femitemiola
 */
public class BankController {

    private static final ArrayList<Accounts> accountType = new ArrayList<>();

    public static boolean deleteCustomerById(String account_No) {
        return CustomerAccountDAO.deleteCustomerAccount(account_No);
    }

    public double checkBalance(String accountNo) {
        ResultSet rs = CustomerAccountDAO.getCustomerAccountbyAccountNo(accountNo);
        if (rs != null) {
            try {
                while (rs.next()) {
                    return rs.getDouble("balance");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }

    public boolean authenticate(String username, String Password) {
        if (username.equalsIgnoreCase("admin")) {
            if (Password.equals("ambc")) {
                return true;
            }
        }

        return false;

    }
    
    public boolean addCustomerAccount(CustomerAccount customeraccount){
        return CustomerAccountDAO.insertCustomerAccount(customeraccount);
    }
    
    public boolean deleteCustomerAccount(String accountNo){
        return CustomerAccountDAO.deleteCustomerAccount(accountNo);
    }
    
    public ResultSet getallCustomerAccount(){
        return CustomerAccountDAO.getAllCustomersAccounts();
    }
    
    public ArrayList getAllAccounts() {
        ResultSet rs = AccountDAO.getAllAccounts();
        try {
            while (rs.next()) {
                accountType.add(new Accounts(rs.getInt(1), rs.getString(2)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accountType;
    }

    // get a particular customer
    public Customer getCustomersbyData(String firstName, String middleName, String lastName, char gender, Date dob) {
        Customer cust = null;
        try {

            ResultSet rs = CustomerDAO.getCustomerbyData(firstName, middleName, lastName, gender, dob);
            while (rs.next()) {
                cust = new Customer(rs.getInt(1), rs.getString(2),
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
        return cust;
    }

}