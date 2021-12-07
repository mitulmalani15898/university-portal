package edu.dalhousie.business.courseregistration.business;

import edu.dalhousie.business.courseregistration.controller.CourseRegistrationFactory;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.ICourses;

public class ValidateCourse implements IValidateCourse {
    public boolean isValidCourseId(String courseId) {
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        for (Course course : courses.getCourses()) {
            if (course.getCourseId() == Integer.parseInt(courseId)) {
                return true;
            }
        }
        return false;
    }
}
