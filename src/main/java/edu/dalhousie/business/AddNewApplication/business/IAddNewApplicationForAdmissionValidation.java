package edu.dalhousie.business.AddNewApplication.business;

import edu.dalhousie.business.AddNewApplication.model.AddNewApplicationFormValidation;

public interface IAddNewApplicationForAdmissionValidation {
    public AddNewApplicationFormValidation verifyCourseName(String courseName);
    public AddNewApplicationFormValidation verifyPreviousSchoolName(String previousSchoolName);
    public AddNewApplicationFormValidation verifypreviousLevelOfEducation(String previousLevelOfEducation);
    public AddNewApplicationFormValidation verifyCGPA(String cgpa);
    public AddNewApplicationFormValidation verifyTenthPercentage(String tenthPercentage);
    public AddNewApplicationFormValidation verifyTwelfthPercentage(String twelfthPercentage);
    public AddNewApplicationFormValidation verifyIELTS(String ielts);
    public AddNewApplicationFormValidation verifyGRE(String gre);
    public AddNewApplicationFormValidation verifyReasearchPapers(String researchPapers);
    public AddNewApplicationFormValidation verifyWorkExperience(String workExperience);
    public AddNewApplicationFormValidation verifyGMAT(String gmat);
    public AddNewApplicationFormValidation verifyGATE(String gate);
}
