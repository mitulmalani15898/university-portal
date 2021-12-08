package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;

import java.util.List;

public class CourseListView implements ICourseListView {
    @Override
    public void renderCourseListView(List<Course> courses) {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        view.showFormattedMessage("\n%25s\n", CourseRegistrationConstants.LIST_OF_ALL_COURSES.toUpperCase());
        view.showFormattedMessage("%5s %15s\n", "ID", "Course name");
        int count = 0;
        for (Course course : courses) {
            String counter = ++count + "";
            String courseId = course.getCourseId() + "";
            String courseName = course.getCourseName();
            view.showFormattedMessage("%s.  %s | %s\n", counter, courseId, courseName);
        }
    }
}
