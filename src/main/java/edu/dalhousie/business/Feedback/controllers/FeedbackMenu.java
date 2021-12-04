package edu.dalhousie.business.Feedback.controllers;

import edu.dalhousie.business.Feedback.constants.StringConstants;
import edu.dalhousie.presentation.StudentView;

import java.io.IOException;
import java.sql.SQLException;

public class FeedbackMenu implements IFeedbackMenu{

    StudentView view;
    int choice = 0;

    public FeedbackMenu() {
        view = new StudentView();
    }

    public void displayFeedbackMenu() throws SQLException, IOException {
        view.showMessage(StringConstants.kProvideFeedback);
        view.showMessage(StringConstants.kReadFeedbackOfTheCourse);
        view.showMessage(StringConstants.kSentimentalAnalysisOfFeedback);
        view.showMessage(StringConstants.kBackToStudentMenu);
        view.showMessage(StringConstants.kEnterYourChoice);
        choice = view.getInt();

        switch(choice){
            case 1: IProvideFeedback provideFeedback = new ProvideFeedback();
                    provideFeedback.displayProvideFeedbackMenu();
                    break;
            case 2: IDisplayFeedback displayFeedback = new DisplayFeedback();
                    displayFeedback.displayFeedback();
                    break;
            case 3: new SentimentalAnalysisOfFeedback();
                    break;
        }

    }
}