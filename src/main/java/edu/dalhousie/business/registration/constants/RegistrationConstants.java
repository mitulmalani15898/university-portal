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

    public static final String student = "student";
    public static final String faculty = "faculty";
    public static final String registerAsStudent = "Register as a student";
    public static final String registerAsFaculty = "Register as a faculty";
    public static final String verifyingDetails = "\nVerifying your details...";
    public static final String detailsVerified = "Details verified...\n";
    public static final String yourUsername = "Your username is 'username'.";
    public static final String pleaseLogin = "\nPlease login using your username and password to access your portal.\n";
    public static final String somethingWentWrong = "Something went wrong, please try again...\n";

    public static final String enterFirstName = "Enter your first name: ";
    public static final String enterLastName = "Enter your last name: ";
    public static final String enterEmail = "Enter your email address: ";
    public static final String enterContactNumber = "Enter your contact number: ";
    public static final String enterPassword = "Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ";
    public static final String enterConfirmPassword = "Verify your Password: ";
    public static final String validConfirmPassword = "Verify your Password (confirm password should be match with password): ";
    public static final String enterDOB = "Enter your Date of Birth: (MM-DD-YYYY): ";
    public static final String enterGender = "Enter your gender (1: Male, 2: Female, 3: Other): ";
    public static final String enterStreetAddress = "Enter your street address: ";
    public static final String enterApartmentNumber = "Enter your apartment number (if any): ";
    public static final String enterCity = "Enter your city: ";
    public static final String enterProvince= "Enter your province/state: ";
    public static final String enterZipcode = "Enter your zip code: ";

    public static final String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,20}$";

    public static final String insertUserQuery = "INSERT INTO tableName(first_name, last_name, email_address, contact_number, password, dob, gender, address, apartment_number, city, province, zip_code, user_name, type_of_user) VALUES(firstName, lastName, emailAddress, contactNumber, password, dateOfBirth, gender, address, apartmentNumber, city, province, zipCode, username, typeOfUser)";
}
