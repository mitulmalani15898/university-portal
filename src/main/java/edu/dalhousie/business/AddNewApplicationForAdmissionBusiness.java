package edu.dalhousie.business;

import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.models.AddNewApplicationFormObject;
import edu.dalhousie.presentation.StudentView;

public class AddNewApplicationForAdmissionBusiness {

    public String computeResult(AddNewApplicationFormObject addNewApplicationFormObject) {
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
        float score = 0; //20 min, 50 max
        boolean pass = true;
        StudentView view = new StudentView();

        // University
        if (addNewApplicationFormObject.getUniversity().contains("IIT") || addNewApplicationFormObject.getUniversity().contains("Indian Institute of Technology")){
            score += 50;
            view.showMessage(String.valueOf(score));
        }else{
            score += 25;
            view.showMessage(String.valueOf(score));
        }

//        if (course == "Master of Applied Computer Science") {
            // Education
            if (addNewApplicationFormObject.getEducation() == "2") {
                score += 25;
                view.showMessage(String.valueOf(score));
            } else if (addNewApplicationFormObject.getEducation() == "3") {
                score += 35;
                view.showMessage(String.valueOf(score));
            } else {
                score += 20;
                view.showMessage(String.valueOf(score));
            }

            // GPA
            if (Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("8.5")) {
                score += 30;
                view.showMessage(String.valueOf(score));
            } else if (Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("9")) {
                score += 50;
                view.showMessage(String.valueOf(score));
            } else if (Float.parseFloat(addNewApplicationFormObject.getGpa()) <= Float.parseFloat("8")) {
                score += 20;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("8")) && (Float.parseFloat(addNewApplicationFormObject.getGpa()) <= Integer.parseInt("8.5"))) {
                score += 20;
                view.showMessage(String.valueOf(score));
            }

            // 10th
            if (((Float.parseFloat(tenth)) >= 85) && ((Float.parseFloat(tenth)) <= 90)) {
                score += 35;
                view.showMessage(String.valueOf(score));
            } else if (((Float.parseFloat(tenth)) > 90) && ((Float.parseFloat(tenth)) <= 95)) {
                score += 45;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(tenth)) > 95) {
                score += 50;
                view.showMessage(String.valueOf(score));
            } else {
                score += 20;
                view.showMessage(String.valueOf(score));
            }

            // 12th
            if (((Float.parseFloat(twelfth)) >= 85) && ((Float.parseFloat(twelfth)) <= 90)) {
                score += 35;
                view.showMessage(String.valueOf(score));
            } else if (((Float.parseFloat(twelfth)) > 90) && ((Float.parseFloat(twelfth)) <= 95)) {
                score += 45;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(twelfth)) > 95) {
                score += 50;
                view.showMessage(String.valueOf(score));
            } else {
                score += 20;
                view.showMessage(String.valueOf(score));
            }

            // IELTS
            if ((Float.parseFloat(ielts)) == 7) {
                score += 35;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(ielts)) == 7.5) {
                score += 40;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(ielts)) > 7.5) {
                score += 50;
                view.showMessage(String.valueOf(score));
            } else {
                pass = false;
            }

            // GRE
            if (((Integer.parseInt(gre)) >= 290) && ((Integer.parseInt(gre)) <= 300)) {
                score += 30;
                view.showMessage(String.valueOf(score));
            } else if (((Integer.parseInt(gre)) > 300) && ((Integer.parseInt(gre)) <= 310)) {
                score += 40;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gre)) > 310) {
                score += 50;
                view.showMessage(String.valueOf(score));
            } else {
                score += 20;
                view.showMessage(String.valueOf(score));
            }

            // Research
            if ((Integer.parseInt(research)) == 1) {
                score += 35;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gre)) == 2) {
                score += 45;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gre)) > 3) {
                score += 50;
                view.showMessage(String.valueOf(score));
            }

            // Work exp
            if (((Float.parseFloat(workExp)) >= 1) && ((Float.parseFloat(workExp)) <= 2)) {
                score += 30;
                view.showMessage(String.valueOf(score));
            } else if (((Float.parseFloat(workExp)) > 2) && ((Float.parseFloat(workExp)) <= 4)) {
                score += 40;
                view.showMessage(String.valueOf(score));
            } else if ((Float.parseFloat(workExp)) > 4) {
                score += 50;
                view.showMessage(String.valueOf(score));
            }

            // GMAT
            if (((Integer.parseInt(gmat)) >= 550) && ((Integer.parseInt(gmat)) <= 600)) {
                score += 30;
                view.showMessage(String.valueOf(score));
            } else if (((Integer.parseInt(gmat)) > 600) && ((Integer.parseInt(gmat)) <= 650)) {
                score += 40;
                view.showMessage(String.valueOf(score));
            } else if ((Integer.parseInt(gmat)) > 650) {
                score += 50;
                view.showMessage(String.valueOf(score));
            } else {
                score += 20;
                view.showMessage(String.valueOf(score));
            }

            // GATE
            if (((Integer.parseInt(gate)) >= 290) && ((Integer.parseInt(gate)) <= 300)) {
                score += 30;
            } else if (((Integer.parseInt(gate)) > 300) && ((Integer.parseInt(gate)) <= 310)) {
                score += 40;
            } else if ((Integer.parseInt(gate)) > 310) {
                score += 50;
            } else {
                score += 20;
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
