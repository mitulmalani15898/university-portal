package edu.dalhousie.database;

import edu.dalhousie.models.RegistrationModel;
import edu.dalhousie.utilities.Constants;

import java.sql.SQLException;

public class RegistrationApi {
    ExecuteQuery executeQuery;

    public RegistrationApi() {
        executeQuery = new ExecuteQuery();
    }

    public int saveUserDetails(RegistrationModel registrationModel) throws SQLException {
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

        return executeQuery.executeSQL(query);
    }
}
