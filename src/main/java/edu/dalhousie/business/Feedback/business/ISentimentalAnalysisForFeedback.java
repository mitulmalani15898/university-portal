package edu.dalhousie.business.Feedback.business;

import edu.dalhousie.business.Feedback.model.SentimentAnalysisFeedbackModel;

import java.io.IOException;
import java.util.List;

public interface ISentimentalAnalysisForFeedback {
    public SentimentAnalysisFeedbackModel
    computeSentimentalAnalysis(List<String> feedbacks) throws IOException;
}
