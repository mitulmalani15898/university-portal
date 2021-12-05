package edu.dalhousie.business.Feedback.business;

import edu.dalhousie.business.Feedback.constants.StringConstants;
import edu.dalhousie.business.Feedback.model.FeedbackUserInputValidationModel;

public class FeedbackUserInputValidation implements IFeedbackUserInputValidation {

    public FeedbackUserInputValidationModel validateFeedbackMenuInput(int menuInput) {
        if (menuInput>=0 && menuInput<=4) {
            return new FeedbackUserInputValidationModel(true, StringConstants.kSuccess);
        }
        return new FeedbackUserInputValidationModel(false, StringConstants.kWrongInput);
    }

}
