package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.database.ISpecificCourseList;
import edu.dalhousie.business.courseregistration.model.IRegisteredCourses;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;

public class SearchSpecificCourse implements ISearchSpecificCourse {
    @Override
    public void renderSearchForParticularCourseView() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();
        ISpecificCourseList specificCourseList = CourseRegistrationFactory.getInstance().getSpecificCourseList();
        ICourseListView courseListView = CourseRegistrationFactory.getInstance().getCourseListView();
        String keyword = "";

        view.showMessage(CourseRegistrationConstants.ENTER_KEYWORD_FOR_SEARCHING_COURSE);
        keyword = view.getString().toLowerCase();
        while (!keyword.equals(CourseRegistrationConstants.QUIT)) {
            specificCourseList.getCoursesByKeyword(keyword);
            courseListView.renderCourseListView(registeredCourses.getRegisteredCourses());
            view.showMessage(CourseRegistrationConstants.ENTER_KEYWORD_FOR_SEARCHING_COURSE);
            keyword = view.getString().toLowerCase();
        }
    }
}
