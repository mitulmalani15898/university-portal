package edu.dalhousie.business.registration.database;

import edu.dalhousie.business.registration.model.RegistrationModel;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class RegistrationApi {
    private static DatabaseConnection databaseConnection;

    public int saveUserDetails(RegistrationModel registrationModel) {
        int result = -1;
        databaseConnection = DatabaseConnectivity.getInstance();

        String firstName = registrationModel.getFirstName();
        String lastName = registrationModel.getLastName();
        String email = registrationModel.getEmail();
        String contactNumber = registrationModel.getContactNumber();
        String password = registrationModel.getPassword();
        String dateOfBirth = registrationModel.getDateOfBirth();
        String gender = registrationModel.getGender();
        String streetAddress = registrationModel.getStreetAddress();
        String apartmentNumber = registrationModel.getApartmentNumber();
        String city = registrationModel.getCity();
        String province = registrationModel.getProvince();
        String zipcode = registrationModel.getZipcode();
        String username = registrationModel.getUsername();
        String typeOfUser = registrationModel.getTypeOfUser();

        String query = String.format("INSERT INTO %s(first_name, last_name, email_address, contact_number, password, dob, gender, address, apartment_number, city, province, zip_code, user_name, type_of_user) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", Constants.UsersTable, firstName, lastName, email, contactNumber, password, dateOfBirth, gender, streetAddress, apartmentNumber, city, province, zipcode, username, typeOfUser);

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
}
