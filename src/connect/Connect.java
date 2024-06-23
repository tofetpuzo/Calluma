/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author femitemiola
 */
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

    static String url;
    static String user;
    static String pass;
    static Connection con = null;

    private Connect() {
        // private constructor to hide the implicit public one
        Properties prop = new Properties();
        String env = System.getenv("APP_ENV"); // Use environment variable to determine the environment
        String propFileName = "config-" + env + ".properties";

        try (InputStream input = new FileInputStream("/path/to/config/" + propFileName)) {
            // Load the properties file
            prop.load(input);

            // Get the property values
            prop.getProperty("db.url");
            prop.getProperty("db.user");
            System.getenv("DB_PASSWORD"); // Fetch password from environment variable

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, pass);

        return con;
    }
}
