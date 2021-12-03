package edu.dalhousie.controllers;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.presentation.StudentView;

import java.io.IOException;
import java.sql.SQLException;

public class FeedbackMenu {

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
            case 1: ProvideFeedback provideFeedback = new ProvideFeedback();
                    provideFeedback.displayProvideFeedbackMenu();
                    break;
            case 2: DisplayFeedback displayFeedback = new DisplayFeedback();
                    displayFeedback.displayFeedback();
                    break;
            case 3: new SentimentalAnalysisOfFeedback();
                    break;
        }

    }
}
