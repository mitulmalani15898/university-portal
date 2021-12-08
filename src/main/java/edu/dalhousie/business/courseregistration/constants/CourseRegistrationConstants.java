package edu.dalhousie.business.courseregistration.constants;

import java.util.Arrays;
import java.util.List;

public class CourseRegistrationConstants {
    public static final List<String> yesNoList = Arrays.asList("yes", "no");
    public static final String LIST_OF_ALL_COURSES = "List of all courses";
    public static final String LIST_OF_COURSES_FOR_REGISTRATION = "List of courses for registration";
    public static final String NO = "no";
    public static final String YES = "yes";
    public static final String QUIT = "quit";
    public static final String WANT_TO_REGISTER_FOR_COURSE = "\nDo you want to register for course? (Yes, No: quit)";
    public static final String WANT_TO_SEARCH_FOR_SPECIFIC_COURSE = "Do you want to search for particular course? (Yes, No: View complete list)";
    public static final String ENTER_KEYWORD_FOR_SEARCHING_COURSE = "\nEnter keyword for searching courses? (type 'quit' to exit search)";
    public static final String ENTER_COURSE_ID_FOR_ENROLL = "Enter course id for which you would like to enroll:";
    public static final String REGISTRATION_SUCCESSFUL = "\nRegistration successful.";
    public static final String PROVIDE_VALID_COURSE_ID = "\nPlease try again and provide valid course id for registration.\n";
    public static final String SELECT_COURSES_QUERY = "SELECT * from tableName";
    public static final String REGISTER_COURSE_QUERY = "INSERT INTO tableName(student_id, course_id) VALUES(studentId, courseId)";
    public static final String GET_REGISTERED_COURSES_QUERY = "SELECT * from coursesTable JOIN enrollmentTable ON coursesTable.course_id=enrollmentTable.course_id WHERE enrollmentTable.student_id=studentId";
    public static final String SEARCH_SPECIFIC_COURSE_QUERY = "SELECT * from coursesTable WHERE course_name LIKE '%keyword%'";
}
