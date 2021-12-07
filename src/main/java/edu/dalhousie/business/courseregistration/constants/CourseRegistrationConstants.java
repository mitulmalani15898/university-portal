package edu.dalhousie.business.courseregistration.constants;

import edu.dalhousie.utilities.Constants;

public class CourseRegistrationConstants {
    public static final String listOfAllCourses = "List of all courses";
    public static final String listOfCoursesTitle = "List of courses for registration";
    public static final String no = "no";
    public static final String yes = "yes";
    public static final String quit = "quit";
    public static final String wantToRegisterForCourse = "\nDo you want to register for course? (Yes, No: quit)";
    public static final String wantToSearchForSpecificCourse = "Do you want to search for particular course? (Yes, No: View complete list)";
    public static final String enterKeywordForSearchingCourse = "\nEnter keyword for searching courses? (type 'quit' to exit search)";
    public static final String enterCourseIdForEnroll = "Enter course id for which you would like to enroll:";
    public static final String registrationSuccessful = "\nRegistration successful.";
    public static final String provideValidCourseId = "\nPlease try again and provide valid course id for registration.\n";
    public static final String selectCoursesQuery = "SELECT * from tableName";
    public static final String registerCourseQuery = "INSERT INTO tableName(student_id, course_id) VALUES(studentId, courseId)";
    public static final String registeredCoursesQuery = "SELECT * from coursesTable JOIN enrollmentTable ON coursesTable.course_id=enrollmentTable.course_id WHERE enrollmentTable.student_id=studentId";
    public static final String searchSpecificCourseQuery = "SELECT * from coursesTable WHERE course_name LIKE '%keyword%'";
}
