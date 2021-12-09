package edu.dalhousie.controllers;

import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Hashing;
import edu.dalhousie.utilities.printing.PrintHeading;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    private IDatabaseConnection IDatabaseConnection;

    public Login(){
        this.IDatabaseConnection = DatabaseConnectivity.getInstance();

    }
    public static String[] getUserLoginDetails() {
        Hashing performHashing = new Hashing();
        System.out.print("Enter your Username: ");
        Scanner enterusername = new Scanner(System.in);
        String username = enterusername.nextLine();

        System.out.print("Enter your Password: ");
        Scanner enterpassword = new Scanner(System.in);
        String userpassword = enterpassword.nextLine();

        String hashedpassword = performHashing.doPasswordHashing(userpassword);

        String[] input = new String[2];
        input[0] = username;
        input[1] = hashedpassword;
        return input;
    }

    public User loginUser(String typeOfLogIn) throws Exception {
        String title = typeOfLogIn.equalsIgnoreCase("STUDENT") ? "Login as a Student" : "Login as a Faculty";
        PrintHeading.printHeadingForTheScreen(title, 38);
        final Connection connection =
                IDatabaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();

        String[] userdetails;
        userdetails = getUserLoginDetails();

        String SQL = String.format("SELECT * FROM users u INNER JOIN " +
                "membership_details md on md.member_id = u.id WHERE user_name = '%s' AND password = '%s'", userdetails[0],userdetails[1]);
        ResultSet rs = statement.executeQuery(SQL);

        String userName = null;
        String userPassword = null;
        String phoneNumber = null;
        String address = null;
        int balance = 0;
        String firstName = null;
        String lastName = null;
        int userId = 0;
        while (rs.next()) {
            userName = rs.getString("user_name");
            userPassword = rs.getString("password");
            phoneNumber = rs.getString("contact_number");
            address = rs.getString("address");
            balance = rs.getInt("balance");
            firstName = rs.getString("first_name");
            lastName = rs.getString("last_name");
            userId = rs.getInt("id");
        }
        if (userdetails[0].equals(userName) && userdetails[1].equals(userPassword)) {
            System.out.println("\nVerifying your credentials. . .");
            System.out.println("Credentials verified. . .");
            System.out.println("\nForwarding you to the main page. . .");

            if (typeOfLogIn.equals("STUDENT")) {

                return new User.Builder()
                        .setUserId(userId)
                        .setUserName(userName)
                        .setPassword(userPassword)
                        .setAddress(address)
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setPhoneNumber(phoneNumber)
                        .setBalance(balance)
                        .build();
            } else {

            }
        } else {
            System.out.println("\nYou have entered the wrong credentials.");
            System.out.println("Please try again.\n");
        }
        return null;
    }

}
