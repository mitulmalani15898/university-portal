package edu.dalhousie.business.Feedback.controllers;

import edu.dalhousie.business.AddNewApplication.constants.StringConstants;

public class FeedbackMenuFactory {

    public static IFeedbackMenu getFeedbackMenu(String feedbackMenu) {

        IFeedbackMenu feedback = null;

        if(feedbackMenu == null) {
            return null;
        } else if (feedbackMenu == StringConstants.kFeedbackMenu) {
            feedback = new FeedbackMenu();
        }

        return feedback;

    }
}
