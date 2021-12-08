/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email;

import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class CollegeEmail implements IEmail{
    IStudentView studentView;
    CollegeEmail(){
       this.studentView = StudentView.getInstance();
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
