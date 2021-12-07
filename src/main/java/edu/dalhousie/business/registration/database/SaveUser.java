package edu.dalhousie.business.registration.database;

import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.controller.RegistrationFactory;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class SaveUser implements ISaveUser {
    private static DatabaseConnection databaseConnection;

    public int saveUserDetails() {
        int result = -1;
        IUser user = RegistrationFactory.getInstance().getUser();

        String query = RegistrationConstants.INSERT_USER_QUERY
            .replace("tableName", Constants.USERS_TABLE)
            .replace("firstName", user.getFirstName())
            .replace("lastName", user.getLastName())
            .replace("emailAddress", user.getEmail())
            .replace("contactNumber", user.getContactNumber())
            .replace("password", user.getPassword())
            .replace("dateOfBirth", user.getDateOfBirth())
            .replace("gender", user.getGender())
            .replace("address", user.getStreetAddress())
            .replace("apartmentNumber", user.getApartmentNumber())
            .replace("city", user.getCity())
            .replace("province", user.getProvince())
            .replace("zipCode", user.getZipcode())
            .replace("username", user.getUsername())
            .replace("typeOfUser", user.getTypeOfUser());

        System.out.println("query " + query);
        try {
            databaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
//            result = statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }
}
