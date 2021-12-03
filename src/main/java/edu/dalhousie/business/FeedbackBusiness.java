package edu.dalhousie.business;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.models.SentimentAnalysisFeedback;
import edu.dalhousie.presentation.StudentView;

import java.io.*;
import java.util.*;

public class FeedbackBusiness {

    StudentView studentView;
    SentimentAnalysisFeedback sentimentAnalysisFeedback;

    private int positiveWord = 0;
    private int negativeWord = 0;
    private int neutralWord = 0;
    private List<String> positiveWordsList;
    private List<String> negativeWordsList;


    public FeedbackBusiness() {
        studentView = new StudentView();
        positiveWordsList = new ArrayList<>();
        negativeWordsList = new ArrayList<>();
    }

    public SentimentAnalysisFeedback computeSentimentalAnalysis(List<String> feedbacks) throws IOException {
        int i;

        BufferedReader negativeWordsBufferedReader = new BufferedReader(new FileReader("negative-words.txt"));
        List<String> negativeWordList = new LinkedList<String>(); // You do not know word count, LinkedList is a better way.
        String line = null;
        while ((line = negativeWordsBufferedReader.readLine()) != null) {
            String[] words = line.toLowerCase().split("\\W+");
            negativeWordList.addAll(Arrays.asList(words));
        }
        Set<String> wordSet = new HashSet<String>(negativeWordList.size());
        wordSet.addAll(negativeWordList);

        BufferedReader positiveWordsBufferedReader = new BufferedReader(new FileReader("positive-words.txt"));
        List<String> positiveWordList = new LinkedList<String>(); // You do not know word count, LinkedList is a better way.
        String line2 = null;
        while ((line2 = positiveWordsBufferedReader.readLine()) != null) {
            String[] words = line2.toLowerCase().split("\\W+");
            positiveWordList.addAll(Arrays.asList(words));
        }
        Set<String> wordSet2 = new HashSet<String>(positiveWordList.size());
        wordSet2.addAll(positiveWordList);

        for(i =0; i< feedbacks.size();i++){
            String[] feedbackParts = feedbacks.get(i).split(" ");
            for (String word: feedbackParts) {
                if (wordSet.contains(word)) {
                    negativeWord += 1;
                    if(!negativeWordsList.contains(word)){
                        negativeWordsList.add(word);
                    }
                } else if (wordSet2.contains(word)) {
                    positiveWord += 1;
                    if(!positiveWordsList.contains(word)){
                        positiveWordsList.add(word);
                    }
                } else {
                    neutralWord += 1;
                }
            }
        }

        if (negativeWord > positiveWord) {
            return new SentimentAnalysisFeedback(StringConstants.kNegativePolarity, negativeWordsList, positiveWordsList);
        } else if (positiveWord > negativeWord){
            return new SentimentAnalysisFeedback(StringConstants.kPositivePolarity, negativeWordsList, positiveWordsList);
        }
        return new SentimentAnalysisFeedback(StringConstants.kNeutralPolarity, negativeWordsList, positiveWordsList);
    }
}