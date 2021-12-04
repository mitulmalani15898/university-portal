package edu.dalhousie.controllers;

import edu.dalhousie.business.AddNewApplication.controller.AddNewApplicationForAdmission;
import edu.dalhousie.business.DalMembership.controller.menu.MenuImplementation;
import edu.dalhousie.business.Events.controller.EventApplication;
import edu.dalhousie.business.Feedback.controllers.FeedbackMenu;
import edu.dalhousie.business.RoommateFinder.controller.RoommateFinder;
import edu.dalhousie.business.Scholarship.ScholarshipMenu;
import edu.dalhousie.business.Tender.controller.Tender.Tender;
import edu.dalhousie.business.courseregistration.controller.CourseRegistration;
import edu.dalhousie.business.facilitybooking.controller.FacilityBooking;
import edu.dalhousie.business.viewprofile.ViewProfile;
import edu.dalhousie.presentation.StudentView;

import java.util.Scanner;

public class StudentMainClass {
    StudentView view = new StudentView();
    private static final String addNewApplication = "Add new application for admission";
    private static final String profile = "Profile (Personal information and course details)";
    private static final String listOfCourses = "List of courses for registration";
    private static final String feePaymentDetails = "Fee payment details";
    private static final String feedback = "Feedback";
    private static final String applyForScholarship = "Apply for scholarships";
    private static final String organizeEvents = "Organize events";
    private static final String roommateFinder = "Roommate finder";
    private static final String healthReimbursement = "Health Reimbursement";
    private static final String nominationForSports = "Nomination for sports";
    private static final String tender = "Organize e-tender";
    private static final String dalMembership = "Dalhousie student card";
    private static final String facilityBooking = "Facility booking";
    private static final String logout = "Logout";
    public void displayStudentMenu() throws Exception {
        Scanner sc = new Scanner(System.in);

        PrintHeading.printHeadingForTheScreen("Student Menu", 45);

        view.showMessage("1. " + addNewApplication);
        view.showMessage("2. " + profile);
        view.showMessage("3. " + listOfCourses);
        view.showMessage("4. " + feePaymentDetails);
        view.showMessage("5. " + feedback);
        view.showMessage("6. " + applyForScholarship);
        view.showMessage("7. " + organizeEvents);
        view.showMessage("8. " + roommateFinder);
        view.showMessage("10. " + nominationForSports);
        view.showMessage("11. " + tender);
        view.showMessage("12. " + dalMembership);
        view.showMessage("13." + facilityBooking);
        view.showMessage("14. " + logout);
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
                    ViewProfile viewProfile = new ViewProfile();
                    viewProfile.viewProfilePage("student");
                    break;
                case 3:
                    CourseRegistration courseRegistration = new CourseRegistration();
                    courseRegistration.registerForCourses();
                    break;
                case 4:
                    //call method
                    FeesPaymentDetailsMenu feesPaymentDetails = new FeesPaymentDetailsMenu();
                    feesPaymentDetails.showPaymentInformationMenu();
                    break;
                case 5:
                    FeedbackMenu feedbackMenu = new FeedbackMenu();
                    feedbackMenu.displayFeedbackMenu();
                    break;
                case 6:
                    ScholarshipMenu scholarshipMenu = new ScholarshipMenu();
                    scholarshipMenu.displayMenu();
                    break;
                case 7:
                    EventApplication eventApplication = new EventApplication();
                    eventApplication.hostEvent();
                    break;
                case 8:
                    RoommateFinder roommateFinder = new RoommateFinder();
                    roommateFinder.displayForm();
                    break;
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
                    break;
                case 13:
                    FacilityBooking facilityBooking = new FacilityBooking();
                    facilityBooking.startFacilityBookingService();
                    break;
                case 14:
                    //call method
                    System.exit(0);
                    System.out.println("You selected 11");break;
                default: break;
            }
        }


    }
}