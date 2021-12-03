package edu.dalhousie.database;

import edu.dalhousie.models.FeedbackObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackData {

    ExecuteQuery executeQuery;

    public FeedbackData() {
        executeQuery = new ExecuteQuery();
    }

    public void storeData(FeedbackObjectModel feedbackObjectModel) throws SQLException {
        String courseID = feedbackObjectModel.getCourseID();
        String feedback = feedbackObjectModel.getFeedback();
        int professorRating = feedbackObjectModel.getProfessorRating();
        int difficultyLevel = feedbackObjectModel.getDifficultyLevel();
        int recommendation = feedbackObjectModel.getRecommendation();
        int professionalDevelopment = feedbackObjectModel.getProfessionalDevelopment();
        int needsMet = feedbackObjectModel.getNeedsMet();

        String query = "insert into feedback " +  "values ('"+ "vignesh2" +"', '" + courseID+ "','" + feedback+ "','" + professorRating + "', '" + difficultyLevel + "', '" + recommendation + "', '" + professionalDevelopment + "', '" + needsMet + "')";
        executeQuery.executeSQL(query);
    }

    public List<String> retrieveData(String courseID) throws SQLException {
        List<String> feedbackList = new ArrayList<>();

        String feedback = "";
        String query = "select feedback from feedback where courseID = '" + courseID + "' ";
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while(rs.next()){
            feedback = rs.getString("feedback");
            System.out.println(feedback);
            feedbackList.add(feedback);
        }
        return feedbackList;
    }

}
