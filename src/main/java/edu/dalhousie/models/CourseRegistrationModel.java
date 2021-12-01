package edu.dalhousie.models;

import java.util.Map;

public class CourseRegistrationModel {
    private static Map<Integer, String> courses;

    public Map<Integer, String> getCourses() {
        return courses;
    }

    public void setCourses(Map<Integer, String> courses) {
        this.courses = courses;
    }
}
