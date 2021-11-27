package edu.dalhousie.controllers;

import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

public class Registration {
    Utility utility = new Utility();
    StudentView view = new StudentView();
    WelcomeClass welcome = new WelcomeClass();

    private int userChoice;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String password;
    private String confirmPassword;
    private String dateOfBirth;
    private String gender;
    private String streetAddress;
    private String apartmentNumber;
    private String city;
    private String province;
    private String zipcode;
    private String username;

    private String createUsername(String firstName, String lastName) {
        return firstName + "." + lastName;
    }

    private void getUserInputs() {
        System.out.println("Enter your first name: ");
        firstName = view.getString();

        System.out.println("Enter your last name: ");
        lastName = view.getString();

        System.out.println("Enter your email address: ");
        email = view.getString();

        System.out.println("Enter your contact number: ");
        contactNumber = view.getString();

        System.out.println("Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ");
        password = view.getString();

        System.out.println("Verify your Password: ");
        confirmPassword = view.getString();

        System.out.println("Enter your Date of Birth: (MM-DD-YYYY): ");
        dateOfBirth = view.getString();

        System.out.println("Enter your gender (1: Male, 2: Female, 3: Other): ");
        gender = view.getString();

        System.out.println("Enter your street address: ");
        streetAddress = view.getString();

        System.out.println("Enter your apartment number (if any): ");
        apartmentNumber = view.getString();

        System.out.println("Enter your city: ");
        city = view.getString();

        System.out.println("Enter your province/state: ");
        province = view.getString();

        System.out.println("Enter your zip code: ");
        zipcode = view.getString();
    }

    public void registerUser(String typeOfRegistration) {
        String title = typeOfRegistration.equals("student") ? "Register as a student" : "Register as a faculty";
        utility.printHeadingForTheScreen(title, 38);

        getUserInputs();

        System.out.println("\nVerifying your details...");
        System.out.println("Details verified...\n");

        username = createUsername(firstName, lastName);

        System.out.println("Your username is \"" + username + "\"");
        System.out.println("\nPlease login using your username and password to access your portal.\n");
        System.out.println("Press '0' to go back\n");

        userChoice = view.getInt();
        if (userChoice == 0) {
            welcome.displayWelcomeScreen();
        }
    }
}
