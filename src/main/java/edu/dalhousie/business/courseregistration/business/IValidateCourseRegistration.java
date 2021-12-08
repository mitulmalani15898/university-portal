package edu.dalhousie.business.courseregistration.business;

public interface IValidateCourseRegistration {
    boolean isValidCourseId(String courseId);

    boolean isInvalidChoice(String choice);
}
