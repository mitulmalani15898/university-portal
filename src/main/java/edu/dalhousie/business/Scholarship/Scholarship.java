//package edu.dalhousie.business.Scholarship;
//
//import edu.dalhousie.controllers.StudentMainClass;
//import edu.dalhousie.database.ScholarshipData;
//import edu.dalhousie.presentation.StudentView;
//
//public class Scholarship {
//
//    private String kCourseName = "Enter your course name";
//    private String kUserName = "Enter your user name";
//    private String kCalculatingEligibility = "Calculating your eligibility for scholarship";
//    private String kAccepted = "Congratulations! You're eligible for scholarship";
//
//    private String courseName;
//    private String userName;
//
//    public void enterDetailsMenu() throws Exception {
//        StudentView view = new StudentView();
//
//        view.showMessage("1. " + kCourseName);
//        courseName = view.getString();
//
//        view.showMessage("2. " + kUserName);
//        userName = view.getString();
//
//        ScholarshipData scholarShipData = new ScholarshipData(userName, courseName);
//        String score = scholarShipData.getData();
//        ScholarshipBusiness scholarshipBusiness = new ScholarshipBusiness();
//
//        String decision = scholarshipBusiness.computeResult(Float.parseFloat(score));
//        view.showMessage(decision);
//
//        StudentMainClass student = new StudentMainClass();
//        student.displayStudentMenu();
//    }
//}
