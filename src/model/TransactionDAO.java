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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kebank_datababse.connect.Connect;
import java.sql.Statement;
import kebank_datababse.model.entities.Transaction;

public class TransactionDAO {

    static Connection con = null;
    

    public static ResultSet getAllTransactions() {
        try {
            con = Connect.getConnection();

            if (con != null) {
                Statement smt = con.createStatement();
                String query = "SELECT * FROM transactions";
                ResultSet rs = smt.executeQuery(query);
                while (rs.next()) {
                    return rs;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean insertTransaction(Transaction transaction) {
        try {
            con = Connect.getConnection();
            int status = 0;
            if (con != null) {
                Statement smt = con.createStatement();
                String query = "INSERT into transactions(trxnCode, accountNo, amount, workingBalance, trxnDate) "
                        + "values(NULL,'" + transaction.getAccountNo() + "', " + transaction.getAmount()
                        + ", " + transaction.getWorkingBalance() + ", NULL)";
                status = smt.executeUpdate(query);
                if (status > 0) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ResultSet getTransactionById(int trxn_id) {
        try {
            con = Connect.getConnection();

            if (con != null) {
                Statement smt = con.createStatement();
                String query = "SELECT * FROM transactions where trxnCode= " + trxn_id;
                ResultSet rs = smt.executeQuery(query);
                while (rs.next()) {
                    return rs;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
