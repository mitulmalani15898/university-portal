package edu.dalhousie.controllers;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.presentation.StudentView;

import java.util.Scanner;

public class WelcomeClass {
    private int choice;
    private String kRegisterAsStudent = "Register as a Student";
    private String kRegisterAsFaculty = "Register as a Faculty";
    private String kLoginAsStudent = "Login as a Student";
    private String kLoginAsFaculty = "Login as a Faculty";
    private String kExit = "Login as a Faculty";

    public void displayWelcomeScreen() {
        StudentView view = new StudentView();
        StudentMainClass student = new StudentMainClass();
        Scanner sc = new Scanner(System.in);
        view.showMessage("WELCOME TO UNIVERSITY PORTAL");
        view.showMessage("1 " + kRegisterAsStudent + "\n" + "2 " + kRegisterAsFaculty + "\n" + "3 " + kLoginAsStudent + "\n" + "4 " + kLoginAsFaculty + "\n" + "5 " + kExit + "\n");
        view.showMessage("Enter your choice");
        choice = view.getInt();

        switch(choice) {
            case 1:
                student.displayStudentMenu();
                break;
            case 2:
                //call method
                view.showMessage("selected 2"); break;
            case 3:
                student.displayStudentMenu();
                break;
            case 4:
                //call method
                view.showMessage("selected 4"); break;
            case 5:
                System.exit(0);
            default: break;
        }

    }
}