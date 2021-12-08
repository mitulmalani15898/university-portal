package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;


import java.util.List;

public class CourseListView implements ICourseListView {
    @Override
    public void renderCourseListView(List<Course> courses) {
        IStudentView view = StudentView.getInstance();
        int count = 0;

        if (courses.size() > 0) {
            view.showFormattedMessage("\n%25s\n", CourseRegistrationConstants.LIST_OF_ALL_COURSES.toUpperCase());
            view.showFormattedMessage("%5s %15s\n", "ID", "Course name");
            for (Course course : courses) {
                String counter = ++count + "";
                String courseId = course.getCourseId() + "";
                String courseName = course.getCourseName();
                view.showFormattedMessage("%s.  %s | %s\n", counter, courseId, courseName);
            }
        } else {
            view.showMessage(CourseRegistrationConstants.NO_COURSES_FOUND_MESSAGE);
        }
    }
}
