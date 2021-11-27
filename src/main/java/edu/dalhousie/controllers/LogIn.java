package edu.dalhousie.controllers;

import edu.dalhousie.database.ExecuteQuery;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.Scanner;

public class LogIn {
    /*private static String UserName = "raj.patel";
    private static String UserPassword = "rp12345";
    private static String hashedUserPassword = doPasswordHashing(UserPassword);*/

    public static String[] getUserLoginDetails() {
        /*System.out.println("******************************************************************");
        System.out.println("\t \t \t \t \t \t Student Login \t");
        System.out.println("******************************************************************");*/

        /*System.out.println("******************************************************************");
        System.out.println("\t \t \t \t \t \t Faculty Login \t");
        System.out.println("******************************************************************");*/

        System.out.print("Enter your Username: ");
        Scanner enterusername = new Scanner(System.in);
        String username = enterusername.nextLine();

        System.out.print("Enter your Password: ");
        Scanner enterpassword = new Scanner(System.in);
        String userpassword = enterpassword.nextLine();

        String hashedpassword = doPasswordHashing(userpassword);

        String[] input = new String[2];
        input[0] = username;
        input[1] = hashedpassword;
        return input;
    }

    public static String doPasswordHashing(String hashpassword) {
        try {
            MessageDigest passwordDigest = MessageDigest.getInstance("SHA");
            passwordDigest.update(hashpassword.getBytes());
            byte[] resultPassword = passwordDigest.digest();
            StringBuilder strbuild = new StringBuilder();

            for (byte pwd : resultPassword) {
                strbuild.append(String.format("%02x", pwd));
            }
            return strbuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void loginUser(String typeOfLogIn) throws Exception {
        String title = typeOfLogIn.equals("student") ? "LogIn as a student" : "LogIn as a faculty";
        //utility.printHeadingForTheScreen(title, 38);
        ExecuteQuery executeQuery = new ExecuteQuery();
        String SQL = "SELECT userName, userPassword FROM users";
        ResultSet rs = executeQuery.executeUpdateSQL(SQL);

        String[] userdetails;
        userdetails = getUserLoginDetails();


        while (rs.next()) {
            String username = rs.getString("userName");
            String userpassword = rs.getString("userPassword");

            if (userdetails[0].equals(username) && userdetails[1].equals(userpassword)) {
                System.out.println("Verifying your credentials. . .");
                System.out.println("Credentials verified. . .");
                System.out.println("\nForwarding you to the main page. . .");

                if (typeOfLogIn.equals("student")) {
                    //call Student method
                    //StudentMainClass.displayStudentMenu();
                } else {
                    //call Faculty method
                }
            } else {
                System.out.println("You have entered the wrong credentials.");
                System.out.println("Please try again.\n");
            }
        }

    }

}
