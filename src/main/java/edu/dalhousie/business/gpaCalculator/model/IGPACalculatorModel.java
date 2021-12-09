package edu.dalhousie.business.gpaCalculator.model;

public interface IGPACalculatorModel {

    double getTotalPoints();

    void setTotalPoints(double totalPoints);

    int getTotalCredits();

    void setTotalCredits(int totalCredits);

    int getCredits();

    void setCredits(int credits);

    String getSubjectCredits();

    void setSubjectCredits(String subjectCredits);

    double getGradeValue();

    void setGradeValue(double gradeValue);

    String getGrade();

    void setGrade(String grade);

    double getPoints();

    void setPoints(double points);

    String getPattern();

    void setPattern(String pattern);

    double getOverallGPA();

    void setOverallGPA(double overallGPA);

}
