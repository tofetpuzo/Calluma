/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.model;

/**
 *
 * @author femitemiola
 */
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebank_datababse.connect.Connect;
import kebank_datababse.model.entities.Accounts;

public class AccountDAO {

    static Connection con = null;

    public static ResultSet getAllAccounts() {

        try {
            //con accesses all the information from mysql
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "SELECT * FROM accounts";
                ResultSet rs = smt.executeQuery(query);
                while (rs.next()) {
                    return rs;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static boolean DeleteAccountbyId(int account_id) {
        int status = 0;
        try {

            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "delete FROM accounts where accountcode = " + account_id;
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean updateAccountbyId(Accounts account) {
        int status = 0;
        try {

            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "upate Accounts set name= " + account.getName();
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean insertAccountbyId(Accounts account) {
        int status = 0;
        try {

            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "insert into accounts (name) values ('" + account.getName() + "') ";                
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
