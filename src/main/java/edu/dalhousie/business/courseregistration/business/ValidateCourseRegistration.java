package edu.dalhousie.business.courseregistration.business;

import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.CourseRegistrationModel;

public class ValidateCourseRegistration {
    CourseRegistrationModel courseRegistrationModel;

    public ValidateCourseRegistration() {
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
}
