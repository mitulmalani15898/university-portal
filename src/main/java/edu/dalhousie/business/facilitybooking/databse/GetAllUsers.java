package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllUsers implements IGetAllUsers {
    private static DatabaseConnection databaseConnection;

    @Override
    public List<String> getAllUsers() {
        List<String> usernames = new ArrayList<>();
        databaseConnection = DatabaseConnectivity.getInstance();
        String query = FacilityBookingConstants.selectAllUsersQuery.replace("tableName", Constants.UsersTable);
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                usernames.add(resultSet.getString(FacilityBookingConstants.usernameColumn));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return usernames;
    }
}
