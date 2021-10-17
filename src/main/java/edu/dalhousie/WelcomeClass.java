package edu.dalhousie;
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
//        Console console = System.console();
//        Scanner sc = new Scanner(console.reader());
//
//        if (console != null) {
//            console.writer().println("1 " + registerAsStudent + "\n" + "2 " + registerAsFaculty + "\n" + "3 " + loginAsStudent + "\n" + "4 " + loginAsFaculty + "\n" + "5 " + "Exit\n");
//            console.writer().println("Enter your choice\n");
//            choice = sc.nextInt();
//        }

        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO UNIVERSITY PORTAL");
        System.out.println("1 " + kRegisterAsStudent + "\n" + "2 " + kRegisterAsFaculty + "\n" + "3 " + kLoginAsStudent + "\n" + "4 " + kLoginAsFaculty + "\n" + "5 " + kExit);
        System.out.println("Enter your choice\n");
        choice = sc.nextInt();

        switch(choice) {
            case 1:
                //call method
//                StudentMainClass student = new StudentMainClass();
//                student.displayStudentMenu();
                System.out.println("You selected 1");break;
            case 2:
                //call method
                System.out.println("You selected 2");break;
            case 3:
                //call method
                System.out.println("You selected 3");break;
            case 4:
                //call method
                System.out.println("You selected 4");break;
            case 5:
                //call method
                System.out.println("You selected 5");break;
            default: break;
        }

    }
}