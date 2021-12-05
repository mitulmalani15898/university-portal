package edu.dalhousie.business.AddNewApplication.controller;

import edu.dalhousie.business.AddNewApplication.business.*;
import edu.dalhousie.business.AddNewApplication.data.AddNewApplicationForAdmissionData;
import edu.dalhousie.business.AddNewApplication.data.IAddNewApplicationForAdmissionData;
import edu.dalhousie.business.AddNewApplication.model.AddNewApplicationFormObject;
import edu.dalhousie.business.AddNewApplication.model.AddNewApplicationFormValidation;
import edu.dalhousie.business.AddNewApplication.constants.StringConstants;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.presentation.StudentView;

import java.sql.SQLException;

public class AddNewApplicationForAdmission implements IAddNewApplicationForAdmission{
    StudentView view;
    AddNewApplicationFormObject addNewApplication;
    IValidateNewApplication addNewApplicationForAdmissionValidation;
    ComputeScoreForNewApplicationTemplate addNewApplicationForAdmissionBusiness;
    IAddNewApplicationForAdmissionData storeAdmissionInfo;
    AddNewApplicationFormValidation validation;
    StudentMainClass student;

    public AddNewApplicationForAdmission() throws SQLException {
        view = new StudentView();
        addNewApplication = new AddNewApplicationFormObject();
        addNewApplicationForAdmissionValidation = new ValidateNewApplication();
        addNewApplicationForAdmissionBusiness = new ComputeScoreForNewApplication(addNewApplication);
        storeAdmissionInfo = new AddNewApplicationForAdmissionData();
        validation = new AddNewApplicationFormValidation();
        student = new StudentMainClass();
    }

    public void showNewForm() throws Exception {

        view.showMessage(StringConstants.kFirstQuestion);
        String courseName = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyCourseName(courseName);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kFirstQuestion);
                courseName = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyCourseName(courseName);
            }
        }
        addNewApplication.setCourse(courseName);

        view.showMessage(StringConstants.kSecondQuestion);
        String previousSchoolName = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyPreviousSchoolName(previousSchoolName);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kSecondQuestion);
                previousSchoolName = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyPreviousSchoolName(previousSchoolName);
            }
        }
        addNewApplication.setUniversity(previousSchoolName);

        view.showMessage(StringConstants.kThirdQuestion);
        String previousLevelOfEducation = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifypreviousLevelOfEducation(previousLevelOfEducation);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kThirdQuestion);
                previousLevelOfEducation = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifypreviousLevelOfEducation(previousLevelOfEducation);
            }
        }
        addNewApplication.setEducation(previousLevelOfEducation);

        view.showMessage(StringConstants.kFourthQuestion);
        String cgpa = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyCGPA(cgpa);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kFourthQuestion);
                cgpa = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyCGPA(cgpa);
            }
        }
        addNewApplication.setGpa(cgpa);

        view.showMessage(StringConstants.kFifthQuestion);
        String tenthPercentage = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyTenthPercentage(tenthPercentage);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kFifthQuestion);
                tenthPercentage = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyTenthPercentage(tenthPercentage);
            }
        }
        addNewApplication.setTenthMarks(tenthPercentage);

        view.showMessage(StringConstants.kSixthQuestion);
        String twelfthPercentage = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyTwelfthPercentage(twelfthPercentage);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kSixthQuestion);
                twelfthPercentage = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyTwelfthPercentage(twelfthPercentage);
            }
        }
        addNewApplication.setTwelfthMarks(twelfthPercentage);

        view.showMessage(StringConstants.kSeventhQuestion);
        String ielts = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyIELTS(ielts);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kSeventhQuestion);
                ielts = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyIELTS(ielts);
            }
        }
        addNewApplication.setIELTS(ielts);

        view.showMessage(StringConstants.kEigthQuestion);
        String gre = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyGRE(gre);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kEigthQuestion);
                gre = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyGRE(gre);
            }
        }
        addNewApplication.setGRE(gre);

        view.showMessage(StringConstants.kNinethQuestion);
        String researchPapers = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyReasearchPapers(researchPapers);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kNinethQuestion);
                researchPapers = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyReasearchPapers(researchPapers);
            }
        }
        addNewApplication.setResearchPapers(researchPapers);

        view.showMessage(StringConstants.kTenthQuestion);
        String workExperience = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyWorkExperience(workExperience);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kTenthQuestion);
                workExperience = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyWorkExperience(workExperience);
            }
        }
        addNewApplication.setWorkExp(workExperience);

        view.showMessage(StringConstants.kEleventhQuestion);
        String gmat = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyGMAT(gmat);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kEleventhQuestion);
                gmat = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyGMAT(gmat);
            }
        }
        addNewApplication.setGMAT(gmat);

        view.showMessage(StringConstants.kTwelfthQuestion);
        String gate = view.getString();
        validation = addNewApplicationForAdmissionValidation.verifyGATE(gate);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kTwelfthQuestion);
                gate = view.getString();
                validation = addNewApplicationForAdmissionValidation.verifyGATE(gate);
            }
        }
        addNewApplication.setGATE(gate);

        view.showMessage(StringConstants.kCalculationInProgress);
        view.showMessage(StringConstants.kResultWillBeShownInSometime);

        storeAdmissionInfo.storeData(addNewApplication);
        String result = addNewApplicationForAdmissionBusiness.calculateScore();
        String score = addNewApplication.getResult();
        storeAdmissionInfo.storeScore(addNewApplication);
        view.showMessage(StringConstants.kDecision + result);

        student.displayStudentMenu();
    }
}