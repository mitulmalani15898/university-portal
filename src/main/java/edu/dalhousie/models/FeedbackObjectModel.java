package edu.dalhousie.models;

public class FeedbackObjectModel {

    String courseID;
    String feedback;
    int professorRating;
    int difficultyLevel;
    int recommendation;
    int professionalDevelopment;
    int needsMet;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getProfessorRating() {
        return professorRating;
    }

    public void setProfessorRating(int professorRating) {
        this.professorRating = professorRating;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    public int getProfessionalDevelopment() {
        return professionalDevelopment;
    }

    public void setProfessionalDevelopment(int professionalDevelopment) {
        this.professionalDevelopment = professionalDevelopment;
    }

    public int getNeedsMet() {
        return needsMet;
    }

    public void setNeedsMet(int needsMet) {
        this.needsMet = needsMet;
    }

}