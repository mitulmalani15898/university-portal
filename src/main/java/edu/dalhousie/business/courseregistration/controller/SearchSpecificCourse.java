package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.IValidateCourseRegistration;
import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.database.ISpecificCourseList;
import edu.dalhousie.business.courseregistration.model.ICourses;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class SearchSpecificCourse implements ISearchSpecificCourse {
    @Override
    public void renderSearchForParticularCourseView() {
        IStudentView view = StudentView.getInstance();
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        ISpecificCourseList specificCourseList = CourseRegistrationFactory.getInstance().getSpecificCourseList();
        ICourseListView courseListView = CourseRegistrationFactory.getInstance().getCourseListView();
        IValidateCourseRegistration validate = CourseRegistrationFactory.getInstance().getValidateCourseRegistration();
        String keyword = "";

        view.showMessage(CourseRegistrationConstants.ENTER_KEYWORD_FOR_SEARCHING_COURSE);
        keyword = view.getString().toLowerCase();
        while (validate.isValidKeyword(keyword)) {
            specificCourseList.getCoursesByKeyword(keyword);
            courseListView.renderCourseListView(courses.getCourses());
            view.showMessage(CourseRegistrationConstants.ENTER_KEYWORD_FOR_SEARCHING_COURSE);
            keyword = view.getString().toLowerCase();
        }
    }
}
