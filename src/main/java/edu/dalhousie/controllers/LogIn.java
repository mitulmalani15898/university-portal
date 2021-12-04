package edu.dalhousie.controllers;

import edu.dalhousie.database.ExecuteQuery;
import edu.dalhousie.models.LogInModel;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

public class LogIn {

    StudentView view;
    LogInModel loginModel;
    StudentMainClass studentMenu;
    FacultyMainClass facultyMenu;

    public LogIn() {
        view = new StudentView();
        loginModel = new LogInModel();
        studentMenu = new StudentMainClass();
        facultyMenu = new FacultyMainClass();
    }

    public String[] getUserLoginDetails() {

        view.showMessage("Enter your Username: ");
        loginModel.setUserName(view.getString());

        view.showMessage("Enter your Password: ");
        loginModel.setUserPassword(view.getString());

        loginModel.setHashedPassword(doPasswordHashing(loginModel.getUserPassword()));
        loginModel.setUserCredentials(loginModel.getUserName(),loginModel.getHashedPassword());

        return loginModel.getUserCredentials();
    }

    public String doPasswordHashing(String hashPassword) {
        try {
            MessageDigest passwordDigest = MessageDigest.getInstance("SHA");
            passwordDigest.update(hashPassword.getBytes());
            byte[] resultPassword = passwordDigest.digest();
            StringBuilder strBuild = new StringBuilder();

            for (byte pwd : resultPassword) {
                strBuild.append(String.format("%02x", pwd));
            }
            return strBuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void loginUser(String typeOfLogIn) throws Exception {
        boolean isStudent = typeOfLogIn.equals("student");
        String title = isStudent ? "LogIn as a student" : "LogIn as a faculty";
        Utility.printHeadingForTheScreen(title, 38);
        String[] userLoginDetails;
        userLoginDetails = getUserLoginDetails();

        ExecuteQuery executeQuery = new ExecuteQuery();
        String SQL = String.format("SELECT user_name, password FROM users WHERE user_name = '%s' AND password = '%s' AND type_of_user = '%s'", userLoginDetails[0], userLoginDetails[1], typeOfLogIn);
        ResultSet rs = executeQuery.executeUpdateSQL(SQL);

        while(rs.next()) {
            loginModel.setStoredUserName(rs.getString("user_name"));
            loginModel.setStoredUserPassword(rs.getString("password"));
        }

        if (userLoginDetails[0].equals(loginModel.getStoredUserName()) && userLoginDetails[1].equals(loginModel.getStoredUserPassword())) {
            view.showMessage("\nVerifying your credentials. . .");
            view.showMessage("Credentials verified. . .");
            view.showMessage("\nForwarding you to the main page. . .\n");

            if (typeOfLogIn.equals("student")) {
                //call Student method
                studentMenu.displayStudentMenu();
            } else {
                //call Faculty method
                facultyMenu.displayFacultyMenu();
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
