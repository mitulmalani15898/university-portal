package edu.dalhousie.business.Feedback.controllers;

import edu.dalhousie.business.Feedback.model.FeedbackObjectModel;
import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.business.Feedback.data.FeedbackData;
import edu.dalhousie.presentation.StudentView;

import java.sql.SQLException;

public class ProvideFeedback {

    StudentView view;
    FeedbackObjectModel feedbackObjectModel;
    FeedbackData feedbackData;

    public ProvideFeedback() {
        view = new StudentView();
        feedbackObjectModel = new FeedbackObjectModel();
        feedbackData = new FeedbackData();
    }

    public void displayProvideFeedbackMenu() throws SQLException {
        view.showMessage(StringConstants.kEnterCourseId);
        feedbackObjectModel.setCourseID(view.getString());

        view.showMessage(StringConstants.kProvideYourFeedback);
        feedbackObjectModel.setFeedback(view.getString());

        view.showMessage(StringConstants.kRateYourProfessor);
        feedbackObjectModel.setProfessorRating(view.getInt());

        view.showMessage(StringConstants.kLevelOfDifficulty);
        feedbackObjectModel.setDifficultyLevel(view.getInt());

        view.showMessage(StringConstants.kRecommendThisCourse);
        feedbackObjectModel.setRecommendation(view.getInt());

        view.showMessage(StringConstants.kDevelopProfessionally);
        feedbackObjectModel.setProfessionalDevelopment(view.getInt());

        view.showMessage(StringConstants.kMeetYourNeeds);
        feedbackObjectModel.setNeedsMet(view.getInt());

        feedbackData.storeData(feedbackObjectModel);

        view.showMessage(StringConstants.kThankYouForFeedback);
    }

}
