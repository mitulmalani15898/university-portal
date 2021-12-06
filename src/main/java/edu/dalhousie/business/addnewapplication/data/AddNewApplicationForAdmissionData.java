package edu.dalhousie.business.addnewapplication.data;

import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormObject;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddNewApplicationForAdmissionData implements IAddNewApplicationForAdmissionData{

    private static DatabaseConnection databaseConnection;
//    private String course;
//    private String university;
//    private String education;
//    private String gpa;
//    private String tenthMarks;
//    private String twelfthMarks;
//    private String IELTS;
//    private String GRE;
//    private String researchPapers;
//    private String workExp;
//    private String GMAT;
//    private String GATE;
   //private String score;

    public AddNewApplicationForAdmissionData() throws SQLException {
//        executeQuery = new ExecuteQuery();
        databaseConnection = DatabaseConnectivity.getInstance();
    }

    public void storeData(AddNewApplicationFormObject newApplication) throws SQLException {
        String course = newApplication.getCourse();
        String university = newApplication.getUniversity();
        String education = newApplication.getEducation();
        String gpa = newApplication.getGpa();
        String tenthMarks = newApplication.getTenthMarks();
        String twelfthMarks = newApplication.getTwelfthMarks();
        String IELTS = newApplication.getIELTS();
        String GRE = newApplication.getGRE();
        String researchPapers = newApplication.getResearchPapers();
        String workExp = newApplication.getWorkExp();
        String GMAT = newApplication.getGMAT();
        String GATE = newApplication.getGATE();
        //score

        String query = "insert into new_application" + " values ('"+ "abhishek" + "','" + course+ "', '" + university + "', '"+education+"','" + Float.parseFloat(gpa) + "', '" + Float.parseFloat(tenthMarks) + "','" + Float.parseFloat(twelfthMarks) + "','" + Float.parseFloat(IELTS) + "','" + Integer.parseInt(GRE) + "', '" + Integer.parseInt(researchPapers) + "', '" + Float.parseFloat(workExp) + "', '" + Integer.parseInt(GMAT) + "', '" + Integer.parseInt(GATE) + "')";
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

    public void storeScore(AddNewApplicationFormObject newApplicationFormObject) throws SQLException {
        String score = newApplicationFormObject.getResult();
        String query = "insert into new_application_score " + " values ('"+ "vignesh" +"', '" + Float.parseFloat(score) + "')";
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

}
