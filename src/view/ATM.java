/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view;

import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import src.controller.BankController;
import src.model.CustomerAccountDAO;
import src.model.entities.Accounts;
import src.model.entities.Customer;
import src.model.entities.CustomerAccount;
import java.sql.ResultSet;
import src.controller.CustomerController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author femitemiola
 */
public class ATM {

    private static Scanner input = new Scanner(System.in).useDelimiter("\n");
    private static BankController bank = new BankController();
    private static CustomerController customer = new CustomerController();

    public static void main(String[] args) {
        int option = -1;
        if (args.length > 0) {
            option = Integer.parseInt(args[0]);
        }
        System.out.println("Welcome to KEBank");
        boolean flag = true;
        while (flag) {
            if (option < 0) {
                option = 2;
            }
            {
                switch (option) {
                    case 0:
                        System.out.println("Thank you for banking with us");
                        System.exit(0);
                    case 1:
                        String username = getDatawithLine("Enter Username: ");
                        String pwd = getDatawithLine("Enter password: ");
                        if (bank.authenticate(username, pwd)) {
                            bank_Operation();
                        } else {
                            Logger.getLogger(ATM.class.getName());
                        }
                        break;
                    case 2:
                        String accountNo = getDatawithLine("Enter your account No: ");
                        String pin = getDatawithLine("Enter pin");
                        if (customer.authenticateCustomer(accountNo, pin)) {
                            customer_Operation();
                        } else {
                           Logger.getLogger(ATM.class.getName());
                        }
                        break;
                    default:
                        Logger.getLogger(ATM.class.getName());
                        break;
                }
            }
            break;
        }

    }

    private static Customer createorGetCustomer() {
        Customer newCustomer = null;
        String firstName = getUserData("Enter FirstName: ");
        String middleName = getUserData("EntelastName: ");
        String lastName = getUserData("EntelastName: ");
        char gender = getUserData("[M]: Male\n[[F]: Female\nEnter option: ").charAt(0);
        String date[] = getUserData("Enter Date of Birth: (dd-mm-yyyy): ").split(":");
        int d = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int y = Integer.parseInt(date[2]);
        Date dob = new Date(y - 1900, (m - 1), d);

        //check if the customer exists;
        newCustomer = bank.getCustomersbyData(firstName, middleName, lastName, gender, dob);
        if (newCustomer == null) {
            String address = getUserData("Enter Address: ");
            String city = getUserData("Enter city: ");
            String state = getUserData("Enter state: ");
            String country = getUserData("Enter Country : ");
            String ccode = getUserData("Enter Country Code: ");
            String mobile = getUserData("Enter mobile: ");
            String email = getUserData("Enter email: ");
            String nok = getUserData("Enter next of kin: ");
            String pin = getUserData("Enter pin: ");

            customer.insertCustomer((new Customer(-1, firstName, middleName, lastName, address,
                    city, state, country, ccode, mobile, email, dob, nok, gender)));

            // New customer will return
            newCustomer = bank.getCustomersbyData(firstName, middleName, lastName, gender, dob);
        }
        return newCustomer;
    }

    private static int getAllAccountCodeType() {
        for (Iterator it = bank.getAllAccounts().iterator(); it.hasNext();) {
            Accounts account = (Accounts) it.next();
            if (account != null) {
                System.out.println("[" + account.getAccountcode() + " ]- " + account.getName());
            }
        }
        return Integer.parseInt(getUserData("Enter accounttype, pls enter option: "));
    }

    private static String getDatawithLine(String smt) {
        System.out.println(smt);
        return input.nextLine();
    }

    private static String getUserData(String smt) {
        System.out.println(smt);
        return input.next();
    }

    private static int getUserDataInt(String smt) {
        System.out.println(smt);
        return input.nextInt();
    }

    private static double getUserDataDouble(String smt) {
        System.out.println(smt);
        return input.nextDouble();
    }

    private static void bank_Operation() {
        while (true) {
            System.out.println("1: Check customer balance\n"
                    + "2: Create new account\n "
                    + "3: Delete an account\n "
                    + "4: Show all account\n"
                    + "5: Reset Customer PIN\n"
                    + "6: Return to previous menu\n"
                    + "Enter option: ");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    String accountNo = getUserData("Enter Account Number: ");
                    System.out.println("Account balance is: " + bank.checkBalance(accountNo));

                case 2:
                    int customerCode = createorGetCustomer().getCustomercode();
                    System.out.println(customerCode);
                    accountNo = getUserData("Enter your account number");

                    // The account type
                    int accountCode = getAllAccountCodeType();
                    double balance = getUserDataDouble("Enter balance: ");
                    if (bank.addCustomerAccount(new CustomerAccount(accountNo, customerCode, accountCode, "0000", balance, null, "Inactive"))) {
                        System.out.println("Account was successfully added");
                    } else {
                        System.out.println("Sorry unsuccessful");
                    }
                    break;
                case 3:
                    accountNo = getUserData("Enter the account you wish to delete: ");
                    if (bank.deleteCustomerAccount(accountNo)) {
                        System.out.println("Successfully deleted");
                    } else {
                        System.out.println("Unsuccessfully");
                    }
                    break;

                case 4:
                    ResultSet rs = CustomerAccountDAO.getAllCustomersAccounts();
                     {
                        try {
                            while (rs.next()) {
                                System.out.printf("Account No: %s\nAccount Type: %s\n%f\n\n", rs.getString(1),
                                        rs.getString(2), rs.getString(3), rs.getDouble(4));
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case 5:
                default:
                    break;

            }
            String status = getUserData("Do you want to perform another transaction (Y/N)").substring(0);
            if (status.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private static void customer_Operation() {
        while (true) {
            System.out.print("1. My account balance is: \n"
                    + "2. Make a deposit\n "
                    + "3. Make a withdrawal \n"
                    + "4. Make a transfer\n "
                    + "5. Update Details \n "
                    + "6. Show all my accounts \n"
                    + "Enter your option");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Your account balance is " + customer.checkBalance());
                case 2:
                    double deposited_amount = getUserDataDouble("How much do you want to deposit");
                    System.out.println("your new balance is" + customer.deposit(deposited_amount));
                case 3:
                    double withdraw_amount = getUserDataDouble("How much do you want to deposit");
                    System.out.println("Your new balance is = " + customer.withdraw(withdraw_amount));
                case 4:
                    double transfered_amount = getUserDataDouble("How much do you want to transfer");
                    String accountNo = getDatawithLine("Enter the account you wish to credit");
                    System.out.println("You new balance is " + customer.Transfer_amount(accountNo, transfered_amount));
                    System.out.println("You have transfered " + transfered_amount + "to Customer 2");
                case 5:
                    System.out.println("1: update Lastname\n2: Update Address\n3: Change Pin\n4: Recover Pin");
                    int option = getUserDataInt("Enter option: ");
                    switch (option) {
                        case 1:
                            String newLastName = getUserData("Enter your new LastName: ");
                            customer.updateCustomerlastName(newLastName);
                            break;
                        case 2:
                            String address = getUserData("Enter your address: ");
                            String city = getUserData("Enter your city: ");
                            String State = getUserData("Enter your state: ");
                            String newAddress = address + ":" + city + ":" + State;
                            customer.updateAddress(newAddress);
                        case 3:
                            String oldPin = getUserData("Enter your old Pin: ");
                            String newPin = getUserData("Enter your new Pin: ");
                            String confirmPin = getUserData("Enter your confirm Pin: ");
                            if (newPin.equals(confirmPin)) {
                                if (customer.updateCustomerPin(oldPin, newPin)) {
                                    System.out.println("Pin successfully changed");
                                } else {
                                    System.out.println("Visit our nearest branch");
                                }
                            } else {
                                System.out.println("The new pin and confirm Pin does not match");
                            }
                        case 4:
                            String email = getUserData("Enter email: ");
                            if (email.equals(email)) {
                                newPin = getUserData("Enter your new Pin: ");
                                confirmPin = getUserData("Enter your confirm Pin: ");
                                if (newPin.equals(confirmPin)) {
                                    if (customer.updateCustomerPin(confirmPin, newPin)) {
                                        System.out.println("Pin successfully changed");
                                    }

                                }

                            }
                            break;
                        case 6:
                        
                        default:
                            break;
                            
                    }
                    String customer_status = getUserData("Do you want you want to perform any transaction: ");
                    if(customer_status.equalsIgnoreCase("N")){
                        break;
                    }

            }
        }
    } 

}