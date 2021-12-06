/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email;

import edu.dalhousie.presentation.StudentView;

public class StudentEmail implements IEmail{
    StudentView studentView;
    StringBuilder studentEmailBuilder;
    StudentEmail(){
        this.studentView = new StudentView();
        studentEmailBuilder = new StringBuilder();
    }
    @Override
    public Email generateEmail() {
        System.out.println("Enter the subject for email");
        String subject = this.studentView.getString();

        System.out.println("Enter the body for email");
        String body = this.studentView.getString();

        Email studentEmail = new Email(subject,body);
        return studentEmail;
    }
}
