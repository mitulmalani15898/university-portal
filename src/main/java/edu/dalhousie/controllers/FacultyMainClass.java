package edu.dalhousie.controllers;

import edu.dalhousie.presentation.StudentView;

public class FacultyMainClass {
    StudentView view = new StudentView();

    private int userChoice;
    private static final String profile = "Profile";
    private static final String studentGrading = "Student Grading";
    private static final String eTender = "E-tender for canteen";
    private static final String logout = "Logout";

    public void displayFacultyMenu() {
        PrintHeading.printHeadingForTheScreen("Faculty Menu", 45);

        System.out.println("1. " + profile);
        System.out.println("2. " + studentGrading);
        System.out.println("3. " + eTender);
        System.out.println("4. " + logout);

        System.out.println("\nEnter your choice:");
        userChoice = view.getInt();

        switch (userChoice) {
            case 1:
                //call method
                System.out.println("You selected 1");
                break;
            case 2:
                //call method
                System.out.println("You selected 2");
                break;
            case 3:
                //call method
                System.out.println("You selected 3");
                break;
            case 4:
                //call method
                System.out.println("You selected 4");
                break;
            default:
                break;
        }
    }
}
