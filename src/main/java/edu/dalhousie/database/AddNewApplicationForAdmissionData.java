package edu.dalhousie.database;

import edu.dalhousie.models.AddNewApplicationFormObject;

import java.sql.SQLException;

public class AddNewApplicationForAdmissionData {

    ExecuteQuery executeQuery;

    private String course;
    private String university;
    private String education;
    private String gpa;
    private String tenthMarks;
    private String twelfthMarks;
    private String IELTS;
    private String GRE;
    private String researchPapers;
    private String workExp;
    private String GMAT;
    private String GATE;
   //private String score;

    public AddNewApplicationForAdmissionData() {
        executeQuery = new ExecuteQuery();
    }

    public void storeData(AddNewApplicationFormObject newApplication) throws SQLException {
        course = newApplication.getCourse();
        university = newApplication.getUniversity();
        education = newApplication.getEducation();
        gpa = newApplication.getGpa();
        tenthMarks = newApplication.getTenthMarks();
        twelfthMarks = newApplication.getTwelfthMarks();
        IELTS = newApplication.getIELTS();
        GRE = newApplication.getGRE();
        researchPapers = newApplication.getResearchPapers();
        workExp = newApplication.getWorkExp();
        GMAT = newApplication.getGMAT();
        GATE = newApplication.getGATE();
        //score

        String query = "insert into new_application" + " values ('"+ "abhishek" + "','" + course+ "', '" + university + "', '"+education+"','" + Float.parseFloat(gpa) + "', '" + Float.parseFloat(tenthMarks) + "','" + Float.parseFloat(twelfthMarks) + "','" + Float.parseFloat(IELTS) + "','" + Integer.parseInt(GRE) + "', '" + Integer.parseInt(researchPapers) + "', '" + Float.parseFloat(workExp) + "', '" + Integer.parseInt(GMAT) + "', '" + Integer.parseInt(GATE) + "')";
        executeQuery.executeSQL(query);
    }

    public void storeScore(AddNewApplicationFormObject newApplicationFormObject) throws SQLException {
        String score = newApplicationFormObject.getResult();
        String query = "insert into new_application_score " + " values ('"+ "vignesh" +"', '" + Float.parseFloat(score) + "')";
        executeQuery.executeSQL(query);
    }

}
