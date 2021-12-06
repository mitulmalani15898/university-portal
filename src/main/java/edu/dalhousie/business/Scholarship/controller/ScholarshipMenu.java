package edu.dalhousie.business.Scholarship.controller;

import edu.dalhousie.business.Scholarship.constants.StringConstants;
import edu.dalhousie.business.Scholarship.controller.Scholarship;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.presentation.StudentView;

public class ScholarshipMenu {

    StudentView view;
    int choice;

    public ScholarshipMenu() {
        view = new StudentView();
    }

    public void displayMenu() throws Exception {
        view.showMessage(StringConstants.kApplyForScholarship);
        view.showMessage(StringConstants.kBackToStudentMenu);
        choice = view.getInt();
        EScholarshipMenuOptions.valueOf(StringConstants.kScholarshipMenuOptionsSuffix + String.valueOf(choice)).displayScholarshipMenu();
    }
}
