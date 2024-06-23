/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import src.model.entities.Accounts;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.connect.Connect;

/**
 *
 * @author femitemiola
 */
public class Account2DAO {

    static Connection con = null;

    private Account2DAO() {
        // private constructor to hide the implicit public one
    }

    public static ResultSet getAllAccounts() {

        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "SELECT * FROM Accounts";
                ResultSet rs = smt.executeQuery(query);
                while (rs.next()) {
                    return rs;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account2DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static boolean insertAccountsById(Accounts account) {
        int status = 0;
        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "INSERT INTO Accounts (name) values= '" + account.getName() + "'";
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Account2DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteAccountById(int account_id) {
        int status = 0;

        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "delete from Accounts where accountcode='" + account_id + "'";
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Account2DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean updateAccountbyId(Accounts account) {
        int status = 0;

        try {
            con = Connect.getConnection();
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "update Accounts set name '" + account.getName() + "'";
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Account2DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
