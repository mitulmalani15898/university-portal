package edu.dalhousie.business.Feedback.data;

import edu.dalhousie.business.Feedback.model.FeedbackObjectModel;

import java.sql.SQLException;
import java.util.List;

public interface IFeedbackData {
    public void storeData(FeedbackObjectModel feedbackObjectModel) throws SQLException;
    public List<String> retrieveData(String courseID) throws SQLException;
}
