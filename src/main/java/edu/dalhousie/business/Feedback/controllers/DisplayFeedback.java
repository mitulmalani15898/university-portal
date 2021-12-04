package edu.dalhousie.business.Feedback.controllers;

import edu.dalhousie.business.Feedback.data.FeedbackData;
import edu.dalhousie.business.AddNewApplication.constants.StringConstants;
import edu.dalhousie.business.Feedback.data.IFeedbackData;
import edu.dalhousie.presentation.StudentView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayFeedback implements IDisplayFeedback {

    List<String> feedback;
    IFeedbackData feedbackData;
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
