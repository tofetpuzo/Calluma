/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

/**
 *
 * @author femitemiola
 */
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.connect.Connect;
import src.model.entities.Customer;

public class CustomerDAO {

    static Customer customer = null;
    static Connection con = null;

    public static ResultSet getAllCustomer() {
        try {
            con = Connect.getConnection();
            if (con != null) {
                String query = "SELECT * FROM customers ";
                ResultSet rs = createCustomerStatement().executeQuery(query);
                while (rs.next()) {
                    return rs;
                }
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Statement createCustomerStatement(){
        try {
            Statement smt = con.createStatement();
            
            return smt;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public static boolean deleteCustomer(int customer_id) {
        int status = 0;
        try {
            con = Connect.getConnection();
            if (con != null) {
                //Statement smt = con.createStatement();
               
                String query = "DELETE from customers where customerCode = " + customer_id + "";
                status = createCustomerStatement().executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean insertCustomer(Customer customer) {
        String d = ((customer.getDob().getYear() + 1900) + "-" + (customer.getDob().getMonth() + 1) + "-" + (customer.getDob().getDay()));
        int status = 0;
        try {
            con = Connect.getConnection();
            if (con != null) {
                String query = "INSERT into customers (NULL, firstname, middlename, lastname, address, city, state, country, c_code, mobile, email, dob, nok, gender)"
                        + " values('" + customer.getFirstName() + "' ,'" + customer.getMiddleName() + "', '" + customer.getLastName() + "', "
                        + "'" + customer.getAddress() + "', '" + customer.getCity() + "','" + customer.getState() + "' ,'" + customer.getState() + "', "
                        + "'" + customer.getCountry() + "' , " + customer.getC_code() + "," + customer.getMobile() + ""
                        + ", '" + customer.getEmail() + "','" + d + "' ,'" + customer.getNok() + "', '" + customer.getGender() + "')";
                status = createCustomerStatement().executeUpdate(query);
                if (status > 0) {
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean updateCustomer(Customer customer){
        int status = 0;
        try {
            con = Connect.getConnection();
            if(con != null){
                String query = "update from customers set firstname = '" + customer.getFirstName()+
                        "', middlename = '" + customer.getMiddleName()+", lastname= '" 
                        + customer.getLastName()+ "', address=  '" + customer.getAddress() + "' , city= '" + customer.getCity() + 
                        "', state=  '"+ customer.getState()+ "', Country= '" + customer.getCountry()
                        + "', c_code= '" + customer.getC_code()+ "', mobile= '" + customer.getMobile() 
                        +"', dob= '" + customer.getDob() + "', nok = '" + customer.getNok() 
                        + "', gender= '" + customer.getGender() + "' where customercode =  " + customer.getCustomercode();
                status = createCustomerStatement().executeUpdate(query);
                if (status > 0){
                    return true;
                }
                
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ResultSet getCustomerbyData(String firstName, String middleName, String lastName, char gender, Date dob){
        char g = Character.toUpperCase(gender);
        String d =  ((dob.getYear() + 1900) + "-" + (dob.getMonth() + 1) + "-" + (dob.getDay()));
        try {
            con = Connect.getConnection();
            if(con != null){
                String query = "SELECT * FROM customers where firstname=  '" + (firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()) 
                        + "' and middlename= '" + (middleName.substring(0, 1).toUpperCase() + middleName.toLowerCase()) + "', lastname= '" 
                        + (lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase())+ "' and gender ='" + g + "'and dob = '" + d + "'"; 
                       ResultSet rs = createCustomerStatement().executeQuery(query);
                        return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    // This is when we have already created the customeraccount but we want to noraml fill in the details
    public static ResultSet getCustomerById(int customer_id){
        
        try {
            con = Connect.getConnection();
            if(con != null){
                String query = "SELECT * FROM customeraccount where customerCode= " + customer_id;
                ResultSet rs = createCustomerStatement().executeQuery(query);
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
}
















