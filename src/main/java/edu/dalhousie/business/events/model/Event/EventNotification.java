/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.model.Event;

import edu.dalhousie.business.events.controller.email.EmailFactory;
import edu.dalhousie.business.events.controller.email.IEmail;
import edu.dalhousie.business.events.controller.email.SendEmail.SendEmail;
import edu.dalhousie.presentation.StudentView;

import java.util.Scanner;

public class EventNotification {
    private final StudentView studentView;
    private final EmailFactory emailFactory;
    private final SendEmail Email;
    private final Scanner scanner = new Scanner(System.in);

    public EventNotification() {
        this.studentView = new StudentView();
        this.emailFactory = new EmailFactory();
        this.Email = new SendEmail();
    }

    public void sendEventNotification(String schoolName) {
        this.studentView.showMessage("Send notification to " + schoolName);
        IEmail email = this.emailFactory.getEmailTemplate("college");
        System.out.println("Enter school email address:");
        String toEmail = this.scanner.next();
        this.Email.sendEmail(toEmail,email.generateEmail());
    }

    public void sendEventNotificationToVolunteers() {
        this.studentView.showMessage("Send notification to the students ");
        IEmail email = this.emailFactory.getEmailTemplate("student");
        System.out.println("Enter school email address:");
        String toEmail = this.scanner.next();
        this.Email.sendEmail(toEmail,email.generateEmail());
    }

    public boolean invitationStatus() {
        this.studentView.showMessage("Enter Event Invitation Status (Accepted/Rejected) : ");
        String status = this.studentView.getString();
        return status.equalsIgnoreCase("accepted");
    }

    public void sendWinnerMessage(){
        this.studentView.showMessage("Send message with the winner name to the students");
        IEmail email = this.emailFactory.getEmailTemplate("college");
        System.out.println("Enter school email address:");
        String toEmail = this.scanner.next();
        this.Email.sendEmail(toEmail,email.generateEmail());
    }
}
