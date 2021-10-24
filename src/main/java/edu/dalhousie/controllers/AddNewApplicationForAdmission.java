package edu.dalhousie.controllers;

import edu.dalhousie.business.AddNewApplicationForAdmissionBusiness;
import edu.dalhousie.models.AddNewApplicationFormObject;
import edu.dalhousie.presentation.StudentView;

public class AddNewApplicationForAdmission {
    private String firstQuestionInput;
    private String secondQuestionInput;
    private String thirdQuestionInput;
    private String fourthQuestionInput;
    private String fifthQuestionInput;
    private String sixthQuestionInput;
    private String seventhQuestionInput;
    private String eighthQuestionInput;
    private String ninthQuestionInput;
    private String tenthQuestionInput;
    private String eleventhQuestionInput;
    private String twelfthQuestionInput;

    private String kFirstQuestion = "Enter your preferred course name";
    private String kSecondQuestion = "Enter your previous university/College name";
    private String kThirdQuestion = "Enter your previous level of education: (1: Diploma, 2: UG, 3:PG, 4:PHD)";
    private String kFourthQuestion = "Enter your CGPA";
    private String kFifthQuestion = "Enter your 10th percentage";
    private String kSixthQuestion = "Enter your 12th percentage";
    private String kSeventhQuestion = "Enter your IELTS";
    private String kEigthQuestion = "Enter your GRE";
    private String kNinethQuestion = "Enter the number of research publications you have published";
    private String kTenthQuestion = "Enter work experience in years: (If any)";
    private String kEleventhQuestion = "Enter your GMAT score: (If any)";
    private String kTwelfthQuestion = "Enter your GATE score: (If any)";

    private String kCalculationInProgress = "Calculation in progress...";
    private String kResultWillBeShownInSometime = "Result will be shown in sometime...";
    private String kResultIs = "Result is:";

    public void showNewForm() {
        StudentView view = new StudentView();
        AddNewApplicationFormObject addNewApplication = new AddNewApplicationFormObject();
        AddNewApplicationForAdmissionBusiness computeAdmissionResult = new AddNewApplicationForAdmissionBusiness();

        view.showMessage(kFirstQuestion);
        addNewApplication.setCourse(view.getString());
        view.showMessage(kSecondQuestion);
        addNewApplication.setUniversity(view.getString());
        view.showMessage(kThirdQuestion);
        addNewApplication.setEducation(view.getString());

        view.showMessage(kFourthQuestion);
        addNewApplication.setGpa(view.getString());
        view.showMessage(kFifthQuestion);
        addNewApplication.setTenthMarks(view.getString());
        view.showMessage(kSixthQuestion);
        addNewApplication.setTwelfthMarks(view.getString());

        view.showMessage(kSeventhQuestion);
        addNewApplication.setIELTS(view.getString());
        view.showMessage(kEigthQuestion);
        addNewApplication.setGRE(view.getString());
        eighthQuestionInput = view.getString();
        view.showMessage(kNinethQuestion);
        addNewApplication.setResearchPapers(view.getString());

        view.showMessage(kTenthQuestion);
        view.showMessage(kEleventhQuestion);
        addNewApplication.setGMAT(view.getString());
        view.showMessage(kTwelfthQuestion);
        addNewApplication.setGATE(view.getString());

        view.showMessage("Calculation in progress...");
        view.showMessage("Result will be shown in some time...");
        String result = computeAdmissionResult.computeResult(addNewApplication);
        view.showMessage("Result is" + result);
    }

}
