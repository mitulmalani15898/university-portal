package edu.dalhousie.business;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.models.SentimentAnalysisFeedback;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackBusinessTest {

    @Test
    public void testNegativeSentimentalAnalysis() throws IOException {
        FeedbackBusiness feedbackBusiness = new FeedbackBusiness();
        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("exceptional course");
        feedbacks.add("bad");
        feedbacks.add("irrelevant topics");
        feedbacks.add("frightening");
        SentimentAnalysisFeedback sentimentAnalysisFeedback = feedbackBusiness.computeSentimentalAnalysis(feedbacks);
        assertEquals(StringConstants.kNegativePolarity, sentimentAnalysisFeedback.getPolarity());
    }

    @Test
    public void testPositiveSentimentalAnalysis() throws IOException {
        FeedbackBusiness feedbackBusiness = new FeedbackBusiness();
        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("exceptional course");
        feedbacks.add("brilliant teaching");
        feedbacks.add("irrelevant topics");
        feedbacks.add("clear and precise");
        SentimentAnalysisFeedback sentimentAnalysisFeedback = feedbackBusiness.computeSentimentalAnalysis(feedbacks);
        assertEquals(StringConstants.kPositivePolarity, sentimentAnalysisFeedback.getPolarity());
    }

    @Test
    public void testFeedbackList() throws IOException {
        FeedbackBusiness feedbackBusiness = new FeedbackBusiness();
        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("exceptional course");
        feedbacks.add("brilliant teaching");
        feedbacks.add("irrelevant topics");
        feedbacks.add("clear and precise");
        feedbacks.add("bad");
        feedbacks.add("irrelevant topics");
        feedbacks.add("frightening");
        SentimentAnalysisFeedback sentimentAnalysisFeedback = feedbackBusiness.computeSentimentalAnalysis(feedbacks);
        assertEquals(7, feedbacks.size());
    }
}