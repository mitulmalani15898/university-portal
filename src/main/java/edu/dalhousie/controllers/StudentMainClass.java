package edu.dalhousie.controllers;

import edu.dalhousie.business.DalMembership.controller.menu.MenuImplementation;
import edu.dalhousie.business.Events.controller.EventApplication;
import edu.dalhousie.business.Tender.controller.Tender.Tender;

import java.util.Scanner;

public class StudentMainClass {

    public void displayStudentMenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT MENU");
        
        String kAddNewApplication = "Add new application for admission";
        String kApplyForScholarship = "Apply for scholarships";
        String kFeePaymentDetails = "Fee payment details";
        String kListOfCourses = "List of courses for registration";
        String kProfile = "Profile (Personal information and course details)";
        String kHealthReimbursement = "Health Reimbursement";
        String kLogout = "Logout";
        String kNominationForSports = "Nomination for sports";
        String kRoommateFinder = "Roommate finder";
        String kOrganizeEvents = "Organize events";
        String kFeedback = "Feedback";
        String kTender = "Organize e-tender";
        String kDalMembership = "Dalhousie student card";

        System.out.println("1 " + kAddNewApplication + "\n" +
                "2 " + kProfile + "\n" +
                "3 " + kListOfCourses + "\n" +
                "4 " + kFeePaymentDetails + "\n" +
                "5 " + kFeedback + "\n" +
                "6 " + kApplyForScholarship + "\n" +
                "7 " + kOrganizeEvents + "\n" +
                "8 " + kRoommateFinder + "\n" +
                "9 " + kHealthReimbursement + "\n" +
                "10 " + kNominationForSports + "\n" +
                "11 " + kTender + "\n" +
                "12 "+kDalMembership+ "\n" +
                "13 " + kLogout);

        while(true){
            System.out.println("Enter your choice\n");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    //call method
                    AddNewApplicationForAdmission addNew = new AddNewApplicationForAdmission();
                    addNew.showNewForm();
                    break;
                case 2:
                    //call method
                    System.out.println("You selected 2");break;
                case 3:
                    //call method
                    System.out.println("You selected 3");break;
                case 4:
                    //call method
                    FeesPaymentDetailsMenu feesPaymentDetails = new FeesPaymentDetailsMenu();
                    feesPaymentDetails.showPaymentInformationMenu();
                    break;
                case 5:
                    //call method
                    System.out.println("You selected 5");break;
                case 6:
                    //call method
                    System.out.println("You selected 6");break;
                case 7:
                    //call method
                    EventApplication eventApplication = new EventApplication();
                    eventApplication.hostEvent();
                    break;
                case 8:
                    //call method
                    System.out.println("You selected 8");break;
                case 9:
                    //call method
                    System.out.println("You selected 9");break;
                case 10:
                    //call method
                    System.out.println("You selected 10");break;
                case 11:
                    //call method
                    Tender tender =new Tender();
                    tender.getTenderData();
                    break;
                case 12:
                    //call method
                    MenuImplementation menu = new MenuImplementation();
                    menu.start();
                case 13:
                    //call method
                    System.exit(0);
                    System.out.println("You selected 11");break;
                default: break;
            }
        }


    }
}