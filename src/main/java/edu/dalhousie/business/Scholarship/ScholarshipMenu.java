//package edu.dalhousie.business.Scholarship;
//
//import edu.dalhousie.controllers.StudentMainClass;
//import edu.dalhousie.presentation.StudentView;
//
//public class ScholarshipMenu {
//    private String applyForScholarship = "Apply for scholarship";
//    private String applyForEmergencyGrants = "Apply for emergency grants";
//    private String backToStudentMenu = "Back to student menu";
//    int choice;
//
//    public void displayMenu() throws Exception {
//        StudentView view = new StudentView();
//
//        view.showMessage("1. " + applyForScholarship);
//        view.showMessage("2. " + applyForEmergencyGrants);
//        view.showMessage("3. " + backToStudentMenu);
//        choice = view.getInt();
//
//        switch(choice) {
//            case 1:
//                Scholarship scholarship = new Scholarship();
//                scholarship.enterDetailsMenu();
//            case 2:
//                EmergencyGrants eGrants = new EmergencyGrants();
//                eGrants.enterDetailsMenu();
//            case 3:
//                StudentMainClass studentMainClass = new StudentMainClass();
//                studentMainClass.displayStudentMenu();
//            }
//    }
//}
