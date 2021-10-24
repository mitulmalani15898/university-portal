package edu.dalhousie;
import edu.dalhousie.presentation.StudentView;

import java.io.Console;
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
        Scanner sc = new Scanner(System.in);
        view.showMessage("WELCOME TO UNIVERSITY PORTAL");
        view.showMessage("1 \" + kRegisterAsStudent + \"\\n\" + \"2 \" + kRegisterAsFaculty + \"\\n\" + \"3 \" + kLoginAsStudent + \"\\n\" + \"4 \" + kLoginAsFaculty + \"\\n\" + \"5 \" + kExit \n");
        view.showMessage("Enter your choice");
        choice = view.getMessage();

        switch(choice) {
            case 1:
                //call method
//                StudentMainClass student = new StudentMainClass();
//                student.displayStudentMenu();
                view.showMessage("selected 1"); break;
            case 2:
                //call method
                view.showMessage("selected 2"); break;
            case 3:
                //call method
                view.showMessage("selected 3"); break;
            case 4:
                //call method
                view.showMessage("selected 4"); break;
            case 5:
                //call method
                view.showMessage(" selected 5"); break;
            default: break;
        }

    }
}