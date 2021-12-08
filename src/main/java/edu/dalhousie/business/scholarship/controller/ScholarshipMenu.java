package edu.dalhousie.business.scholarship.controller;

import edu.dalhousie.business.scholarship.constants.StringConstants;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class ScholarshipMenu {

    IStudentView view;
    int choice;

    public ScholarshipMenu() {
        view = StudentView.getInstance();
    }

    public void displayMenu() throws Exception {
        view.showMessage(StringConstants.kApplyForScholarship);
        view.showMessage(StringConstants.kBackToStudentMenu);
        choice = view.getInt();
        EScholarshipMenuOptions.valueOf(StringConstants.kScholarshipMenuOptionsSuffix + String.valueOf(choice)).displayScholarshipMenu();
    }
}
