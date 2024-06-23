/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.model;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebank_datababse.connect.Connect;
import kebank_datababse.model.entities.CustomerAccount;

/**
 *
 * @author femitemiola
 */

public class CustomerAccountDAO {

    static CustomerAccount customeraccount = null;

    static Connection con = null;
    // Print out all the whole customers have
    
    public static ResultSet getAllCustomersAccounts() {
        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "SELECT ca.accountNo as \"Account NO\", ca.customercode, ca.accountcode, ca.pin,"
                        + " ca.balance, ca.dateCreated as \" Opening date\" as a.name as \"Account Type\", "
                        + "concat(c.firstname, '', c.lastname) as Fullname"
                        + "from customeraccount "
                        + "ca join accounts a ON ca.customercode = a.accountcode ca join customer c ON ca.customercode = c.customercode ";
                ResultSet rs = smt.executeQuery(query);
                return rs;

            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ResultSet getCustomerAccountbyAccountNo(String account_No) {

        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "SELECT ca.accountNo as \"Account NO\", ca.customercode, ca.accountcode, ca.pin,"
                        + " ca.balance, ca.dateCreated as \" Opening date\" as a.name as \"Account Type\", "
                        + "concat(c.firstname, '', c.lastname) as Fullname"
                        + "from customeraccount "
                        + "ca join accounts a ON ca.customercode = a.accountcode ca join customer c ON ca.customercode = c.customercode "
                        + "where accountNo= '" + account_No + "'";
                ResultSet rs = smt.executeQuery(query);
                return rs;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static boolean updateCustomerAccount(CustomerAccount customeraccount) {
       

        int status = 0;
        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "update customeraccount set pin = '" + customeraccount.getPin() + "', " + "balance = " + "', '" + customeraccount.getBalance()
                        + "', " + " status = '" + customeraccount.getStatus() + "', " + " where accountNo =  " + "'" + customeraccount.getAccountNo() + "'";
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean insertCustomerAccount(CustomerAccount customeraccount) {
        int status = 0;
        try {
            //String AccountNo, int customerCode, int accountCode, String Pin, double balance, Date dateCreated, String status
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "INSERT into customeraccount VALUES(accountNo, customerCode, accountCode, pin, balance, dateCreated, status ) "
                        + "values('" + customeraccount.getAccountNo() + "' ," + customeraccount.getCustomerCode() + " ,'"
                        + customeraccount.getPin() + "'," + customeraccount.getBalance() + ", '" + ", NULL ," + "'Active')";
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean deleteCustomerAccount(String account_No) {
        int status = 0;
        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "DELETE from customeraccount where accountNo= '" + account_No + "'";
                status = smt.executeUpdate(query);
                if (status > 0){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

}
