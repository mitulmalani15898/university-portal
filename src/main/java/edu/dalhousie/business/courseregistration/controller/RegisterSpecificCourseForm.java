package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.model.IRegisteredCourses;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;


public class RegisterSpecificCourseForm implements IRegisterSpecificCourseForm {
    @Override
    public void renderRegisterForSpecificCourseForm() {
        IStudentView view = StudentView.getInstance();
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();
        ICourseListView courseListView = CourseRegistrationFactory.getInstance().getCourseListView();
        IRegisterForCourse registerForCourse = CourseRegistrationFactory.getInstance().getRegisterForCourse();
        String userChoice = "";

        view.showMessage(CourseRegistrationConstants.WANT_TO_REGISTER_FOR_COURSE);
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals(CourseRegistrationConstants.NO)) {
            if (userChoice.equals(CourseRegistrationConstants.YES)) {
                int result = registerForCourse.registerForSpecificCourse();
                if (result == 1) {
                    view.showMessage(CourseRegistrationConstants.REGISTRATION_SUCCESSFUL);
                    courseListView.renderCourseListView(registeredCourses.getRegisteredCourses());
                }
            }
            view.showMessage(CourseRegistrationConstants.WANT_TO_REGISTER_FOR_COURSE);
            userChoice = view.getString().toLowerCase();
        }
    }
}
