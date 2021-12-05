package edu.dalhousie.business.Feedback.business;

import edu.dalhousie.business.Feedback.model.FeedbackUserInputValidationModel;

public interface IFeedbackUserInputValidation {
    public FeedbackUserInputValidationModel validateFeedbackMenuInput(int menuInput);
}
