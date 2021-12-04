package edu.dalhousie.business.courseregistration.model;

import java.util.List;

public class CourseRegistrationModel {
    private static List<Course> courses;
    private static List<Course> registeredCourses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        CourseRegistrationModel.registeredCourses = registeredCourses;
    }
}
