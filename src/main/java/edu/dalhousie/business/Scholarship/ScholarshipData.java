package edu.dalhousie.business.Scholarship;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScholarshipData {

    String userID;
    String courseName;

    ExecuteQuery executeQuery;
    public ScholarshipData(String userID, String courseName) throws SQLException {
        executeQuery = new ExecuteQuery();
        this.userID = userID;
        this.courseName = courseName;
    }

    public String getData() throws SQLException {
        String score = "";
        String query = "select applicationscore from new_application_score where userName = '" + userID + "' ";
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while(rs.next()){
            score = rs.getString("applicationscore");
            System.out.println(score);
        }
        return score;
    }

}
