package edu.dalhousie.presentation;

import edu.dalhousie.database.CourseRegistrationApi;
import edu.dalhousie.models.Course;
import edu.dalhousie.models.CourseRegistrationModel;

import java.util.List;

public class CourseRegistrationView {
    StudentView view;
    CourseRegistrationApi courseRegistrationApi;
    CourseRegistrationModel courseRegistrationModel;

    public CourseRegistrationView() {
        view = new StudentView();
        courseRegistrationApi = new CourseRegistrationApi();
        courseRegistrationModel = new CourseRegistrationModel();
    }

    public boolean isValidCourseId(String courseId) {
        for (Course course : courseRegistrationModel.getCourses()) {
            if (course.getCourseId() == Integer.parseInt(courseId)) {
                return true;
            }
        }
        return false;
    }

    public int registerForSpecificCourse() throws Exception {
        String courseID = "";
        System.out.println("Enter course id for which you would like to enroll:");
        courseID = view.getString().toLowerCase();
        if (courseID.equals("no")) {
            return -1;
        } else if (isValidCourseId(courseID)) {
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
            if (!keyword.equals("quit")) {
                courseRegistrationApi.getCoursesByKeyword(keyword);
                renderCourseListView(courseRegistrationModel.getRegisteredCourses());
            }
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
}
