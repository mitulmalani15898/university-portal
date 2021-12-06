package edu.dalhousie.business.events.model.Event;

import edu.dalhousie.business.events.controller.email.EmailFactory;
import edu.dalhousie.business.events.controller.email.IEmail;
import edu.dalhousie.business.events.controller.email.SendEmail.SendEmail;
import edu.dalhousie.presentation.StudentView;

import java.util.Scanner;

public class EventNotification {
    private StudentView studentView;
    private EmailFactory emailFactory;
    private SendEmail Email;
    private Scanner scanner;

    public EventNotification() {
        this.studentView = new StudentView();
        this.emailFactory = new EmailFactory();
        this.Email = new SendEmail();
        this.scanner = new Scanner(System.in);
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
        if (status.equalsIgnoreCase("accepted")) {
            return true;
        } else {
            return false;
        }
    }

    public void sendWinnerMessage(){
        this.studentView.showMessage("Send message with the winner name to the students");
        IEmail email = this.emailFactory.getEmailTemplate("college");
        System.out.println("Enter school email address:");
        String toEmail = this.scanner.next();
        this.Email.sendEmail(toEmail,email.generateEmail());
    }
}
