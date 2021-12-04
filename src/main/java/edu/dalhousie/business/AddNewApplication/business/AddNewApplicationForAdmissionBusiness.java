package edu.dalhousie.business.AddNewApplication.business;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.business.AddNewApplication.model.AddNewApplicationFormObject;
import edu.dalhousie.presentation.StudentView;

import java.util.Locale;

public class AddNewApplicationForAdmissionBusiness {

    StudentView view;
    AddNewApplicationFormObject addNewApplicationFormObject;

    public AddNewApplicationForAdmissionBusiness(AddNewApplicationFormObject addNewApplicationFormObject) {
        view = new StudentView();
        this.addNewApplicationFormObject = addNewApplicationFormObject;
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
        final float approvalMarks = 320;
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
        if (addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kIIT) || addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kIndianInstituteOfTechnology)) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else if (addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kNIT) || addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kNationalInstituteOfTechnology)) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += averageMarks;
            view.showMessage(String.valueOf(score));
        }

            // Education
            if (addNewApplicationFormObject.getEducation().equals("1")) {
                score += belowAverageMarks;
                view.showMessage(String.valueOf(score));
            } else if (addNewApplicationFormObject.getEducation().equals("2")) {
                score += aboveAverage;
                view.showMessage(String.valueOf(score));
            } else if (addNewApplicationFormObject.getEducation().equals("3")){
                score += goodMarks;
                view.showMessage(String.valueOf(score));
            } else {
                score += veryGoodMarks;
                view.showMessage(String.valueOf(score));
            }

        // GPA
        if (((Float.parseFloat(gpa)) >= 8.5) && ((Float.parseFloat(gpa)) <= 9)) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(gpa)) > 9) && ((Float.parseFloat(gpa)) <= 9.5)) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(gpa)) > 9.5) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(gpa)) > 8) && (((Float.parseFloat(gpa)) < 8.5))){
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        } else {
            pass = false;
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
            } else if (((Float.parseFloat(tenth)) > 45) && (((Float.parseFloat(tenth)) < 85))){
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            } else {
                pass = false;
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
            } else if (((Float.parseFloat(twelfth)) > 45) && (((Float.parseFloat(twelfth)) < 85))){
                score += satisfactoryMarks;
                view.showMessage(String.valueOf(score));
            } else {
                pass = false;
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
            } else if ((Integer.parseInt(research)) == 2) {
                score += veryGoodMarks;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(research)) > 3) {
                score += outstandingMarks;
                view.showMessage(String.valueOf(score));
            } else {
                score += satisfactoryMarks;
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
            } else {
                score += satisfactoryMarks;
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
            if (((Integer.parseInt(gate)) >= 0) && ((Integer.parseInt(gate)) <= 30)) {
                score += averageMarks;
            } else if (((Integer.parseInt(gate)) > 30) && ((Integer.parseInt(gate)) <= 60)) {
                score += goodMarks;
            } else if ((Integer.parseInt(gate)) > 60) {
                score += outstandingMarks;
            }

        addNewApplicationFormObject.setResult(String.valueOf(score));
        System.out.println("Score is " + score);
        addNewApplicationFormObject.setResult(String.valueOf(score));

        if (score>approvalMarks && pass) {
            return "Congratulations! You're application is approved.";
        } else {
            return "Sorry, you're application has been denied.";
        }
    }
}
