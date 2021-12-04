package edu.dalhousie.business.Feedback.business;

import edu.dalhousie.business.Feedback.model.SentimentAnalysisFeedback;

import java.io.IOException;
import java.util.List;

public interface IFeedbackBusiness {
    public SentimentAnalysisFeedback
    computeSentimentalAnalysis(List<String> feedbacks) throws IOException;
}
