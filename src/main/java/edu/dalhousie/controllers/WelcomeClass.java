package edu.dalhousie.controllers;

import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

public class WelcomeClass {
    private int userChoice;
    private static final String registerAsStudent = "Register as a Student";
    private static final String registerAsFaculty = "Register as a Faculty";
    private static final String loginAsStudent = "Login as a Student";
    private static final String loginAsFaculty = "Login as a Faculty";
    private static final String exit = "Exit";

    public void displayWelcomeScreen() {
        StudentView view = new StudentView();

        Utility.printHeadingForTheScreen("Welcome to university portal", 35);

        view.showMessage("1. " + registerAsStudent);
        view.showMessage("2. " + registerAsFaculty);
        view.showMessage("3. " + loginAsStudent);
        view.showMessage("4. " + loginAsFaculty);
        view.showMessage("5. " + exit);

        System.out.print("\nEnter your choice: ");
        userChoice = view.getInt();

        switch (userChoice) {
            case 1:
                Registration studentRegistration = new Registration();
                studentRegistration.registerUser("student");
                break;
            case 2:
                Registration facultyRegistration = new Registration();
                facultyRegistration.registerUser("faculty");
                break;
            case 3:
                //call method
                view.showMessage("selected 3");
                break;
            case 4:
                //call method
                view.showMessage("selected 4");
                break;
            case 5:
                System.exit(0);
            default:
                break;
        }

    }
}