package edu.dalhousie.business.Events.controller.Event;

import edu.dalhousie.presentation.StudentView;

public class EventNotification {
    private StudentView studentView;

    public EventNotification() {
        this.studentView = new StudentView();
    }

    public void sendEventNotification(String schoolName) {
        this.studentView.showMessage("Send notification to " + schoolName);
    }

    public void sendEventNotificationToStudents() {
        System.out.print("\nSend notification to the students ");
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
    }
}
