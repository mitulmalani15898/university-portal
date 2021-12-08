package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.IValidateCourseRegistration;
import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.database.IRegisterCourse;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;

public class RegisterForCourse implements IRegisterForCourse {
    @Override
    public int registerForSpecificCourse() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IValidateCourseRegistration validateCourse = CourseRegistrationFactory.getInstance().getValidateCourseRegistration();
        IRegisterCourse registerCourse = CourseRegistrationFactory.getInstance().getRegisterCourse();

        String courseID = "";
        view.showMessage(CourseRegistrationConstants.ENTER_COURSE_ID_FOR_ENROLL);
        courseID = view.getString().toLowerCase();
        if (courseID.equals(CourseRegistrationConstants.NO)) {
            return -1;
        } else if (validateCourse.isValidCourseId(courseID)) {
            view.showMessage(CourseRegistrationConstants.PROVIDE_VALID_COURSE_ID);
        } else {
            return registerCourse.registerForSpecificCourse(Integer.parseInt(courseID));
        }
        return -1;
    }
}
