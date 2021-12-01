package edu.dalhousie.controllers;

import edu.dalhousie.database.CourseRegistrationApi;
import edu.dalhousie.models.CourseRegistrationModel;
import edu.dalhousie.presentation.CourseRegistrationView;
import edu.dalhousie.utilities.Utility;

public class CourseRegistration {
    CourseRegistrationView courseRegistrationView;
    CourseRegistrationModel courseRegistrationModel;
    CourseRegistrationApi courseRegistrationApi;

    public CourseRegistration() {
        courseRegistrationView = new CourseRegistrationView();
        courseRegistrationModel = new CourseRegistrationModel();
        courseRegistrationApi = new CourseRegistrationApi();
    }

    public void registerForCourses() throws Exception {
        StudentMainClass studentMainClass = new StudentMainClass();
        String userChoice = "";
        Utility.printHeadingForTheScreen("List of courses for registration", 38);

        userChoice = courseRegistrationView.renderCourseRegistrationForm();

        if (userChoice.equals("yes")) {
            courseRegistrationView.renderCompleteCourseListView();
        } else if (userChoice.equals("yes")) {

        } else {

        }
        studentMainClass.displayStudentMenu();

    }
}
