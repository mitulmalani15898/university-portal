package edu.dalhousie.business.Feedback.controllers;

import edu.dalhousie.business.Feedback.business.FeedbackBusiness;
import edu.dalhousie.business.Feedback.business.IFeedbackBusiness;
import edu.dalhousie.business.Feedback.data.FeedbackData;
import edu.dalhousie.business.Feedback.data.IFeedbackData;
import edu.dalhousie.business.Feedback.model.SentimentAnalysisFeedback;
import edu.dalhousie.business.AddNewApplication.constants.StringConstants;
import edu.dalhousie.presentation.StudentView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SentimentalAnalysisOfFeedback implements ISentimentalAnalysisOfFeedback{

    StudentView studentView;
    IFeedbackData feedbackData;
    IFeedbackBusiness feedbackBusiness;

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