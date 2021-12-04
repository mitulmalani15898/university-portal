package edu.dalhousie.business.Feedback.data;

import edu.dalhousie.business.Feedback.model.FeedbackObjectModel;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackData implements IFeedbackData {

//    ExecuteQuery executeQuery;
    private static DatabaseConnection databaseConnection;


    public FeedbackData() {
//        executeQuery = new ExecuteQuery();
        databaseConnection = DatabaseConnectivity.getInstance();
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
//        executeQuery.executeSQL(query);
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }


    public List<String> retrieveData(String courseID) throws SQLException {
        List<String> feedbackList = new ArrayList<>();

        String feedback = "";
        String query = "select feedback from feedback where courseID = '" + courseID + "' ";
//        ResultSet rs = executeQuery.executeUpdateSQL(query);
//        while(rs.next()){
//            feedback = rs.getString("feedback");
//            System.out.println(feedback);
//            feedbackList.add(feedback);
//        }
//        return feedbackList;

        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                feedback = rs.getString("feedback");
                System.out.println(feedback);
                feedbackList.add(feedback);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return feedbackList;
    }

}
