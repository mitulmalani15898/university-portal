package edu.dalhousie.controllers;

import edu.dalhousie.business.registration.controller.Registration;
import edu.dalhousie.presentation.StudentView;

public class WelcomeClass {
    private int choice;
    private static final String registerAsStudent = "Register as a Student";
    private static final String registerAsFaculty = "Register as a Faculty";
    private static final String loginAsStudent = "Login as a Student";
    private static final String loginAsFaculty = "Login as a Faculty";
    private static final String exit = "Exit";


    public void displayWelcomeScreen() throws Exception {
        StudentView view = new StudentView();
        StudentMainClass student = new StudentMainClass();
        Login login = new Login();
        User user;
        UserSession userSession = UserSession.getInstance();
//        Scanner sc = new Scanner(System.in);
//        view.showMessage("WELCOME TO UNIVERSITY PORTAL");
//        view.showMessage("1 " + kRegisterAsStudent + "\n" + "2 " + kRegisterAsFaculty + "\n" + "3 " + kLoginAsStudent + "\n" + "4 " + kLoginAsFaculty + "\n" + "5 " + kExit + "\n");


        PrintHeading.printHeadingForTheScreen("Welcome to university portal", 35);

        view.showMessage("1. " + registerAsStudent);
        view.showMessage("2. " + registerAsFaculty);
        view.showMessage("3. " + loginAsStudent);
        view.showMessage("4. " + loginAsFaculty);
        view.showMessage("5. " + exit);
        view.showMessage("Enter your choice");
        choice = view.getInt();

        switch (choice) {
            case 1:
                student.displayStudentMenu();
                //                Registration studentRegistration = new Registration();
//                studentRegistration.registerUser("student");
                break;
            case 2:
                Registration facultyRegistration = new Registration();
                facultyRegistration.registerUser("faculty");
                break;
            case 3:
                user = login.loginUser("student");
                if (user != null) {
                    userSession.newUserSession(user);
                    student.displayStudentMenu();
                }
                break;
            case 4:
                //call method
                user = login.loginUser("faculty");
                if (user != null) {
                    userSession.newUserSession(user);
                }
            case 5:
                System.exit(0);
            default:
                break;
        }
    }
}