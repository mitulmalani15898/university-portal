package edu.dalhousie.business.courseregistration.database;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterCourse implements IRegisterCourse {
    private static DatabaseConnection databaseConnection;

    @Override
    public int registerForSpecificCourse(int courseId) {
        int result = -1;
        int studentId = 2;
        String query = CourseRegistrationConstants.REGISTER_COURSE_QUERY
            .replace("tableName", Constants.CourseEnrolledTable)
            .replace("studentId", studentId + "")
            .replace("courseId", courseId + "");

        try {
            databaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(RegisterCourse.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }
}
