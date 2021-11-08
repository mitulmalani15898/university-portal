package edu.dalhousie.controllers;

import edu.dalhousie.business.EmergencyGrantBusiness;
import edu.dalhousie.presentation.StudentView;

public class EmergencyGrants {

    private String kCourseName = "Enter your course name";
    private String kUserName = "Enter your username";
    private String kPurposeOfGrant = "Enter the purpose of grant: (1. Emergency 2. Conference)";
    private String kModeOfTravel = "Enter mode of travel: (1. By road 2. By air)";
    private String kAmountForGrant = "Enter amount for grant";
    private String kProcessing = "Please wait while we are processing your request..";

    private String courseName;
    private String userName;
    private int purpose;
    private int mode;

    public void enterDetailsMenu() {
        StudentView view = new StudentView();

        view.showMessage("1. " + kCourseName);
        courseName = view.getString();

        view.showMessage("2. " + kUserName);
        userName = view.getString();

        view.showMessage("3. " + kPurposeOfGrant);
        purpose = view.getInt();

        view.showMessage("4. " + kModeOfTravel);
        mode = view.getInt();

        view.showMessage(kProcessing);

        EmergencyGrantBusiness emergencyGrantBusiness = new EmergencyGrantBusiness();
        view.showMessage(emergencyGrantBusiness.computeResult());

    }
}
