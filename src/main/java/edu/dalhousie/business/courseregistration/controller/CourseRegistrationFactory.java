package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.ValidateCourse;
import edu.dalhousie.business.courseregistration.database.*;
import edu.dalhousie.business.courseregistration.model.*;

public class CourseRegistrationFactory {
    private static CourseRegistrationFactory courseRegistrationFactory = null;

    ICourseRegistration courseRegistration;
    ICourse course;
    ICourses courses;
    IRegisteredCourses registeredCourses;
    ValidateCourse validateCourse;
    ICompleteCourseList completeCourseList;
    IRegisteredCourseList registeredCourseList;
    ISpecificCourseList specificCourseList;
    IRegisterCourse registerCourse;

    public CourseRegistrationFactory() {
        courseRegistration = new CourseRegistration();
        course = new Course();
        courses = new Courses();
        registeredCourses = new RegisteredCourses();
        validateCourse = new ValidateCourse();
        completeCourseList = new CompleteCourseList();
        registeredCourseList = new RegisteredCourseList();
        specificCourseList = new SpecificCourseList();
        registerCourse = new RegisterCourse();
    }

    public static CourseRegistrationFactory getInstance() {
        if (courseRegistrationFactory == null) {
            courseRegistrationFactory = new CourseRegistrationFactory();
        }
        return courseRegistrationFactory;
    }

    public ICourseRegistration getCourseRegistration() {
        return courseRegistration;
    }

    public ICourse getCourse() {
        return course;
    }

    public ICourses getCourses() {
        return courses;
    }

    public IRegisteredCourses getRegisteredCourses() {
        return registeredCourses;
    }

    public ValidateCourse getValidateCourse() {
        return validateCourse;
    }

    public ICompleteCourseList getCompleteCourseList() {
        return completeCourseList;
    }

    public IRegisteredCourseList getRegisteredCourseList() {
        return registeredCourseList;
    }

    public ISpecificCourseList getSpecificCourseList() {
        return specificCourseList;
    }

    public IRegisterCourse getRegisterCourse() {
        return registerCourse;
    }
}
