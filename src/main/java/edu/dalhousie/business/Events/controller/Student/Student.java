package edu.dalhousie.business.Events.controller.Student;

import edu.dalhousie.business.Events.controller.Event.EventNotification;
import edu.dalhousie.presentation.StudentView;

public class Student implements IStudent{
    public String Name;
    public StudentView studentView;
    public EventNotification eventNotification;
    public Student(){

    }
    public Student(String name){
        this.setUserName(name);
    }

    @Override
    public String getUserName() {
        return this.Name;
    }

    @Override
    public void setUserName(String name) {
        this.Name = name;
    }

    public void sendNotificationToStudents(){
        eventNotification = new EventNotification();
        eventNotification.sendEventNotificationToStudents();
    }

    public void sendWinnerNotificationToStudents(){
        eventNotification = new EventNotification();
        eventNotification.sendWinnerMessage();
    }
}
