package edu.dalhousie.controllers;

import edu.dalhousie.business.FeedbackBusiness;
import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.database.FeedbackData;
import edu.dalhousie.models.SentimentAnalysisFeedback;
import edu.dalhousie.presentation.StudentView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SentimentalAnalysisOfFeedback {

    StudentView studentView;
    FeedbackData feedbackData;
    FeedbackBusiness feedbackBusiness;

    String courseID;

    public SentimentalAnalysisOfFeedback() throws SQLException, IOException {
        studentView = new StudentView();
        feedbackData = new FeedbackData();
        feedbackBusiness = new FeedbackBusiness();
        inputCourseID();
    }

    public void inputCourseID () throws SQLException, IOException {
        studentView.showMessage(StringConstants.kEnterCourseIDForSentimentalAnalysisOfFeedback);
        courseID = studentView.getString();
        displaySentimentalAnalysisOfFeedback(courseID);
    }

    public void displaySentimentalAnalysisOfFeedback(String courseID) throws SQLException, IOException {
        List<String> feedbacks = feedbackData.retrieveData(courseID);
        SentimentAnalysisFeedback sentimentAnalysisFeedback = feedbackBusiness.computeSentimentalAnalysis(feedbacks);
        studentView.showMessage(StringConstants.kPolarity + sentimentAnalysisFeedback.getPolarity());
        studentView.showMessage(StringConstants.kPositiveWords + sentimentAnalysisFeedback.getPositiveWords().toString());
        studentView.showMessage(StringConstants.kNegativeWords + sentimentAnalysisFeedback.getNegativeWords().toString());
    }

}