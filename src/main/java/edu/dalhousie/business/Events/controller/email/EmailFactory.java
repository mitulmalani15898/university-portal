package edu.dalhousie.business.Events.controller.email;

public class EmailFactory {

    public IEmail getEmailTemplate(String type){
        if(type.equalsIgnoreCase("student")){
            return new StudentEmail();
        }
        else if (type.equalsIgnoreCase("college")){
            return new CollegeEmail();
        }
        return null;
    }
}