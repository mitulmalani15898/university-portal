package edu.dalhousie.controllers;

import edu.dalhousie.business.AddNewApplication.controller.AddNewApplicationForAdmission;
import edu.dalhousie.business.Feedback.controllers.FeedbackMenu;
import edu.dalhousie.business.RoommateFinder.controller.RoommateFinder;

import java.util.Scanner;

public class StudentMainClass {

    private int choice;

    private String kAddNewApplication = "Add new application for admission";
    private String kProfile = "Profile (Personal information and course details)";
    private String kListOfCourses = "List of courses for registration";
    private String kFeePaymentDetails = "Fee payment details";
    private String kFeedback = "Feedback";
    private String kApplyForScholarship = "Apply for scholarships";
    private String kOrganizeEvents = "Organize events";
    private String kRoommateFinder = "Roommate finder";
    private String kHealthReimbursement = "Health Reimbursement";
    private String kNominationForSports = "Nomination for sports";
    private String kLogout = "Logout";

    public void displayStudentMenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT MENU");
        System.out.println("1 " + kAddNewApplication + "\n" + "2 " + kProfile + "\n" + "3 " + kListOfCourses + "\n" + "4 " + kFeePaymentDetails + "\n" + "5 " + kFeedback
                + "\n" + "6 " + kApplyForScholarship + "\n" + "7 " + kOrganizeEvents + "\n" + "8 " + kRoommateFinder + "\n" + "9 " + kHealthReimbursement + "\n" + "10 " + kNominationForSports + "\n" + "11 " + kLogout);

        System.out.println("Enter your choice\n");
        choice = sc.nextInt();

        switch(choice) {
            case 1:
                //call method
                AddNewApplicationForAdmission addNew = new AddNewApplicationForAdmission();
                addNew.showNewForm();
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
                FeedbackMenu feedbackMenu = new FeedbackMenu();
                feedbackMenu.displayFeedbackMenu();
                break;
            case 6:
                //call method
                ScholarshipMenu scholarshipMenu = new ScholarshipMenu();
                scholarshipMenu.displayMenu();
            case 7:
                //call method
                System.out.println("You selected 7");break;
            case 8:
                RoommateFinder roommateFinder = new RoommateFinder();
                roommateFinder.displayForm();
            case 9:
                //call method
                System.out.println("You selected 9");break;
            case 10:
                //call method
                System.out.println("You selected 10");break;
            case 11:
                //call method
                System.out.println("You selected 11");break;
            default: break;
        }

    }
}