package edu.dalhousie.presentation;

import edu.dalhousie.models.RegistrationModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationView {
    StudentView view = new StudentView();

    public boolean isInvalidPassword(String password) {
        String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }

    public String getGenderByNumber(String genderNumber) {
        int gender = Integer.parseInt(genderNumber);
        return gender == 1 ? "Male" : gender == 2 ? "Female" : "Other";
    }

    public String getHashesPassword(String password) {
        String hashesPassword = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            hashesPassword = new String(messageDigest.digest());
            System.out.println("hashesPassword: " + hashesPassword);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return hashesPassword;
    }

    public void renderRegistrationForm(RegistrationModel registrationModel) {
        String password = "", confirmPassword = "";

        System.out.print("Enter your first name: ");
        registrationModel.setFirstName(view.getString());

        System.out.print("Enter your last name: ");
        registrationModel.setLastName(view.getString());

        System.out.print("Enter your email address: ");
        registrationModel.setEmail(view.getString());

        System.out.print("Enter your contact number: ");
        registrationModel.setContactNumber(view.getString());

        System.out.print("Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ");
        password = view.getString();
        while (!password.isEmpty() && isInvalidPassword(password)) {
            System.out.print("Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ");
            password = view.getString();
        }
        registrationModel.setPassword(password);

        System.out.print("Verify your Password: ");
        confirmPassword = view.getString();
        while (!confirmPassword.equals(password)) {
            System.out.print("Verify your Password (confirm password should be match with password): ");
            confirmPassword = view.getString();
        }
        registrationModel.setConfirmPassword(confirmPassword);
//        registrationModel.setPassword(getHashesPassword(password));

        System.out.print("Enter your Date of Birth: (MM-DD-YYYY): ");
        registrationModel.setDateOfBirth(view.getString());

        System.out.print("Enter your gender (1: Male, 2: Female, 3: Other): ");
        registrationModel.setGender(getGenderByNumber(view.getString()));

        System.out.print("Enter your street address: ");
        registrationModel.setStreetAddress(view.getString());

        System.out.print("Enter your apartment number (if any): ");
        registrationModel.setApartmentNumber(view.getString());

        System.out.print("Enter your city: ");
        registrationModel.setCity(view.getString());

        System.out.print("Enter your province/state: ");
        registrationModel.setProvince(view.getString());

        System.out.print("Enter your zip code: ");
        registrationModel.setZipcode(view.getString());
    }
}
