package edu.dalhousie.business.courseregistration.database;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.controller.CourseRegistrationFactory;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.ICourses;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegisteredCourseList implements IRegisteredCourseList {
    private static DatabaseConnection databaseConnection;

    @Override
    public void getRegisteredCourseList() {
        int studentId = 2;
        List<Course> courses = new ArrayList<>();
        ICourses coursesList = CourseRegistrationFactory.getInstance().getCourses();

        String query = CourseRegistrationConstants.GET_REGISTERED_COURSES_QUERY.replace("coursesTable", Constants.CoursesTable).replace("enrollmentTable", Constants.CourseEnrolledTable).replace("studentId", studentId + "");

        try {
            databaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                course.setAvailableSeats(resultSet.getInt("available_seats"));
                course.setPreRequisiteCourseId(resultSet.getInt("prerequisite_course_id"));
                courses.add(course);
            }
            coursesList.setCourses(courses);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(RegisteredCourseList.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
    }
}
