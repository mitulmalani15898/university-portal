package edu.dalhousie.presentation;

import edu.dalhousie.database.CourseRegistrationApi;
import edu.dalhousie.models.CourseRegistrationModel;

import java.sql.SQLException;
import java.util.Map;

public class CourseRegistrationView {
    StudentView view = new StudentView();
    CourseRegistrationApi courseRegistrationApi;
    CourseRegistrationModel courseRegistrationModel;

    public CourseRegistrationView() {
        courseRegistrationApi = new CourseRegistrationApi();
        courseRegistrationModel = new CourseRegistrationModel();
    }

    public boolean checkInvalidCourseId(String courseId) {
        System.out.println("hey " + courseRegistrationModel.getCourses().containsKey(Integer.parseInt(courseId)));
        return !courseRegistrationModel.getCourses().containsKey(Integer.parseInt(courseId));
    }

    public void registerForSpecificCourse() throws Exception {
        String courseID = "";
        System.out.println("Enter course id for which you would like to enroll:");
        courseID = view.getString();
        if (courseID.toLowerCase().equals("no")) {
            return;
        } else if (checkInvalidCourseId(courseID)) {
            System.out.println("\nPlease try again and provide valid course id for registration.");
        } else {
            courseRegistrationApi.registerForSpecificCourse(Integer.parseInt(courseID));
        }
    }

    public void renderRegisterForSpecificCourseForm() {
        String userChoice = "";
        System.out.println("\n\nDo you want to register for courses? (Yes, No: quit)");
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals("yes") && !userChoice.equals("no")) {
            System.out.println("\nDo you want to search for particular course? (Yes, No: View complete list)");
            userChoice = view.getString().toLowerCase();
        }
        if (userChoice.equals("yes")) {
            registerForSpecificCourse();

        } else {

        }

    }

    public void renderSearchForParticularCourseView() {

    }

    public void renderCompleteCourseListView() throws SQLException {
        courseRegistrationApi.getCompleteCourseList();
        System.out.format("%25s\n", "List of all courses".toUpperCase());
        System.out.format("%5s %15s\n", "ID", "Course name");
        int count = 0;
        for (Map.Entry<Integer, String> course : courseRegistrationModel.getCourses().entrySet()) {
            System.out.format("%s.  %s | %s\n", ++count, course.getKey(), course.getValue());
        }
        renderRegisterForSpecificCourseForm();
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
}
