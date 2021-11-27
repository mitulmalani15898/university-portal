package edu.dalhousie.controllers;

import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

public class StudentMainClass {
    Utility utility = new Utility();
    StudentView view = new StudentView();

    private int userChoice;
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
    private static final String logout = "Logout";

    public void displayStudentMenu() throws Exception {
        utility.printHeadingForTheScreen("Student Menu", 45);

        view.showMessage("1. " + addNewApplication);
        view.showMessage("2. " + profile);
        view.showMessage("3. " + listOfCourses);
        view.showMessage("4. " + feePaymentDetails);
        view.showMessage("5. " + feedback);
        view.showMessage("6. " + applyForScholarship);
        view.showMessage("7. " + organizeEvents);
        view.showMessage("8. " + roommateFinder);
        view.showMessage("9. " + healthReimbursement);
        view.showMessage("10. " + nominationForSports);
        view.showMessage("11. " + logout);

        view.showMessage("\nEnter your choice: ");
        userChoice = view.getInt();

        switch (userChoice) {
            case 1:
                AddNewApplicationForAdmission addNew = new AddNewApplicationForAdmission();
                addNew.showNewForm();
            case 2:
                //call method
                view.showMessage("You selected 2");
                break;
            case 3:
                //call method
                view.showMessage("You selected 3");
                break;
            case 4:
                //call method
                view.showMessage("You selected 4");
                break;
            case 5:
                //call method
                view.showMessage("You selected 5");
                break;
            case 6:
                ScholarshipMenu scholarshipMenu = new ScholarshipMenu();
                scholarshipMenu.displayMenu();
            case 7:
                //call method
                view.showMessage("You selected 7");
                break;
            case 8:
                RoommateFinder roommateFinder = new RoommateFinder();
                roommateFinder.displayForm();
            case 9:
                //call method
                view.showMessage("You selected 9");
                break;
            case 10:
                //call method
                view.showMessage("You selected 10");
                break;
            case 11:
                //call method
                view.showMessage("You selected 11");
                break;
            default:
                break;
        }
    }
}