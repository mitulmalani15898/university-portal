package edu.dalhousie.business.courseregistration.database;

import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.CourseRegistrationModel;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationApi {
    private static DatabaseConnection databaseConnection;
    CourseRegistrationModel courseRegistrationModel;

    public CourseRegistrationApi() {
        courseRegistrationModel = new CourseRegistrationModel();
    }

    public List<Course> makeCoursesListFromResultSet(ResultSet resultSet) {
        List<Course> courses = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                course.setAvailableSeats(resultSet.getInt("available_seats"));
                course.setPreRequisiteCourseId(resultSet.getInt("prerequisite_course_id"));
                courses.add(course);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return courses;
    }

    public void getCompleteCourseList() {
        databaseConnection = DatabaseConnectivity.getInstance();
        String query = String.format("SELECT * from %s", Constants.CoursesTable);
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Course> courses = makeCoursesListFromResultSet(resultSet);
            courseRegistrationModel.setCourses(courses);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public int registerForSpecificCourse(int courseId) {
        databaseConnection = DatabaseConnectivity.getInstance();
        int result = -1;
        int studentId = 2;
        String query = "INSERT INTO " + Constants.CourseEnrolledTable + "(student_id, course_id) VALUES(" + studentId + ", " + courseId + ")";
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }

    public void getCoursesByKeyword(String keyword) {
        databaseConnection = DatabaseConnectivity.getInstance();
        String query = "SELECT * from " + Constants.CoursesTable + " WHERE course_name LIKE '%" + keyword + "%'";
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Course> courses = makeCoursesListFromResultSet(resultSet);
            courseRegistrationModel.setCourses(courses);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public void getRegisteredCourseList() {
        databaseConnection = DatabaseConnectivity.getInstance();
        String query = "SELECT * from " + Constants.CoursesTable + " JOIN " + Constants.CourseEnrolledTable + " ON " + Constants.CoursesTable + ".course_id=" + Constants.CourseEnrolledTable + ".course_id WHERE " + Constants.CourseEnrolledTable + ".student_id=2";
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Course> courses = makeCoursesListFromResultSet(resultSet);
            courseRegistrationModel.setRegisteredCourses(courses);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
