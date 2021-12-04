package edu.dalhousie.business.Feedback.controllers;

import java.io.IOException;
import java.sql.SQLException;

public interface ISentimentalAnalysisOfFeedback {
    public void inputCourseID () throws SQLException, IOException;
    public void displaySentimentalAnalysisOfFeedback(String courseID) throws SQLException, IOException;
}
