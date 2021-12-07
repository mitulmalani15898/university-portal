package edu.dalhousie.business.registration.constants;

import java.util.HashMap;
import java.util.Map;

public class RegistrationConstants {
    public static final Map<Integer, String> genders = new HashMap<Integer, String>() {
        {
            put(1, "swimming");
            put(2, "badminton");
            put(3, "table tennis");
            put(4, "gym");
        }
    };

    public static final String STUDENT = "STUDENT";
    public static final String FACULTY = "FACULTY";
    public static final String REGISTER_AS_A_STUDENT = "Register as a STUDENT";
    public static final String REGISTER_AS_A_FACULTY = "Register as a FACULTY";
    public static final String VERIFYING_YOUR_DETAILS = "\nVerifying your details...";
    public static final String DETAILS_VERIFIED = "Details verified...\n";
    public static final String YOUR_USERNAME = "Your username is 'username'.";
    public static final String PLEASE_LOGIN = "\nPlease login using your username and password to access your portal.\n";
    public static final String SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN = "Something went wrong, please try again...\n";

    public static final String ENTER_FIRST_NAME = "Enter your first name: ";
    public static final String ENTER_LAST_NAME = "Enter your last name: ";
    public static final String ENTER_EMAIL = "Enter your email address: ";
    public static final String ENTER_CONTACT_NUMBER = "Enter your contact number: ";
    public static final String ENTER_PASSWORD = "Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ";
    public static final String ENTER_CONFIRM_PASSWORD = "Verify your Password: ";
    public static final String VALID_CONFIRM_PASSWORD = "Verify your Password (confirm password should be match with password): ";
    public static final String ENTER_DOB = "Enter your Date of Birth: (MM-DD-YYYY): ";
    public static final String ENTER_GENDER = "Enter your gender (1: Male, 2: Female, 3: Other): ";
    public static final String ENTER_STREET_ADDRESS = "Enter your street address: ";
    public static final String ENTER_APARTMENT_NUMBER = "Enter your apartment number (if any): ";
    public static final String ENTER_CITY = "Enter your city: ";
    public static final String ENTER_PROVINCE = "Enter your province/state: ";
    public static final String ENTER_ZIPCODE = "Enter your zip code: ";

    public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,20}$";

    public static final String INSERT_USER_QUERY = "INSERT INTO tableName(first_name, last_name, email_address, contact_number, password, dob, gender, address, apartment_number, city, province, zip_code, user_name, type_of_user) VALUES(firstName, lastName, emailAddress, contactNumber, password, dateOfBirth, gender, address, apartmentNumber, city, province, zipCode, username, typeOfUser)";
}
