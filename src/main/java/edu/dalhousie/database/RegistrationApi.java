package edu.dalhousie.database;

import edu.dalhousie.models.RegistrationModel;
import edu.dalhousie.utilities.Constants;

public class RegistrationApi {
    ExecuteQuery executeQuery;

    public RegistrationApi() {
        executeQuery = new ExecuteQuery();
    }

    public int saveUserDetails(RegistrationModel registrationModel) {
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

        String query = String.format("INSERT INTO %s VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", Constants.UsersTable, firstName, lastName, email, contactNumber, password, dateOfBirth, gender, streetAddress, apartmentNumber, city, province, zipcode, username);

        return 0;
    }
}
