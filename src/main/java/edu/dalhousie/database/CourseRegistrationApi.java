package edu.dalhousie.database;

import edu.dalhousie.models.CourseRegistrationModel;
import edu.dalhousie.utilities.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CourseRegistrationApi {
    ExecuteQuery executeQuery;
    CourseRegistrationModel courseRegistrationModel;

    public CourseRegistrationApi() {
        executeQuery = new ExecuteQuery();
        courseRegistrationModel = new CourseRegistrationModel();
    }

    public void getCompleteCourseList() throws SQLException {
        Map<Integer, String> courses = new HashMap<>();
        String query = String.format("SELECT * from %s", Constants.CoursesTable);
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while (rs.next()) {
            courses.put(rs.getInt("course_id"), rs.getString("course_name"));
        }
        courseRegistrationModel.setCourses(courses);
    }

    public int registerForSpecificCourse(int courseId) throws SQLException {
        int studentId = 2;
        String query = "INSERT INTO " + Constants.CourseEnrolled + "(student_id, course_id) VALUES(" + studentId + ", " + courseId + ")";
        return executeQuery.executeSQL(query);
    }

    public void getCoursesByKeyword(String keyword) throws SQLException {
        Map<Integer, String> courses = new HashMap<>();
        String query = "SELECT * from " + Constants.CoursesTable + " WHERE course_name LIKE '%" + keyword + "%'";
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while (rs.next()) {
            courses.put(rs.getInt("course_id"), rs.getString("course_name"));
        }
        courseRegistrationModel.setCourses(courses);
    }
}
