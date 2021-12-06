package edu.dalhousie.business.scholarship.controller;

import edu.dalhousie.business.scholarship.constants.StringConstants;
import edu.dalhousie.business.scholarship.data.ScholarshipData;
import edu.dalhousie.business.scholarship.business.ComputeScholarshipResult;
import edu.dalhousie.presentation.StudentView;

public class Scholarship {

    StudentView view;
    ComputeScholarshipResult computeScholarshipResult;
    ScholarshipData scholarShipData;

    private String courseName;
    private String userName;

    public Scholarship() {
        view = new StudentView();
        computeScholarshipResult = new ComputeScholarshipResult();
    }

    public void enterDetailsMenu() throws Exception {
        view.showMessage(StringConstants.kCourseName);
        courseName = view.getString();

        view.showMessage(StringConstants.kUserName);
        userName = view.getString();

        scholarShipData = new ScholarshipData(userName, courseName);
        String score = scholarShipData.getData();

        String decision = computeScholarshipResult.computeResult(Float.parseFloat(score));
        view.showMessage(decision);
    }
}
