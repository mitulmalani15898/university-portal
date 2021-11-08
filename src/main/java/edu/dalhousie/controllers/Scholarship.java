package edu.dalhousie.controllers;

import edu.dalhousie.business.ScholarshipBusiness;
import edu.dalhousie.presentation.StudentView;

public class Scholarship {

    private String kCourseName = "Enter your course name";
    private String kUserName = "Enter your user name";
    private String kCalculatingEligibility = "Calculating your eligibility for scholarship";
    private String kAccepted = "Congratulations! You're eligible for scholarship";

    private String courseName;
    private String userName;

    public void enterDetailsMenu() {
        StudentView view = new StudentView();

        view.showMessage("1. " + kCourseName);
        courseName = view.getString();

        view.showMessage("2. " + kUserName);
        userName = view.getString();

        ScholarshipBusiness scholarshipBusiness = new ScholarshipBusiness(courseName, userName);
        scholarshipBusiness.computeResult();

        StudentMainClass student = new StudentMainClass();
        student.displayStudentMenu();
    }
}
