package edu.dalhousie.business.Events.controller;

import edu.dalhousie.business.Events.controller.Cost.EventCost;
import edu.dalhousie.business.Events.controller.Event.Event;
import edu.dalhousie.business.Events.controller.Student.Student;
import edu.dalhousie.business.Events.controller.University.model.UniversityDetails;

import java.util.Arrays;
import java.util.Scanner;

public class EventApplication {
    public static void main(String[] args) {
        UniversityDetails[] schools = new UniversityDetails[3];

        //store school names
        String[] schoolName = new String[schools.length];
        Scanner scan = new Scanner(System.in);
        Event event;
        EventCost payment = new EventCost();
        boolean eventFlag = false;

        System.out.print("***** School Registration *****");

        for(int i=0; i<schools.length;  i++ )
        {
            System.out.print("Please Enter School Name : ");
            schoolName[i] = scan.nextLine();

            schools[0] = new UniversityDetails(schoolName[i]);
            System.out.println(schools[0]);
        }

        for(int i=0; i<schools.length;  i++ )
        {
            System.out.print("\n***** Student and Parent Registration for "+schoolName[i]+ " *****");

            System.out.print("\nAdd Students and Parents : \n");
            schools[0].addStudent();
            schools[0].addStudent();
            schools[0].addStudent();

            System.out.print("\n***** Display Student Info "+schoolName[i]+" *****\n");
            schools[0].studentInfo();


        }

        System.out.print("\n***** Display Registered School List *****\n");
        for (String school : schoolName) {
            System.out.println(school);
        }

        //organize the event
        System.out.print("\nPlease Enter Event Name : ");
        String eventName = scan.nextLine();

        System.out.print("\nPlease Enter Event Location : ");
        String eventLocation = scan.nextLine();

        System.out.print("\nPlease Enter Event Date : ");
        String eventDate = scan.nextLine();

        System.out.print("\nPlease Enter Event Time : ");
        String eventTime = scan.nextLine();

        System.out.print("\nPlease Enter Event Description : ");
        String eventDesc = scan.nextLine();

        System.out.print("\nPlease Enter Organizing School Name : ");
        String eventSchool = scan.nextLine();

        System.out.print("\n");

        if(Arrays.asList(schoolName).contains(eventSchool)) {
            event = new Event(eventName, eventLocation, eventDate, eventTime, eventDesc);

            //event
            System.out.print(("\n "+eventSchool+" organizes technical event\n"));

            System.out.print("\n***** Display Event Info *****\n");
            event.getEventInfo();

            //send invitation to other school
            for(int i=0; i< schoolName.length; i++)
            {
                if(!schoolName[i].equals(eventSchool)){
                    if(schools[0].sendNotificationToSchool(schoolName[i])) {
                        System.out.print("Invitation Accepted by " + schoolName[i] + " \n");
                        eventFlag = true;
                    }
                    else
                        System.out.print("Invitation Rejected by "+ schoolName[i] +" \n");
                }

            }

            System.out.print("\nEnter number of student volunteers for event : ");
            int num = scan.nextInt();

            System.out.print("\n***** Payment *****");
            System.out.print("\ncost for student to attend the event : $10 ");
            System.out.print("\nEvent is free for volunteer students ");

            payment.studentPayment(num);


            if(eventFlag)
            {
                Student student = new Student();
                student.sendNotificationToStudents();

                System.out.print("\n****** Event State *****");
                System.out.print("\nEvent Starts\n");
                event.EventProgress();
            }
            else {
                System.out.print("No one accept your invitation");
            }

        }else {
            System.out.print("\nPlease First Register your school..!! ");
        }
    }
}
