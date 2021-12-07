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
        view.showMessage(CourseRegistrationConstants.enterCourseIdForEnroll);
        courseID = view.getString().toLowerCase();
        if (courseID.equals(CourseRegistrationConstants.no)) {
            return -1;
        } else if (validateCourse.isValidCourseId(courseID)) {
            view.showMessage(CourseRegistrationConstants.provideValidCourseId);
        } else {
            return registerCourse.registerForSpecificCourse(Integer.parseInt(courseID));
        }
        return -1;
    }

    public void renderRegisterForSpecificCourseForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();

        String userChoice = "";
        view.showMessage(CourseRegistrationConstants.wantToRegisterForCourse);
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals(CourseRegistrationConstants.no)) {
            if (userChoice.equals(CourseRegistrationConstants.yes)) {
                int result = registerForSpecificCourse();
                if (result == 1) {
                    view.showMessage(CourseRegistrationConstants.registrationSuccessful);
                    renderCourseListView(registeredCourses.getRegisteredCourses());
                }
            }
            view.showMessage(CourseRegistrationConstants.wantToRegisterForCourse);
            userChoice = view.getString().toLowerCase();
        }
    }

    public void renderSearchForParticularCourseView() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();
        ISpecificCourseList specificCourseList = CourseRegistrationFactory.getInstance().getSpecificCourseList();

        String keyword = "";
        view.showMessage(CourseRegistrationConstants.enterKeywordForSearchingCourse);
        keyword = view.getString().toLowerCase();
        while (!keyword.equals(CourseRegistrationConstants.quit)) {
            specificCourseList.getCoursesByKeyword(keyword);
            renderCourseListView(registeredCourses.getRegisteredCourses());
            view.showMessage(CourseRegistrationConstants.enterKeywordForSearchingCourse);
            keyword = view.getString().toLowerCase();
        }
    }

    public void renderCourseListView(List<Course> courses) {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        view.showFormattedMessage("\n%25s\n", CourseRegistrationConstants.listOfAllCourses.toUpperCase());
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
        view.showMessage(CourseRegistrationConstants.wantToSearchForSpecificCourse);
        userChoice = view.getString().toLowerCase();
        while (!userChoice.equals(CourseRegistrationConstants.yes) && !userChoice.equals(CourseRegistrationConstants.no)) {
            view.showMessage(CourseRegistrationConstants.wantToSearchForSpecificCourse);
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
        PrintHeading.printHeadingForTheScreen(CourseRegistrationConstants.listOfCoursesTitle, 38);
        userChoice = renderCourseRegistrationForm();
        if (userChoice.equals(CourseRegistrationConstants.no)) {
            completeCourseList.getCompleteCourseList();
            registeredCourseList.getRegisteredCourseList();
            renderCourseListView(courses.getCourses());
            renderRegisterForSpecificCourseForm();
        } else if (userChoice.equals(CourseRegistrationConstants.yes)) {
            renderSearchForParticularCourseView();
        }
    }
}
