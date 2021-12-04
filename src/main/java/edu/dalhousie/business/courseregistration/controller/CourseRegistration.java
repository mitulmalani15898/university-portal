package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.ValidateCourseRegistration;
import edu.dalhousie.business.courseregistration.database.CourseRegistrationApi;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.CourseRegistrationModel;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.PrintHeading;

import java.util.List;

public class CourseRegistration {
    StudentView view;
    CourseRegistrationModel courseRegistrationModel;
    CourseRegistrationApi courseRegistrationApi;
    ValidateCourseRegistration validate;

    public CourseRegistration() {
        view = new StudentView();
        courseRegistrationModel = new CourseRegistrationModel();
        courseRegistrationApi = new CourseRegistrationApi();
    }

    public int registerForSpecificCourse() throws Exception {
        String courseID = "";
        System.out.println("Enter course id for which you would like to enroll:");
        courseID = view.getString().toLowerCase();
        if (courseID.equals("no")) {
            return -1;
        } else if (validate.isValidCourseId(courseID)) {
            System.out.println("\nPlease try again and provide valid course id for registration.\n");
        } else {
            return courseRegistrationApi.registerForSpecificCourse(Integer.parseInt(courseID));
        }
        return -1;
    }

    public void renderRegisterForSpecificCourseForm() throws Exception {
        String userChoice = "";
        System.out.println("\n\nDo you want to register for courses? (Yes, No: quit)");
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals("no")) {
            if (userChoice.equals("yes")) {
                int result = registerForSpecificCourse();
                if (result == 1) {
                    System.out.println("\nRegistration successful.");
                    renderCourseListView(courseRegistrationModel.getRegisteredCourses());
                }
            }
            System.out.println("\nDo you want to register for course? (Yes, No: quit)");
            userChoice = view.getString().toLowerCase();
        }
    }

    public void renderSearchForParticularCourseView() throws Exception {
        String keyword = "";
        System.out.println("\nEnter keyword for searching courses? (type 'quit' to exit search)");
        keyword = view.getString().toLowerCase();
        while (!keyword.equals("quit")) {
            courseRegistrationApi.getCoursesByKeyword(keyword);
            renderCourseListView(courseRegistrationModel.getRegisteredCourses());
            System.out.println("\nEnter keyword for searching courses? (type 'quit' to exit search)");
            keyword = view.getString().toLowerCase();
        }
    }

    public void renderCourseListView(List<Course> courses) {
        System.out.format("\n%25s\n", "List of all courses".toUpperCase());
        System.out.format("%5s %15s\n", "ID", "Course name");
        int count = 0;
        for (Course course : courses) {
            System.out.format("%s.  %s | %s\n", ++count, course.getCourseId(), course.getCourseName());
        }
    }

    public String renderCourseRegistrationForm() {
        String userChoice = "";
        System.out.println("Do you want to search for particular course? (Yes, No: View complete list)");
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals("yes") && !userChoice.equals("no")) {
            System.out.println("Do you want to search for particular course? (Yes, No: View complete list)");
            userChoice = view.getString().toLowerCase();
        }
        return userChoice;
    }

    public void registerForCourses() throws Exception {
        StudentMainClass studentMainClass = new StudentMainClass();
        String userChoice = "";
        PrintHeading.printHeadingForTheScreen("List of courses for registration", 38);

        userChoice = renderCourseRegistrationForm();

        if (userChoice.equals("no")) {
            courseRegistrationApi.getCompleteCourseList();
            courseRegistrationApi.getRegisteredCourseList();
            renderCourseListView(courseRegistrationModel.getCourses());
            renderRegisterForSpecificCourseForm();
        } else if (userChoice.equals("yes")) {
            renderSearchForParticularCourseView();
        } else {
            studentMainClass.displayStudentMenu();
        }
        studentMainClass.displayStudentMenu();
    }
}
