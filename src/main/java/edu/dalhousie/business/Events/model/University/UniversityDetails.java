package edu.dalhousie.business.Events.model.University;

import edu.dalhousie.business.Events.model.Event.EventNotification;
import edu.dalhousie.business.Events.model.Student.Student;
import edu.dalhousie.business.Events.model.Student.StudentIterator;
import edu.dalhousie.presentation.StudentView;

import java.util.ArrayList;
import java.util.Iterator;

public class UniversityDetails implements StudentIterator {
    public University university;
    public StudentView studentView;
    public static ArrayList<Student> student;
    public EventNotification eventNotification;
    public UniversityDetails(){

    }
    public UniversityDetails(String name){
        student = new ArrayList<>();
        university = new University(name);
        studentView = new StudentView();
    }

    @Override
    public Iterator Iterator() {
        return student.iterator();
    }

    public void addStudent(){
        this.studentView.showMessage("Enter Student name:");
        String studentName = this.studentView.getString();
        student.add(new Student(studentName));
    }

    public void studentInfo(){
        university.studentInfo();
    }

    public boolean sendNotificationToSchool(String schoolName){
        eventNotification = new EventNotification();
        eventNotification.sendEventNotification(schoolName);

        if(eventNotification.invitationStatus())
            return true;
        else
            return false;
    }
}
