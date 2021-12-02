package edu.dalhousie.business;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.models.AddNewApplicationFormObject;
import edu.dalhousie.models.AddNewApplicationFormValidation;
import edu.dalhousie.presentation.StudentView;

import java.util.Arrays;
import java.util.List;

public class AddNewApplicationForAdmissionBusiness {

    StudentView view;
    AddNewApplicationFormObject addNewApplicationFormObject;

    public AddNewApplicationForAdmissionBusiness(AddNewApplicationFormObject addNewApplicationFormObject) {
        view = new StudentView();
        this.addNewApplicationFormObject = addNewApplicationFormObject;
    }

    public AddNewApplicationFormValidation verifyCourseName(String courseName) {
        if (courseName.length()>=4) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidCourse);
    }

    public AddNewApplicationFormValidation verifyPreviousSchoolName(String previousSchoolName) {
        if (previousSchoolName.length()>=3) {
            return new AddNewApplicationFormValidation(true,StringConstants.kSuccess );
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidPreviousSchoolName);
    }

    public AddNewApplicationFormValidation verifypreviousLevelOfEducation(String previousLevelOfEducation) {
        if ((previousLevelOfEducation.length() == 1) && ((Integer.parseInt(previousLevelOfEducation) == 1) || (Integer.parseInt(previousLevelOfEducation) == 2) || (Integer.parseInt(previousLevelOfEducation) == 3) || (Integer.parseInt(previousLevelOfEducation) == 4))){
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (previousLevelOfEducation.length()>1) {
            return new AddNewApplicationFormValidation(false, StringConstants.kOnlyOneEducation);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidPreviousLevelOfEducation);
    }

    public AddNewApplicationFormValidation verifyCGPA(String cgpa) {
        if (cgpa.matches("[0-9]*(\\.[0-9]*)?") && cgpa.length()>=1) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (!cgpa.matches("[0-9]*(\\.[0-9]*)?")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kCGPAInNumericsOnly);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidCGPA);
    }

    public AddNewApplicationFormValidation verifyTenthPercentage(String tenthPercentage) {
        if (tenthPercentage.contains("%")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kPercentageInNumericsOnly);
        } else if (tenthPercentage.matches("[0-9]*(\\.[0-9]*)?") && tenthPercentage.length()>=1) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (!tenthPercentage.matches("[0-9]*(\\.[0-9]*)?")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kTenthPercentageInNumericsOnly );
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidTenthPercentage);
    }

    public AddNewApplicationFormValidation verifyTwelfthPercentage(String twelfthPercentage) {
        if (twelfthPercentage.contains("%")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kPercentageInNumericsOnly);
        } else if (twelfthPercentage.matches("[0-9]*(\\.[0-9]*)?") && twelfthPercentage.length()>=1) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (!twelfthPercentage.matches("[0-9]*(\\.[0-9]*)?")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kTwelfthPercentageInNumericsOnly);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidTwelfthPercentage);
    }

    public AddNewApplicationFormValidation verifyIELTS(String ielts) {
        List<String> ieltsBands = Arrays.asList("5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9");
        if (ieltsBands.contains(ielts)) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, "Please enter valid ielts band");
    }

    public AddNewApplicationFormValidation verifyGRE(String gre) {
        if (gre.length() == 3 && (Integer.parseInt(gre)>=260 && Integer.parseInt(gre)<=340) && !gre.contains(".")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (gre.length() == 3 && (Integer.parseInt(gre)<=260 && Integer.parseInt(gre)>=340)) {
            return new AddNewApplicationFormValidation(false, "Please enter score in the range of 260-340");
        }
        return new AddNewApplicationFormValidation(false, "Please valid gre score");
    }

    public AddNewApplicationFormValidation verifyReasearchPapers(String researchPapers) {
        if (researchPapers.matches("[0-9]*")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, "Please enter a valid number");
    }

    public AddNewApplicationFormValidation verifyWorkExperience(String workExperience) {
        if (workExperience.matches("[0-9]*")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, "Please enter a valid number");
    }

    public AddNewApplicationFormValidation verifyGMAT(String gmat) {
        if (gmat.length() == 3 && (Integer.parseInt(gmat)>=200 && Integer.parseInt(gmat)<=800) && !gmat.contains(".")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (gmat.length() == 3 && (Integer.parseInt(gmat)<=200 || Integer.parseInt(gmat)>=800)) {
            return new AddNewApplicationFormValidation(false, "Please enter score in the range of 200-800");
        }
        return new AddNewApplicationFormValidation(false, "Please valid gmat score");
    }

    public AddNewApplicationFormValidation verifyGATE(String gate) {
        if ((gate.length()>=0 &&gate.length()<=3)  && (Integer.parseInt(gate)>=0 && Integer.parseInt(gate)<=100) && !gate.contains(".")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if ((gate.length()>=0 &&gate.length()<=3) && (Integer.parseInt(gate)<=0 || Integer.parseInt(gate)>=100)) {
            return new AddNewApplicationFormValidation(false, "Please enter score in the range of 0-100");
        }
        return new AddNewApplicationFormValidation(false, "Please valid gate score");
    }

    public String computeResult() {
        String course=addNewApplicationFormObject.getCourse();
        String university=addNewApplicationFormObject.getUniversity();
        String education=addNewApplicationFormObject.getEducation();
        String gpa=addNewApplicationFormObject.getGpa();
        String tenth = addNewApplicationFormObject.getTenthMarks();
        String twelfth = addNewApplicationFormObject.getTwelfthMarks();
        String ielts=addNewApplicationFormObject.getIELTS();
        String gre=addNewApplicationFormObject.getGRE();
        String research=addNewApplicationFormObject.getResearchPapers();
        String workExp=addNewApplicationFormObject.getWorkExp();
        String gmat=addNewApplicationFormObject.getGMAT();
        String gate=addNewApplicationFormObject.getGATE();
        final float satisfactoryMarks = 20;
        final float belowAverageMarks = 25;
        final float averageMarks = 30;
        final float aboveAverage = 35;
        final float goodMarks = 40;
        final float veryGoodMarks = 45;
        final float outstandingMarks = 50;
        float score = 0;
        boolean pass = true;

        // University
        if (addNewApplicationFormObject.getUniversity().contains("IIT") || addNewApplicationFormObject.getUniversity().contains("Indian Institute of Technology")){
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        }else{
            score += belowAverageMarks;
            view.showMessage(String.valueOf(score));
        }

//        if (course == "Master of Applied Computer Science") {
            // Education
            if (addNewApplicationFormObject.getEducation() == "2") {
                score += belowAverageMarks;
                view.showMessage(String.valueOf(score));
            } else if (addNewApplicationFormObject.getEducation() == "3") {
                score += aboveAverage;
                view.showMessage(String.valueOf(score));
            } else {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            }

            // GPA
            if (Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("8.5")) {
                score += averageMarks;
                view.showMessage(String.valueOf(score));
            } else if (Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("9")) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else if (Float.parseFloat(addNewApplicationFormObject.getGpa()) <= Float.parseFloat("8")) {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("8")) && (Float.parseFloat(addNewApplicationFormObject.getGpa()) <= Integer.parseInt("8.5"))) {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            }

            // 10th
            if (((Float.parseFloat(tenth)) >= 85) && ((Float.parseFloat(tenth)) <= 90)) {
                score += aboveAverage;
                view.showMessage(String.valueOf(score));
            } else if (((Float.parseFloat(tenth)) > 90) && ((Float.parseFloat(tenth)) <= 95)) {
                score += veryGoodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(tenth)) > 95) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            }

            // 12th
            if (((Float.parseFloat(twelfth)) >= 85) && ((Float.parseFloat(twelfth)) <= 90)) {
                score += aboveAverage;
                view.showMessage(String.valueOf(score));
            } else if (((Float.parseFloat(twelfth)) > 90) && ((Float.parseFloat(twelfth)) <= 95)) {
                score += veryGoodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(twelfth)) > 95) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            }

            // IELTS
            if ((Float.parseFloat(ielts)) == 7) {
                score += aboveAverage;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(ielts)) == 7.5) {
                score += goodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(ielts)) > 7.5) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else {
                pass = false;
            }

            // GRE
            if (((Integer.parseInt(gre)) >= 290) && ((Integer.parseInt(gre)) <= 300)) {
                score += averageMarks;
                view.showMessage(String.valueOf(score));
            } else if (((Integer.parseInt(gre)) > 300) && ((Integer.parseInt(gre)) <= 310)) {
                score += goodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gre)) > 310) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            }

            // Research
            if ((Integer.parseInt(research)) == 1) {
                score += aboveAverage;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gre)) == 2) {
                score += veryGoodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gre)) > 3) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            }

            // Work exp
            if (((Float.parseFloat(workExp)) >= 1) && ((Float.parseFloat(workExp)) <= 2)) {
                score += averageMarks;
                view.showMessage(String.valueOf(score));
            } else if (((Float.parseFloat(workExp)) > 2) && ((Float.parseFloat(workExp)) <= 4)) {
                score += goodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(workExp)) > 4) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            }

            // GMAT
            if (((Integer.parseInt(gmat)) >= 550) && ((Integer.parseInt(gmat)) <= 600)) {
                score += averageMarks;
                view.showMessage(String.valueOf(score));
            } else if (((Integer.parseInt(gmat)) > 600) && ((Integer.parseInt(gmat)) <= 650)) {
                score += goodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gmat)) > 650) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else {
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            }

            // GATE
            if (((Integer.parseInt(gate)) >= 290) && ((Integer.parseInt(gate)) <= 300)) {
                score += averageMarks;
            } else if (((Integer.parseInt(gate)) > 300) && ((Integer.parseInt(gate)) <= 310)) {
                score += goodMarks;
            } else if ((Integer.parseInt(gate)) > 310) {
                score += outstandingMarks;
            } else {
                score += satisfactoryMarks;
            }
//        }

        addNewApplicationFormObject.setResult(String.valueOf(score));
        System.out.println("Score is " + score);
        addNewApplicationFormObject.setResult(String.valueOf(score));

        if (score>350) {
            return "Congratulations! You're application is approved.";
        } else {
            return "Sorry, you're application has been denied.";
        }
    }
}
