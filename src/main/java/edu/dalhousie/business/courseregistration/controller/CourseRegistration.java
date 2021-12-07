package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.IValidateCourse;
import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.database.ICompleteCourseList;
import edu.dalhousie.business.courseregistration.database.IRegisterCourse;
import edu.dalhousie.business.courseregistration.database.IRegisteredCourseList;
import edu.dalhousie.business.courseregistration.database.ISpecificCourseList;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.ICourses;
import edu.dalhousie.business.courseregistration.model.IRegisteredCourses;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;
import edu.dalhousie.utilities.PrintHeading;

import java.util.List;

public class CourseRegistration implements ICourseRegistration {
    public int registerForSpecificCourse() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IValidateCourse validateCourse = CourseRegistrationFactory.getInstance().getValidateCourse();
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

    public void renderRegisterForSpecificCourseForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();

        String userChoice = "";
        view.showMessage(CourseRegistrationConstants.WANT_TO_REGISTER_FOR_COURSE);
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals(CourseRegistrationConstants.NO)) {
            if (userChoice.equals(CourseRegistrationConstants.YES)) {
                int result = registerForSpecificCourse();
                if (result == 1) {
                    view.showMessage(CourseRegistrationConstants.REGISTRATION_SUCCESSFUL);
                    renderCourseListView(registeredCourses.getRegisteredCourses());
                }
            }
            view.showMessage(CourseRegistrationConstants.WANT_TO_REGISTER_FOR_COURSE);
            userChoice = view.getString().toLowerCase();
        }
    }

    public void renderSearchForParticularCourseView() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();
        ISpecificCourseList specificCourseList = CourseRegistrationFactory.getInstance().getSpecificCourseList();

        String keyword = "";
        view.showMessage(CourseRegistrationConstants.ENTER_KEYWORD_FOR_SEARCHING_COURSE);
        keyword = view.getString().toLowerCase();
        while (!keyword.equals(CourseRegistrationConstants.QUIT)) {
            specificCourseList.getCoursesByKeyword(keyword);
            renderCourseListView(registeredCourses.getRegisteredCourses());
            view.showMessage(CourseRegistrationConstants.ENTER_KEYWORD_FOR_SEARCHING_COURSE);
            keyword = view.getString().toLowerCase();
        }
    }

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

    public String renderCourseRegistrationForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        String userChoice = "";
        view.showMessage(CourseRegistrationConstants.WANT_TO_SEARCH_FOR_SPECIFIC_COURSE);
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals(CourseRegistrationConstants.YES) && !userChoice.equals(CourseRegistrationConstants.NO)) {
            view.showMessage(CourseRegistrationConstants.WANT_TO_SEARCH_FOR_SPECIFIC_COURSE);
            userChoice = view.getString().toLowerCase();
        }
        return userChoice;
    }

    @Override
    public void registerForCourses() {
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        ICompleteCourseList completeCourseList = CourseRegistrationFactory.getInstance().getCompleteCourseList();
        IRegisteredCourseList registeredCourseList = CourseRegistrationFactory.getInstance().getRegisteredCourseList();

        String userChoice = "";
        PrintHeading.printHeadingForTheScreen(CourseRegistrationConstants.LIST_OF_COURSES_FOR_REGISTRATION, 38);
        userChoice = renderCourseRegistrationForm();
        if (userChoice.equals(CourseRegistrationConstants.NO)) {
            completeCourseList.getCompleteCourseList();
            registeredCourseList.getRegisteredCourseList();
            renderCourseListView(courses.getCourses());
            renderRegisterForSpecificCourseForm();
        } else if (userChoice.equals(CourseRegistrationConstants.YES)) {
            renderSearchForParticularCourseView();
        }
    }
}
