package edu.dalhousie.controllers;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.database.FeedbackData;
import edu.dalhousie.presentation.StudentView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayFeedback {

    List<String> feedback;
    FeedbackData feedbackData;
    StudentView view;

    public DisplayFeedback() {
        feedback = new ArrayList<>();
        feedbackData = new FeedbackData();
        view = new StudentView();
    }

    public void displayFeedback() throws SQLException {
        view.showMessage(StringConstants.kEnterCourseIDForFeedbackRetrieval);
        String courseID = view.getString();
        feedback = feedbackData.retrieveData(courseID);
    }
}
