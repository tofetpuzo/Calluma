/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.connect;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author femitemiola
 */
import java.sql.SQLException;

public class Connect {

    static String url = "jdbc:mysql://localhost:3306/kebank";
    static String user = "root";
    static String pass = "your_password_here";
    static Connection con = null;

    private Connect() {
        // private constructor to hide the implicit public one
    }

    private static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, pass);

        return con;

    }

}
