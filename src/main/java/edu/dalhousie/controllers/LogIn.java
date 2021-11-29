package edu.dalhousie.controllers;

import edu.dalhousie.database.ExecuteQuery;
import edu.dalhousie.presentation.StudentView;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

public class LogIn {

    StudentView view;
    StudentMainClass studentmenu;
    String username;
    //FacultyMainClass facultymenu;

    public LogIn() {
        view = new StudentView();
        studentmenu = new StudentMainClass();
        //facultymenu = new FacultyMainClass();
    }


    public String[] getUserLoginDetails() {

        view.showMessage("Enter your Username: ");
        username = view.getString();

        view.showMessage("Enter your Password: ");
        String userpassword = view.getString();

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
        boolean isStudent = typeOfLogIn.equals("student");
        String title = isStudent ? "LogIn as a student" : "LogIn as a faculty";
        //Utility.printHeadingForTheScreen(title, 38);
        String[] userdetails;
        userdetails = getUserLoginDetails();

        ExecuteQuery executeQuery = new ExecuteQuery();
        String SQL = String.format("SELECT user_name, password FROM users WHERE user_name = '%s' AND password = '%s'", userdetails[0], userdetails[1]);
        //String SQL = "SELECT user_name, password FROM users WHERE %s, %s";
        ResultSet rs = executeQuery.executeUpdateSQL(SQL);


        String username = null;
        String userpassword = null;
        while(rs.next()) {
            username = rs.getString("user_name");
            userpassword = rs.getString("password");
        }

        if (userdetails[0].equals(username) && userdetails[1].equals(userpassword)) {
            view.showMessage("Verifying your credentials. . .");
            view.showMessage("Credentials verified. . .");
            view.showMessage("\nForwarding you to the main page. . .");

            if (typeOfLogIn.equals("student")) {
                //call Student method
                studentmenu.displayStudentMenu();
            } else {
                //call Faculty method
                //facultymenu.displayFacultyMenu();
            }
        } else {
            view.showMessage("You have entered the wrong credentials.");
            view.showMessage("Please try again.\n");
            if (typeOfLogIn.equals("student")) {
                loginUser("student");
            } else {
                loginUser("faculty");
            }
        }

    }

}
