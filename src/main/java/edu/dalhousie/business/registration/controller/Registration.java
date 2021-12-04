package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.business.ValidatePassword;
import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.database.RegistrationApi;
import edu.dalhousie.business.registration.model.RegistrationModel;
import edu.dalhousie.controllers.WelcomeClass;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.PrintHeading;

public class Registration {
    StudentView view;
    WelcomeClass welcome;
    RegistrationModel registrationModel;
    RegistrationApi registrationApi;
    ValidatePassword validatePassword;

    public Registration() {
        view = new StudentView();
        welcome = new WelcomeClass();
        registrationModel = new RegistrationModel();
        registrationApi = new RegistrationApi();
        validatePassword = new ValidatePassword();
    }

    private String createUsername(String firstName, String lastName) {
        return firstName + "." + lastName;
    }

    public void renderRegistrationForm(RegistrationModel registrationModel) {
        String password = "", confirmPassword = "", gender = "";

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
        while (!password.isEmpty() && validatePassword.isInvalidPassword(password)) {
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
//        registrationModel.setPassword(getHashedPassword(password));

        System.out.print("Enter your Date of Birth: (MM-DD-YYYY): ");
        registrationModel.setDateOfBirth(view.getString());

        gender = RegistrationConstants.genders.get(view.getString());
        System.out.print("Enter your gender (1: Male, 2: Female, 3: Other): ");
        registrationModel.setGender(gender);

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

    public void registerUser(String typeOfRegistration) throws Exception {
        int userChoice;
        boolean isStudent = typeOfRegistration.equals("student");

        String title = isStudent ? "Register as a student" : "Register as a faculty";

        PrintHeading.printHeadingForTheScreen(title, 38);

        renderRegistrationForm(registrationModel);
        registrationModel.setUsername(createUsername(registrationModel.getFirstName(), registrationModel.getLastName()));
        registrationModel.setTypeOfUser(isStudent ? "student" : "faculty");

        view.showMessage("\nVerifying your details...");
        int result = registrationApi.saveUserDetails(registrationModel);
        System.out.println("result: " + result);
        if (result == 1) {
            view.showMessage("Details verified...\n");
            view.showMessage("Your username is \"" + registrationModel.getUsername() + "\".");
            view.showMessage("\nPlease login using your username and password to access your portal.\n");
        } else {
            view.showMessage("Something went wrong, please try again...\n");
        }

        view.showMessage("Press '0' to go back");
        userChoice = view.getInt();
        if (userChoice == 0) {
            welcome.displayWelcomeScreen();
        }
    }
}
