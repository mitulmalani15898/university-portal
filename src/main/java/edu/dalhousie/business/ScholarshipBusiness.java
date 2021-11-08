package edu.dalhousie.business;

import edu.dalhousie.models.AddNewApplicationFormObject;

public class ScholarshipBusiness {

    String courseName;
    String userName;


    public ScholarshipBusiness (String courseName, String userName) {
        this.courseName = courseName;
        this.userName = userName;
    }

    public String computeResult() {
        if (courseName == "Master of applied computer science") {
            AddNewApplicationFormObject obj = new AddNewApplicationFormObject();
            System.out.println(obj.getResult());
        }
        return "";
    }

}
