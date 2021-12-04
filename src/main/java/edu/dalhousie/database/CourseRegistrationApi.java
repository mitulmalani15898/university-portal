package edu.dalhousie.database;

import edu.dalhousie.models.Course;
import edu.dalhousie.models.CourseRegistrationModel;
import edu.dalhousie.utilities.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationApi {
    ExecuteQuery executeQuery;
    CourseRegistrationModel courseRegistrationModel;

    public CourseRegistrationApi() {
        executeQuery = new ExecuteQuery();
        courseRegistrationModel = new CourseRegistrationModel();
    }

    public List<Course> makeCoursesListFromResultSet(ResultSet rs) throws SQLException {
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseName(rs.getString("course_name"));
            course.setAvailableSeats(rs.getInt("available_seats"));
            course.setPreRequisiteCourseId(rs.getInt("prerequisite_course_id"));
            courses.add(course);
        }
        return courses;
    }

    public void getCompleteCourseList() throws SQLException {
        String query = String.format("SELECT * from %s", Constants.CoursesTable);
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        List<Course> courses = makeCoursesListFromResultSet(rs);
        courseRegistrationModel.setCourses(courses);
    }

    public int registerForSpecificCourse(int courseId) throws SQLException {
        int studentId = 2;
        String query = "INSERT INTO " + Constants.CourseEnrolledTable + "(student_id, course_id) VALUES(" + studentId + ", " + courseId + ")";
        return executeQuery.executeSQL(query);
    }

    public void getCoursesByKeyword(String keyword) throws SQLException {
        String query = "SELECT * from " + Constants.CoursesTable + " WHERE course_name LIKE '%" + keyword + "%'";
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        List<Course> courses = makeCoursesListFromResultSet(rs);
        courseRegistrationModel.setCourses(courses);
    }

    public void getRegisteredCourseList() throws SQLException {
        String query = "SELECT * from " + Constants.CoursesTable + " JOIN " + Constants.CourseEnrolledTable + " ON " + Constants.CoursesTable + ".course_id=" + Constants.CourseEnrolledTable + ".course_id WHERE " + Constants.CourseEnrolledTable + ".student_id=2";
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        List<Course> courses = makeCoursesListFromResultSet(rs);
        courseRegistrationModel.setRegisteredCourses(courses);
    }
}
