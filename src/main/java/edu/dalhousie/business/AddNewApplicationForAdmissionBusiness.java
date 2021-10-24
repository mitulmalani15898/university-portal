package edu.dalhousie.business;

import edu.dalhousie.models.AddNewApplicationFormObject;

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

        // University
        if (addNewApplicationFormObject.getUniversity().contains("IIT") || addNewApplicationFormObject.getUniversity().contains("Indian Institute of Technology")){
            score += 50;
        }else{
            score += 25;
        }

//        if (course == "Master of Applied Computer Science") {
            // Education
            if (addNewApplicationFormObject.getEducation() == "2") {
                score += 25;
            } else if (addNewApplicationFormObject.getEducation() == "3") {
                score += 35;
            } else {
                score += 20;
            }

            // GPA
            if (Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("8.5")) {
                score += 30;
            } else if (Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("9")) {
                score += 50;
            } else if (Float.parseFloat(addNewApplicationFormObject.getGpa()) <= Float.parseFloat("8")) {
                score += 20;
            } else if ((Float.parseFloat(addNewApplicationFormObject.getGpa()) >= Float.parseFloat("8")) && (Float.parseFloat(addNewApplicationFormObject.getGpa()) <= Integer.parseInt("8.5"))) {
                score += 20;
            }

            // 10th
            if (((Float.parseFloat(tenth)) >= 85) && ((Float.parseFloat(tenth)) <= 90)) {
                score = 35;
            } else if (((Float.parseFloat(tenth)) > 90) && ((Float.parseFloat(tenth)) <= 95)) {
                score += 45;
            } else if ((Float.parseFloat(tenth)) > 95) {
                score += 50;
            } else {
                score += 20;
            }

            // 12th
            if (((Float.parseFloat(twelfth)) >= 85) && ((Float.parseFloat(twelfth)) <= 90)) {
                score = 35;
            } else if (((Float.parseFloat(twelfth)) > 90) && ((Float.parseFloat(twelfth)) <= 95)) {
                score += 45;
            } else if ((Float.parseFloat(twelfth)) > 95) {
                score += 50;
            } else {
                score += 20;
            }

            // IELTS
            if ((Float.parseFloat(ielts)) == 7) {
                score = 35;
            } else if ((Float.parseFloat(ielts)) == 7.5) {
                score += 40;
            } else if ((Float.parseFloat(ielts)) > 7.5) {
                score += 50;
            } else {
                pass = false;
            }

            // GRE
            if (((Integer.parseInt(gre)) >= 290) && ((Integer.parseInt(gre)) <= 300)) {
                score = 30;
            } else if (((Integer.parseInt(gre)) > 300) && ((Integer.parseInt(gre)) <= 310)) {
                score += 40;
            } else if ((Integer.parseInt(gre)) > 310) {
                score += 50;
            } else {
                score += 20;
            }

            // Research
            if ((Integer.parseInt(research)) == 1) {
                score += 35;
            } else if ((Integer.parseInt(gre)) == 2) {
                score += 45;
            } else if ((Integer.parseInt(gre)) > 3) {
                score += 50;
            }

            // Work exp
            if (((Float.parseFloat(workExp)) >= 1) && ((Float.parseFloat(workExp)) <= 2)) {
                score = 30;
            } else if (((Float.parseFloat(workExp)) > 2) && ((Float.parseFloat(workExp)) <= 4)) {
                score += 40;
            } else if ((Float.parseFloat(workExp)) > 4) {
                score += 50;
            }

            // GMAT
            if (((Integer.parseInt(gre)) >= 550) && ((Integer.parseInt(gre)) <= 600)) {
                score = 30;
            } else if (((Integer.parseInt(gre)) > 600) && ((Integer.parseInt(gre)) <= 650)) {
                score += 40;
            } else if ((Integer.parseInt(gre)) > 650) {
                score += 50;
            } else {
                score += 20;
            }

            // GATE
            if (((Integer.parseInt(gre)) >= 290) && ((Integer.parseInt(gre)) <= 300)) {
                score = 30;
            } else if (((Integer.parseInt(gre)) > 300) && ((Integer.parseInt(gre)) <= 310)) {
                score += 40;
            } else if ((Integer.parseInt(gre)) > 310) {
                score += 50;
            } else {
                score += 20;
            }
//        }

        System.out.println("Score is " + score);
        return String.valueOf(score);
    }


}
