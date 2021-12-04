package edu.dalhousie.business.Events.controller.email;

import edu.dalhousie.presentation.StudentView;

public class CollegeEmail implements IEmail{
    StudentView studentView;
    CollegeEmail(){
       this.studentView = new StudentView();
    }
    @Override
    public Email generateEmail() {
        System.out.println("Enter the subject for email");
        String subject = this.studentView.getString();

        System.out.println("Enter the body for email");
        String body = this.studentView.getString();

        Email collegeEmail = new Email(subject,body);
        return collegeEmail;
    }
}
